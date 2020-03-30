import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class InverseConvertor {
  public ImageResource makeInversion(ImageResource input) {
    ImageResource output = new ImageResource(input.getWidth(), input.getHeight());

    for (Pixel pixel : output.pixels()) {
      Pixel inputPixel = input.getPixel(pixel.getX(), pixel.getY());

      pixel.setRed(255 - inputPixel.getRed());
      pixel.setGreen(255 - inputPixel.getGreen());
      pixel.setBlue(255 - inputPixel.getBlue());
    }

    return output;
  }

  public void selectAndConvert() {
    DirectoryResource dr = new DirectoryResource();
    for (File file: dr.selectedFiles()) {
      ImageResource inImage = new ImageResource(file);
      ImageResource gray = makeInversion(inImage);
      ImageSaver.doSave("invert-", file, gray);
    }
  }
}
