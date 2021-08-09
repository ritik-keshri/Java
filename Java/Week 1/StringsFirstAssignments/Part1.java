import java.lang.String;

public class Part1
{
    public String findSimpleGene(String s){
        int startingIndex = s.indexOf("ATG");
        if(startingIndex == -1)
            return "";
        int endingIndex = s.indexOf("TAA");
        if(endingIndex == -1)
            return "";
        String dna = s.substring(startingIndex , endingIndex+3);
        if(dna.length() % 3 == 0)
            return dna;
        else
            return "";
    }

    public void testSimpleGene(){
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA is : " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        /*
        dna = "ATGJKDJFDKJHADS";
        System.out.println("DNA is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna ="JKASHDJKASDJKH";
        System.out.println("DNA is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna ="ATGASDTAA";
        System.out.println("DNA is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);
        
        dna = "ADATGASTAA";
        System.out.println("DNA is : " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is : " + gene);*/
    }
}
