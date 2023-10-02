package worker;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import input.FilePathExtensionsInput;
import interfaces.FileFilter;;

public class FileExtensionCounter {
    public static void StartCount() {
        try (Scanner scanner = new Scanner(System.in)) {

            FilePathExtensionsInput userFilePathInput = new FilePathExtensionsInput(scanner);

            String dirPath = userFilePathInput.getUserDirPathInput();
            String[] extensions = userFilePathInput.getUserDirExtInput();

            FileFilter extensionFilter = file -> {
                for (String extension : extensions) {
                    if (file.getName().toLowerCase().endsWith(extension.trim().toLowerCase())) {
                        return true;
                    }
                }
                return false;
            };

            File directory = new File(dirPath);
            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();

                if (files != null) {
                    // Карта для підрахунку кількості файлів за кожним розширенням
                    Map<String, Integer> extensionCountMap = new HashMap<>();

                    for (File file : files) {
                        if (file.isFile() && extensionFilter.accept(file)) {
                            String fileExtension = FileExtensionGetter.getFileExtension(file);
                            extensionCountMap.put(fileExtension, extensionCountMap.getOrDefault(fileExtension, 0) + 1);
                            System.out.println("Знайдено файл: " + file.getName());
                        }
                    }

                    // Вивести результати підрахунку
                    System.out.println("\nКількість файлів за кожним розширенням:");
                    for (Map.Entry<String, Integer> entry : extensionCountMap.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " файл(ів)");
                    }
                } else {
                    System.out.println("Каталог порожній або не містить файлів.");
                }
            } else {
                System.out.println("Вказаний шлях не існує або не є каталогом.");
            }
        }
    }
}
