import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

/**
 * Write a description of class babyNames here.
 *
 * @author (Ritik)
 * @version (a version number or a date)
 */
public class babyNames
{
    public void totalBirths(FileResource fr){
        int totalBirths=0,totalBoys=0,totalGirls=0,totalNames=0,girl=0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalNames++;
            totalBirths += numBorn;
            if(rec.get(1).equals("F")){
                girl++;
                totalGirls += numBorn;            
            }
            else
                totalBoys += numBorn;
        }
        System.out.println("Total Births : " + totalBirths);
        System.out.println("Total Girls : " + totalGirls);
        System.out.println("Total Boys : " + totalBoys);
        System.out.println("Total Names : " + totalNames + " G: "+girl+" B "+ (totalNames-girl));

    }

    public void testTotalBirths(){
        totalBirths(new FileResource());
    }

    public int getRank(int year, String name, String gender){
        int rank = 0;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for(CSVRecord rec : fr.getCSVParser(false)){    
            if(rec.get(1).equals(gender))
                rank++;
            if(rec.get(0).equals(name) && rec.get(1).equals(gender))
                return rank;
        }
        return rank;
    }

    public void testGetRank(){
        int year=1982;
        String name="Leonel",gender="M";
        System.out.println(getRank(year, name, gender));
    }

    public String getName(int year, int rank, String gender){
        int ran = 0;
        FileResource fr = new FileResource("yob" + year + ".csv");
        for(CSVRecord rec : fr.getCSVParser(false)){       
            if(rec.get(1).equals(gender))
            ran++;
            if(rank == ran && rec.get(1).equals(gender))
                return rec.get(0);
        }
        return "NO NAME";
    }

    public void testGetName(){
        int year=1982,rank = 450;
        String gender="M";
        System.out.println(getName(year, rank, gender));
    }

    public String whatIsNameInYear(String name, int year, int newYear, String gender){
        FileResource fr = new FileResource("yob" + newYear + ".csv");
        String nam = null;
        int ran = getRank(year, name, gender);
        int rank = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){     
            if(rec.get(1).equals(gender))
            rank++;
            if(rank == ran && rec.get(1).equals(gender))
                return rec.get(0);
        }
        return "";
    }

    public void testWhatIsNameInYear(){
        int year = 1974, newYear = 2014;  
        String name = "Owen", gender = "M";
        System.out.println(name + " born in " + year + " would be " + whatIsNameInYear(name, year, newYear, gender) + " if she was born in " + newYear);
    }

    public int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int minRank = 0, maxRank = 0, year = 0, currYear = 0;
        String fname;
        for(File f : dr.selectedFiles()){     
            FileResource fr = new FileResource(f);
            fname = f.getName();            
            currYear = Integer.parseInt(fname.substring(3,7));
            maxRank = getRank(currYear, name, gender);
            if(year == 0){
                minRank = maxRank;
                year = currYear;
            }
            if(minRank >= maxRank){
                minRank = maxRank;
                year = currYear;
            }            
        }
        return year;
    }

    public void testYearOfHighestRank(){
        String name = "Mich", gender = "M";
        System.out.println(yearOfHighestRank(name, gender));
    }

    public double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        String fname;
        double rank = 0;
        int count = 0, year = 0;
        for(File f : dr.selectedFiles()){     
            FileResource fr = new FileResource(f); 
            fname = f.getName();            
            year = Integer.parseInt(fname.substring(3,7));
            rank += getRank(year, name, gender);  

            count++;
        }
        return rank/count;
    }

    public void testGetAverageRank(){
        String name = "Robert", gender = "M";
        System.out.println(getAverageRank(name, gender));
    }

    public int getTotalBirthsRankedHigher(int year, String name,String gender){
        FileResource fr = new FileResource("yob" + year + ".csv"); 
        int rank = 0,total = 0,ran = 0;
        for(CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
                rank = getRank(year, name, gender);               
            }
        }
        for(CSVRecord rec : fr.getCSVParser(false)){            
            if(rec.get(1).equals(gender)){
                ran++;
                if(ran < rank)
                    total += Integer.parseInt(rec.get(2));                
            }
        }
        return total;
    }

    public void testGetTotalBirthsRankedHigher(){
        int year = 1990;
        String name = "Mich", gender = "M";
        System.out.println(getTotalBirthsRankedHigher(year, name, gender));
    }
}
