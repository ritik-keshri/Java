import java.lang.String;
import java.util.*;

public class Part2
{
    public String findSimpleGene(String dna, int startCodon, int stopCodon){
        if(startCodon == -1)
            return "1";
        if(stopCodon == -1)
            return "1";
        String Dna = dna.substring(startCodon , stopCodon+3);
        if(Dna.length() % 3 == 0)
            return Dna;
        else
            return "";
    }

    public void testSimpleGene(){        
        String dna = "atgsadtaa",gene,Dna;
        int startCodon, stopCodon;
        Dna = dna.toLowerCase();
        if(dna.equals(Dna)){
            startCodon = dna.indexOf("atg");
            stopCodon = dna.indexOf("taa", startCodon+3);
            System.out.println("DNA is : " + dna);
            gene = findSimpleGene(Dna, startCodon, stopCodon);
            System.out.println("Gene is : " + gene);
        }
        else
        {
            startCodon = dna.indexOf("ATG");
            stopCodon = dna.indexOf("TAA", startCodon+3);
            System.out.println("DNA is : " + dna);
            gene = findSimpleGene(dna, startCodon, stopCodon);
            System.out.println("Gene is : " + gene);
        }
    }
}
