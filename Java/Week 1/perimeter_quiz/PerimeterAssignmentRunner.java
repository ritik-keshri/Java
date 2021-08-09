import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int points=0;
        for (Point currPt : s.getPoints())
            points += 1;
        return points;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        int points = getNumPoints(s);
        return length/points;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double largestSide=0;
        for(Point currPt : s.getPoints()){
            if(largestSide < prevPt.distance(currPt))
                largestSide = prevPt.distance(currPt);            
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0;
        for(Point currPt : s.getPoints()){
            if(largestX < currPt.getX())
                largestX = currPt.getX();
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter=0;
        for (File f : dr.selectedFiles()) {
            FileResource fi= new FileResource(f);
            Shape s = new Shape(fi);            
            double length = getPerimeter(s);
            if(length > largestPerimeter) 
                largestPerimeter = length;         
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        String fileName = null;
        double largestPerimeter=0,length;
        for (File f : dr.selectedFiles()) {
            FileResource fi= new FileResource(f);
            Shape s = new Shape(fi);            
            length = getPerimeter(s);
            if(length > largestPerimeter){
                largestPerimeter = length;
                fileName = f.getName();
            }
        }
        return fileName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points = getNumPoints(s);
        System.out.println("Points = " + points);
        double avgLength = getAverageLength(s);
        System.out.println("Average Length = " + avgLength);
        double largestSide = getLargestSide(s);
        System.out.println("Largest Side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("Largest X Cordinate = " + largestX);    /*
        testPerimeterMultipleFiles();        
        testFileWithLargestPerimeter();  */
    }

    public void testPerimeterMultipleFiles() {
        // Put code here
        double largest = getLargestPerimeterMultipleFiles();
        System.out.println("Largest Perimeter in Multiple Files = " + largest);        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String fileName = getFileWithLargestPerimeter();
        System.out.println("Largest Perimeter FileName = " + fileName);        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
