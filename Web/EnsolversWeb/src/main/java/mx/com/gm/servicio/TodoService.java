package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Todo;

public interface TodoService {
    
    public List<Todo> listarTodo();
    
    public void guardarTodo(Todo todo);
    
    public void eliminarTodo (Todo todo);
    
    public Todo encontrarTodo(Todo todo);
    
}
