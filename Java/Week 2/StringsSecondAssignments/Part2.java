import edu.duke.*;
import java.lang.*;

/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb){
        int noOfTimes=0,x=0;
        x = stringb.indexOf(stringa);
        if(x == -1)
            return 0;
        else{
            stringb = stringb.substring(x+stringa.length(),stringb.length());
            noOfTimes++;
            while(noOfTimes < stringb.length()){
                x = stringb.indexOf(stringa);
                if( x!= -1){
                    noOfTimes++;
                    stringb = stringb.substring(x+stringa.length(),stringb.length());
                }
                else
                    break;
            }
            return noOfTimes;
        }
    }

    public void testCountGenes(){
        System.out.println(howMany("TG","CTGCCTGCATGATCGTA"));
       /* System.out.println(howMany("ATG", "ATGHATATGKJHSAATG"));
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));*/
    }
}
