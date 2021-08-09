/**
 * Write a description of class Part3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3
{
    public boolean twoOccurrences(String stringa, String stringb){
        boolean result = false;
        int count=0,index,x;
        index = stringb.indexOf(stringa);
        if(index != -1)
            count++;
        x = stringb.indexOf(stringa , index + stringa.length());
        if(index != x && x != -1)
            count++;
        if(count>1)
            result = true;
        return result;
    }
    
    public void lastPart(String stringa, String stringb){
        int index = stringb.lastIndexOf(stringa);
        if(index != -1)
        System.out.println("New String : " + stringb.substring(index));        
        else
        System.out.println("New String : " + stringb);
    }

    public void testing(){
        String stringa = "an", stringb = "banana";
        System.out.println("String : " + stringb + "\nSearchable word : " + stringa);
        System.out.println("Result : " + twoOccurrences(stringa, stringb));
        lastPart(stringa, stringb);
    }
}
