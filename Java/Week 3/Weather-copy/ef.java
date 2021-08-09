
/**
 * Write a description of class ef here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ef extends abc implements bcd
{
    // instance variables - replace the example below with your own
    private int x = 5;
    private int y =1;

    public ef()
    {
        x = 0;
    }
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    
    public void sample(){
        System.out.println("as");
    }
    
     public int sampleMetho(int y){
         return x+y;
     }
    
    public void main(){
        System.out.println(sampleMethod(y));
        System.out.println(sampleMetho(2));
    }
}
