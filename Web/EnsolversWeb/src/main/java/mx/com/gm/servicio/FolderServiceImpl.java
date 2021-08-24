package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.FolderDao;
import mx.com.gm.domain.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service 
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderDao folderDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Folder> listarFolder() {
        return (List<Folder>) folderDao.findAll();
    }

    @Override
    @Transactional
    public void guardarFolder(Folder folder) {
        folderDao.save(folder);
    }

    @Override
    @Transactional
    public void eliminarFolder(Folder folder) {
        folderDao.delete(folder);
    }

    @Override
    @Transactional(readOnly = true)
    public Folder encontrarFolder(Folder folder) {
        return folderDao.findById(folder.getIdFolder()).orElse(null);
    }
    
}
