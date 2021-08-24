package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Folder;

public interface FolderService {
    
    public List<Folder> listarFolder();
    
    public void guardarFolder(Folder folder);
    
    public void eliminarFolder(Folder folder);
    
    public Folder encontrarFolder(Folder folder);
    
}
