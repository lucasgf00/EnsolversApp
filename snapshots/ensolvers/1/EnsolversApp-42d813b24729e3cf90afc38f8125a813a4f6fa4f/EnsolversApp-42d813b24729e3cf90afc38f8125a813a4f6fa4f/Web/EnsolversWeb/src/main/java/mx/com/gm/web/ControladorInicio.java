package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.servicio.TodoService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private TodoService todoService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var todo = todoService.listarTodo();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("todo", todo);
        for(var t:todo){
        }
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Todo todo) {
        return "modificar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Todo todo, Errors errores) {
        if(errores.hasErrors()){
            return "modificar";
        }
        todoService.guardar(todo);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idTodo}")
    public String editar(Todo todo, Model model) {
        todo = todoService.encontrarTodo(todo);
        model.addAttribute("todo", todo);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Todo todo) {
        todoService.eliminar(todo);
        return "redirect:/";
    }
}