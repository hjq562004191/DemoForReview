package File;

import java.io.File;

public class 递归遍历目录下的所有文件 {
    public static void main(String[] args) {
        File file = new File("D:\\JavaProject");
        AllFiles(file);
    }

    public static void AllFiles(File file) {
        if (file.isFile()) {
            System.out.println(file.getName());
        } else {
            for (File f : file.listFiles()
            ) {
                AllFiles(f);
            }
        }
    }
}
