package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.TodoDao;
import mx.com.gm.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoDao todoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Todo> listarTodo() {
        return (List<Todo>) todoDao.findAll();
    }

    @Override
    @Transactional
    public void guardarTodo(Todo todo) {
        todoDao.save(todo);
    }

    @Override
    @Transactional
    public void eliminarTodo(Todo todo) {
        todoDao.delete(todo);
    }

    @Override
    @Transactional(readOnly = true)
    public Todo encontrarTodo(Todo todo) {
        return todoDao.findById(todo.getIdTodo()).orElse(null);
    }
    
    
}
