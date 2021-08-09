import edu.duke.*;
import java.lang.*;

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    int count=0,index=0;
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);       
        while(currIndex != -1){
            if((currIndex-startIndex) % 3 == 0)
                return currIndex; 
            currIndex = dna.indexOf(stopCodon, currIndex + 3);
        }
        return  dna.length();
    }
    
    public String findGene(String dna){
        int startIndex = dna.indexOf("ATG");
        if(startIndex == -1)
            return "";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = taaIndex;
        if(taaIndex > tagIndex)
            minIndex = tagIndex;
        if(minIndex > tgaIndex)
            minIndex = tgaIndex;
        index += startIndex;
        if(minIndex != dna.length()) 
            return dna.substring(startIndex, minIndex+3);
        else
            return "";
    }
    
    public void printAllGenes(String dna){
        String s = findGene(dna);
        while(true){        
            if(index<dna.length() && s !=""){
                index += s.length();  
                count++;
                s = findGene(dna.substring(index, dna.length()));
            }
            else
                break;
        }
    }
    
    public int countGenes(String dna){
        printAllGenes(dna);
        return count;
    }
    
    public void testCountGenes(){
        System.out.println(countGenes("ATGTASAJHATGTGAAATGTAG"));
        count=0;
    }
}

