package interfaces;

import java.io.File;

@FunctionalInterface
public interface FileFilter {
    boolean accept(File file);
}
