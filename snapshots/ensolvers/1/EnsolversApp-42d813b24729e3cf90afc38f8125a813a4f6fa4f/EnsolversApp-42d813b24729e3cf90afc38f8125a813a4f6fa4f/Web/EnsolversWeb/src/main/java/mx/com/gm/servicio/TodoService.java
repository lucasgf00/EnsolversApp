package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Todo;

public interface TodoService {
    
    public List<Todo> listarTodo();
    
    public void guardar(Todo todo);
    
    public void eliminar (Todo todo);
    
    public Todo encontrarTodo(Todo todo);
}
