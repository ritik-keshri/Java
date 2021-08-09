import edu.duke.*;
import java.io.File;
import java.lang.*;
import org.apache.commons.csv.*;

/**
 * Write a description of minTemp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class minTemp {

    //Comparision of the 2 given temperature.
    public CSVRecord getLowestTempOfTwo(CSVRecord temp, CSVRecord lowestTemp ){
        if(lowestTemp == null)
            lowestTemp = temp;
        else{
            double low = Double.parseDouble(lowestTemp.get("TemperatureF"));
            double low2 = Double.parseDouble(temp.get("TemperatureF"));
            if(low > low2 && low != -9999 && low2 != -9999)
                lowestTemp = temp;
        }           
        return lowestTemp;   
    }

    //Finding the coldest at particular date mentioned.
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord lowestTemp = null;
        for(CSVRecord temp : parser)
            lowestTemp = getLowestTempOfTwo(temp, lowestTemp);
        return lowestTemp;
    }

    //Printing the coldest hour at date mentioned.
    public void testColdestHourInFile(){
        FileResource f = new FileResource();
        CSVRecord lowest = coldestHourInFile(f.getCSVParser());
        System.out.println("Min temp : " + lowest.get("TemperatureF"));
    }

    //Finding the coldest at more than one date mentioned.
    public String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();  
        String fileName = null;
        CSVRecord lowestTemp = null;        
        FileResource fr = null;
        for(File f : dr.selectedFiles()){
            fr = new FileResource(f);
            CSVRecord temp = coldestHourInFile(fr.getCSVParser());                
            lowestTemp = getLowestTempOfTwo(temp, lowestTemp);
            fileName = f.getName();
        }
        System.out.println("Coldest day was in file " + fileName);
        System.out.println("Coolest temp on that day was " + lowestTemp.get("TemperatureF"));        
        System.out.println("All the temperature on that day were :");
        for(CSVRecord record : fr.getCSVParser())
            System.out.println(record.get("DateUTC")+ " " +record.get("TemperatureF"));
        return fileName;
    }

    //Calling the method to find min tempeture of more than 1 days.
    public void testFileWithColdestTemperature(){
        String fileName = fileWithColdestTemperature();
    }

    //NULL POINTER EXCEPTION
    //finding the lowest humidity of given 2 humidity.
    public CSVRecord getLowestHumidityOfTwo(CSVRecord humidity, CSVRecord lowestHumidity ){
        if(lowestHumidity == null)
            lowestHumidity = humidity;
        if(lowestHumidity.get("Humidity") == "N/A" )
            return humidity;
        else if(humidity.get("Humidity") == "N/A")
            return lowestHumidity;
        else{
            double min = Double.parseDouble(lowestHumidity.get("Humidity"));
            double max = Double.parseDouble(humidity.get("Humidity"));
            if(min > max)
                lowestHumidity = humidity;            
            return lowestHumidity; 
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser){    
        CSVRecord lowestHumidity = null;
        for(CSVRecord humidity : parser)
            lowestHumidity = getLowestHumidityOfTwo(humidity, lowestHumidity);      
        return lowestHumidity;
    }

    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity")+" at "+csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestHumidity = null;
        for( File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord humidity = lowestHumidityInFile(fr.getCSVParser());
            if(humidity.get("Humidity") == "N/A")
                continue;
            if(lowestHumidity == null)
                lowestHumidity = humidity;
            else          
                lowestHumidity = getLowestHumidityOfTwo(humidity, lowestHumidity);                                     
        }
        return lowestHumidity;
    }

    public void testLowestHumidityInManyFiles(){
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity")+" at " + csv.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser){
        double avg=0;
        for(CSVRecord record : parser)
            avg += Double.parseDouble(record.get("TemperatureF"));
        return avg/24;
    }

    public void testAverageTemperatureInFile(){
        FileResource f = new FileResource();
        double avg = averageTemperatureInFile(f.getCSVParser());
        if(avg != 0)        
            System.out.println(avg);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double avg=0;
        int x=0;
        for(CSVRecord record : parser){
            if(Double.parseDouble(record.get("Humidity")) >= value){
                avg += Double.parseDouble(record.get("TemperatureF"));
                x++;
            } 
        }
        if(x == 0){
            System.out.println("No temperatures with that humidity");
            x=1;
        }
        return avg/x;
    }

    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource f = new FileResource();
        int value = 80;
        double avg = averageTemperatureWithHighHumidityInFile(f.getCSVParser(), value);
        if(avg != 0)        
            System.out.println(avg);
    }

}
 