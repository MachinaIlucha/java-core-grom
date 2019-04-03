package lesson19.dz;

public class Controller {
    public Controller() {
    }

    public File put(Storage storage, File file) throws Exception {
        //добавляет файл в хранилище , гарантируется что файл уже есть в условной БД
        if (file == null)
            throw new Exception("Can't put file 'couse it's null");

        validateFile(storage, file);

        validateSize(storage, file);

        if (!validateFormat(storage, file)) {
            throw new Exception("Format of " + file.getId() + "don't apply in storage " + storage.getId());
        }

        if (checkCountOfNulls(storage) < 1)
            throw new Exception("File " + file.getId() + " can't be put 'couse size of " + storage.getId() + " is crowded");

        int index = 0;
        for (File fl : storage.getFiles()) {
            if (fl == null) {
                storage.getFiles()[index] = file;
                break;
            }
            index++;
        }
        return storage.getFiles()[index];
    }

    public void delete(Storage storage, File file) throws Exception {

        boolean isExist = false;
        for (File fl : storage.getFiles()) {
            if (fl != null && fl.equals(file)) {
                isExist = true;
                break;
            }
        }

        if (!isExist)
            throw new Exception("File does not exist in storage " + storage.getId() + ". Can't be deleted");

        int index = 0;
        for (File fl : storage.getFiles()) {
            if (fl != null && fl.equals(file)) {
                storage.getFiles()[index] = null;
            }
            index++;
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        //трансфер всех файлов
        int i = 0;
        for (File fl : storageFrom.getFiles()) {
            if (fl != null)
                i++;
        }

        if (i > checkCountOfNulls(storageTo))
            throw new Exception("Can't transfer files from " + storageFrom.getId() + " 'couse no size in storage " + storageTo.getId());

        validateEveryFormat(storageFrom, storageTo);

        checkFilesInStorage(storageFrom, storageTo);

        if (getSize(storageFrom) > (storageTo.getStorageSize() - getSize(storageTo)))
            throw new Exception("Storage " + storageTo.getId() + " is crowded");

        for (int p = 0; p < storageFrom.getFiles().length; p++) {
            if (storageFrom.getFiles()[p] != null) {
                for (int j = 0; j < storageTo.getFiles().length; j++) {
                    if (storageTo.getFiles()[j] == null) {
                        storageTo.getFiles()[j] = storageFrom.getFiles()[p];
                        delete(storageFrom, storageFrom.getFiles()[p]);
                        break;
                    }
                }
            }
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        //трансфер файла с хранилища storageFrom по его айди
        File file = findFile(storageFrom, id);

        if (checkCountOfNulls(storageTo) < 1)
            throw new Exception("Can't transfer file " + file.getId() + " 'couse no size in storage " + storageTo.getId());

        validateSize(storageTo, file);

        if (!validateFormat(storageTo, file))
            throw new Exception("Format of file " + file.getId() + " not allowed in storage " + storageTo.getId());

        validateFile(storageTo, file);

        int index = 0;
        for (File file1 : storageTo.getFiles()) {
            if (file1 == null) {
                storageTo.getFiles()[index] = file;
                delete(storageFrom, file);
                break;
            }
            index++;
        }
    }

    private boolean validateFormat(Storage storage, File file) {
        for (String format : storage.getFormatsSupported()) {
            if (file != null && format.equals(file.getFormat()))
                return true;
        }
        return false;
    }

    private void validateFile(Storage storage, File file) throws Exception {
        File[] files = storage.getFiles();

        for (File file1 : files) {
            if (file1 != null && file1.equals(file))
                throw new Exception("File " + file.getId() + "is already in" + storage.getId());
        }
    }

    private void validateEveryFormat(Storage storage, Storage storageTo) throws Exception {
        File[] files = storage.getFiles();

        for (File file : files) {
            if (file != null && !validateFormat(storageTo, file))
                throw new Exception("Some file in Storage " + storage.getId() + " has different format than formats in Storage " + storageTo.getId());
        }
    }

    private File findFile(Storage storage, long id) {
        File[] files = storage.getFiles();

        for (File file : files) {
            if (file != null && file.getId() == id)
                return file;
        }
        return null;
    }

    private void checkFilesInStorage(Storage storageFrom, Storage storageTo) throws Exception {
        File[] files = storageFrom.getFiles();
        File[] files2 = storageTo.getFiles();

        for (File file1 : files) {
            if (file1 != null) {
                for (File file2 : files2) {
                    if (file2 != null && file2 == file1)
                        new Exception("File " + file1.getId() + " already in storage " + storageTo.getId());
                }
            }
        }
    }

    private long getSize(Storage storage) {
        File[] files = storage.getFiles();

        long size = 0;

        for (File file1 : files) {
            if (file1 != null)
                size += file1.getSize();
        }
        return size;
    }

    private void validateSize(Storage storage, File file) throws Exception {
        long size = storage.getStorageSize() - getSize(storage);

        if (file.getSize() > size)
            throw new Exception("File " + file.getId() + " can't put in storage " + storage.getId());
    }

    private int checkCountOfNulls(Storage storage) {
        File[] files = storage.getFiles();
        int i = 0;

        for (File file : files) {
            if (file == null)
                i++;
        }
        return i;
    }
}