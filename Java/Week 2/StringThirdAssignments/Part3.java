import edu.duke.*;
import java.lang.*;

/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {

    int index=0;
    StorageResource sr = new StorageResource();
    public float cgRatio(String dna){
        int noOfC=0,noOfG=0;
        for(int i=0; i<dna.length(); i++){
            if(dna.charAt(i) == 'C')
                noOfC++;
            if(dna.charAt(i) == 'G')
                noOfG++;
        }
        return (float)noOfC/noOfG;
    }

    public void processGenes(StorageResource sr){
        int noOfString=0,noOfCG=0,min,max=0;
        for(String s : sr.data())
        {
            min=s.length();
            if(s.length()>60)
            {
                System.out.println("String : " + s);
                noOfString++;
            }
            if(cgRatio(s) > 0.35)
                noOfCG++;
            if(min>max)
                max = min;
        }
        System.out.println("No of CG Ratio > 0.35 : " + noOfCG);
        System.out.println("No of String lentgh > 60 are : " + noOfString);
        System.out.println("Maximum length : " + max);
    }

    public void testProcessGenes(){
        FileResource fr = new FileResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        String dna = fr.asString();
        getAllGenes(dna.toUpperCase());
        processGenes(sr);
    }
    
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

    public void getAllGenes(String dna){
        String s = findGene(dna);
        while(true){        
            if(index<dna.length() && s !=""){
                index += s.length();                
                sr.add(s);
                s = findGene(dna.substring(index, dna.length()));
            }
            else
                break;
        }
    }
}
