package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Todo;
import mx.com.gm.domain.Folder;
import mx.com.gm.servicio.FolderService;
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
    
    @Autowired
    private FolderService folderService;
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var todo = todoService.listarTodo();
        var folder = folderService.listarFolder();
        log.info("ejecutando el controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("todo", todo);
        model.addAttribute("folder", folder);
        for(var t:todo)
        for(var f:folder){
        }
        return "index";
    }
    
    @GetMapping("/agregar")
    public String agregar(Todo todo, Folder folder) {
        return "modificar";
    }
    
    @PostMapping("/guardarTodo")
    public String guardarTodo(@Valid Todo todo, Errors errores) {
        if(errores.hasErrors()){
            return "modificarTodo";
        }
        todoService.guardarTodo(todo);
        return "redirect:/";
    }
    
    @PostMapping("/guardarFolder")
    public String guardarFolder(@Valid Folder folder, Errors errores) {
        if(errores.hasErrors()){
            return "modificarFolder";
        }
        folderService.guardarFolder(folder);
        return "redirect:/";
    }
    
    @GetMapping("/editarTodo/{idTodo}")
    public String editarTodo(Todo todo, Model model) {
        todo = todoService.encontrarTodo(todo);
        model.addAttribute("todo", todo);
        return "modificarTodo";
    }
    
    @GetMapping("/editarFolder/{idFolder}")
    public String editarFolder(Model model, Folder folder) {
        folder = folderService.encontrarFolder(folder);
        model.addAttribute("folder", folder);
        return "modificarFolder";
    }
    
    @GetMapping("/eliminarTodo")
    public String eliminarTodo(Todo todo, Folder folder) {
        todoService.eliminarTodo(todo);
        folderService.eliminarFolder(folder);
        return "redirect:/";
    }
    
    //@GetMapping("/eliminarFolder")
    //public String eliminarFolder(Folder folder) {
    //    folderService.eliminarFolder(folder);
    //    return "redirect:/";
    //}
}   