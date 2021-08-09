import edu.duke.*;
import org.apache.commons.csv.*;

/**
 * Write a description of sample here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sample {

    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //countryInfo(parser, "Germany");
/*        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));*/
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }

    public void countryInfo(CSVParser parser, String Country){
        String country,export,value;
        for(CSVRecord a : parser){
            country = a.get("Country");
            export = a.get("Exports");
            value = a.get("Value (dollars)");
            if(country.contains(Country))
                System.out.println(country + " " + export + " " + value);
            
        }
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1,String exportItem2){
        String item1,item2,country;
        for(CSVRecord record : parser){
            item1 = record.get("Exports");
            item2 = record.get("Exports");
            country =record.get("Country");
            if(item1.contains(exportItem1) && item2.contains(exportItem2))
            System.out.println(country);
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for(CSVRecord record : parser){
            String item = record.get("Exports");
            if(item.contains(exportItem))
            count++;
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String value){
        String val,country;
        for(CSVRecord record : parser){
            val = record.get("Value (dollars)");
            if(val.length() > value.length())
            System.out.println(record.get("Country") + " " + val);
        }
    }
}
