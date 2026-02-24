package pro1;

import java.io.File;

public class Main {

    static void main() {
        File dir = new File("input");
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileManagement fm = new FileManagement(file.getPath());
                    fm.processAndSave("output");
                }
            }
        }
    }
}
