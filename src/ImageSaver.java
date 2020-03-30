import edu.duke.ImageResource;

import java.io.File;

public class ImageSaver {
  public static void doSave(String prefix, File file, ImageResource image) {
    String newFileName = prefix + file.getName();
    image.setFileName(newFileName);
    image.save();
  }
}
