package mx.com.gm.dao;

import mx.com.gm.domain.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderDao extends JpaRepository<Folder, Long>{
    
}
