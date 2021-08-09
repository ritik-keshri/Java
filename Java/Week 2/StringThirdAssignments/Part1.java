import edu.duke.*;
import java.lang.*;

/**
 * Write a description of class Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1
{
    int index=0;
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);       
        while(currIndex != -1){
            if((currIndex-startIndex) % 3 == 0)
                return currIndex; 
            currIndex = dna.indexOf(stopCodon, currIndex + 3);
        }
        return  dna.length();
    }

    public void testFindStopCodon(){   
        String dna = "ATGAATGTAATTGA";
        int startIndex = dna.indexOf("ATG");
        String stopCodon = "TAA";       
        while(true){
            if((dna.indexOf(stopCodon, startIndex + 3) - startIndex) % 3 != 0 && startIndex != -1)
                startIndex = dna.indexOf("ATG",startIndex+3);
            else{
                System.out.println(findStopCodon(dna, startIndex, stopCodon));
                break;
            }
        }
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

    public void testFindGene(){
        String dna = "ATGTAAAATGTGAAAATGTAG";
        //printAllGenes(dna);
        getAllGenes(dna);
    }

    public void printAllGenes(String dna){
        String s = findGene(dna);
        while(true){        
            if(index<dna.length() && s !=""){
                index += s.length();                
                System.out.println(s);
                s = findGene(dna.substring(index, dna.length()));
            }
            else
                break;
        }
    }
    
    public StorageResource getAllGenes(String dna){
        StorageResource st = new StorageResource();
        String s = findGene(dna);
        while(true){        
            if(index<dna.length() && s !=""){
                index += s.length();                
                st.add(s);
                s = findGene(dna.substring(index, dna.length()));
            }
            else
                break;
        }
        for(String sr : st.data())
        System.out.println(sr);
        return st;
    }
}