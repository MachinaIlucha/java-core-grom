package lesson4.DZ.Controller;

import lesson4.DZ.DAO.FileDAO;
import lesson4.DZ.model.File;
import lesson4.DZ.model.Storage;

import java.util.List;

public class Controller {

    private File put(Storage storage, File file) throws Exception {
        return FileDAO.save(storage, file);
    }

    private void putAll(Storage storage, List<File> files) throws Exception {
        for (File file : files) {
            FileDAO.save(storage, file);
        }
    }

    private void delete(Storage storage, File file) {
        FileDAO.delete(file.getId());
    }

    private void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        FileDAO.transferAll(storageFrom, storageTo);
    }

    private File transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        return FileDAO.transferFile(storageFrom, storageTo, id);
    }
}
