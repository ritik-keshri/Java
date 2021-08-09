import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

/**
 * Write a description of maxTemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class maxTemp {

    public CSVRecord hotestHourInFile(CSVParser parser){
        CSVRecord largestSoFar = null;
        for(CSVRecord temp : parser){
            if(largestSoFar == null)
                largestSoFar = temp;
            else{
                double minTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                double maxTemp = Double.parseDouble(temp.get("TemperatureF"));
                if(minTemp > maxTemp)
                    largestSoFar = temp;                
            }
        }
        return largestSoFar;
    }

    public void testHotesHourInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = hotestHourInFile(parser);
        System.out.println(csv.get("TemperatureF"));
    }

}
