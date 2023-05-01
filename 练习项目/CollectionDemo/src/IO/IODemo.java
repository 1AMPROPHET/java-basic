package IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Visual Studio\\vscode\\project\\java-basic\\a.txt");
        fos.write(97);
        fos.close();
    }
}
