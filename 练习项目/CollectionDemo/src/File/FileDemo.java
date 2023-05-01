package File;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        // 1.根据字符串，文件保存路径
        String str = "D:\\Visual Studio\\vscode\\project\\java-basic\\a.txt";
        File f1 = new File(str);
        System.out.println(f1);

        // 2.父级路径：D:\Visual Studio\vscode\project\java-basic
        // 子级路径：a.txt
        String parent = "D:\\Visual Studio\\vscode\\project\\java-basic";
        String child = "a.txt";
        File f2 = new File(parent, child);
        System.out.println(f2);

        // 手动拼接
        File f3 = new File(parent + "\\" + child);
        System.out.println(f3);

        // 3.把一个File表示的路径和String路径拼接
        File parent2 = new File("D:\\Visual Studio\\vscode\\project\\java-basic");
        String child2 = "a.txt";
        File f4 = new File(parent2, child2);
        System.out.println(f4);
    }
}
