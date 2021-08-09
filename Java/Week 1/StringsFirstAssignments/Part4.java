
import edu.duke.*;
import java.io.File;
import java.lang.*;

/**
 * Write a description of class Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */4
public class Part4  
{
    public void find(){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String word : ur.words()) {
            int x = word.toLowerCase().indexOf("youtube.com");
            if(x != -1){
                int y = word.lastIndexOf("\"",x);
                if(y != -1){
                    int z = word.indexOf("\"",x);
                System.out.println(word.substring(y,z+1));
                }
            }
        }
    }
}