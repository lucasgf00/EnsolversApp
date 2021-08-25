package mx.com.gm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "todo")
public class Todo {
    
    public Todo() {
        
    }
    
    public Todo(String task) {
        this.task = task;
    }

    public Folder getFolder() {
        return folder;
    }
    
    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public static long getIdTodo(int idTodo) {
        return idTodo;
    }

    public void setIdTodo() {
        this.idTodo = idTodo;
    }
    
    @Override
    public String toString() {
        return "idTodo=" + idTodo + ", task=" + task;
    }
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTodo;
    
    @NotEmpty
    private String task;
    
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name="folderid")
    private Folder folder;
}
