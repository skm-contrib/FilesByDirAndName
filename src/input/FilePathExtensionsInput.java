package input;

import java.util.Scanner;

public class FilePathExtensionsInput {
    Scanner scanner;

    public FilePathExtensionsInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getUserDirPathInput() {
        System.out.print("Введiть шлях до каталогу: ");
        String dirPath = scanner.nextLine();

        return dirPath;
    }

    public String[] getUserDirExtInput() {

        System.out.print("Введiть розширення файлiв (через кому): ");
        String[] extensions = scanner.nextLine().split(",");
        return extensions;
    }

}
