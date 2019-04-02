package lesson19.dz;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        File file1 = new File(99423098, "video", "mp3", 720);
        File file2 = new File(92524398, "text", "txt", 21);
        File file3 = new File(98531098, "video", "dvd", 1080);
        File file4 = new File(91423098, "video2", "mp4", 240);
        File file5 = new File(90645198, "video3", "mp3", 720);
        File file6 = new File(97222298, "picture", "jpeg", 4000);


        File file7 = new File(99765598, "video", "mp3", 720);
        File file8 = new File(22222228, "text", "mp3", 21);
        File file9 = new File(96456778, "video", "mp3", 1080);
        File file10 = new File(22111111, "video", "mp3", 240);
        File file11 = new File(97975464, "video3", "mp3", 720);
        File file12 = new File(74687369, "picture", "mp3", 4000);

        File[] files = {file1, file2, file3 ,file5, file6};
        File[] files2 = {file7, file8, file9, null, null, null, null, file10, null, file11};

        String[] formats = {"mp3", "mp4", "txt", "dvd", "jpeg"};

        Storage storage = new Storage(12311344, files, formats, "Germany", 10000);
        Storage storage2 = new Storage(31541344, files, formats, "Ukraine", 15000);
        Storage storage3 = new Storage(31265344, files, formats, "Sweden", 3000);
        Storage storage4 = new Storage(12311344, files, formats, "Poland", 20000);

        Storage storage5 = new Storage(43555544, files2, formats, "Germany", 10000);
        Storage storage6 = new Storage(12543642, files2, formats, "Ukraine", 15000);
        Storage storage7 = new Storage(78864565, files2, formats, "Sweden", 3000);
        Storage storage8 = new Storage(86567534, files2, formats, "Poland", 20000);

        Storage[] storages = {storage, storage2, storage3, storage4};

        Storage[] storages2 = {storage5, storage6, storage7, storage8};


        File newFile = new File(423426631, "picture", "jpeg", 4000);
        File newFile2 = new File(42356686, "picture", "jpeg", 4000);

        Controller controller = new Controller();

        System.out.println("---------------------------------");

        System.out.println(Arrays.toString(storage.getFiles()));
        System.out.println();

        System.out.println(Arrays.toString(storage5.getFiles()));
        System.out.println();

        controller.transferAll(storage,storage5);

        System.out.println(Arrays.toString(storage5.getFiles()));

    }
}
