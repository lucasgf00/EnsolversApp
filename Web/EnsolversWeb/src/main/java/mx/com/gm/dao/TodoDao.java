package mx.com.gm.dao;

import mx.com.gm.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoDao extends JpaRepository<Todo, Long>{
    
}
