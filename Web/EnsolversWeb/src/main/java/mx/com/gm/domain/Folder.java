package mx.com.gm.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "folder")
public class Folder implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    
    public void  agregarTask(Todo task) {
        if(todo == null) todo= new ArrayList<>();
        
        todo.add(task);
        
        task.setFolder(this);
        
    } 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFolder;
    
    @NotEmpty
    private String folder_name;
    
    @OneToMany(mappedBy="folder", cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    private List<Todo> todo;
    
}
