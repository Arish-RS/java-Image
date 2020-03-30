import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class GrayScaleConverter {
  public ImageResource makeGray(ImageResource inImage) {
    ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());

    for (Pixel pixel : outImage.pixels()) {
      Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());

      int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
      pixel.setRed(average);
      pixel.setGreen(average);
      pixel.setBlue(average);
    }

    return outImage;
  }

  public void selectAndConvert() {
    DirectoryResource dr = new DirectoryResource();
    for (File file: dr.selectedFiles()) {
      ImageResource inImage = new ImageResource(file);
      ImageResource gray = makeGray(inImage);
      ImageSaver.doSave("gray-", file, gray);
    }
  }

  public void testMakeGray() {
    ImageResource ir = new ImageResource();
    ImageResource gray = makeGray(ir);
    gray.draw();
  }
}
