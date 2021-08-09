import edu.duke.*;
import java.io.*;

/**
 * Write a description of class GrayScaleConveter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class GrayScaleConverter{
    
    public ImageResource makeGray(ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for(Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int avg = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
            pixel.setRed(avg);
            pixel.setBlue(avg);
            pixel.setGreen(avg);
        }
        return outImage;
    }
    
    public void doSave(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fName = image.getFileName();
            String newName = "copy-" + fName;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
    
    public void testGray(){
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeGray(inImage);
            String fName = inImage.getFileName();
            String newName = "gray-" + fName;
            outImage.setFileName(newName);
            outImage.save();
            outImage.draw();
        }
    }
}