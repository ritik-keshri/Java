import edu.duke.*;

/**
 * Write a description of class Part4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part4  
{
    public void find(){
        String s = "\"youtube.com\"";
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String line : ur.lines()) {
            for(String word : ur.words()){
                if(word.equals(s))
                    System.out.println("Found");
                else
                    System.out.println("Not Found");
            }
        }
    }
}
