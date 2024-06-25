import java.util.*;
import java.io.*;

public class FileReading1 {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<String>();
        readFile(employees);
        displayEmployees(employees);
    }
    static void displayEmployees(ArrayList<String> employees){
        for(String employee: employees)
            System.out.println(employee);
    }
    static void readFile(ArrayList<String> employees){
        String line = "";
        BufferedReader fileInput = null;

        try{
            fileInput = new BufferedReader(new FileReader(new File("C:/employees.txt")));
            line = fileInput.readLine();
            while (line != null){
                employees.add(line);
                line = fileInput.readLine();
            }
            fileInput.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        catch (EOFException eofe) {
            System.out.println("No more lines to read.");
        }
        catch(IOException ioe) {
            System.out.println("Error reading file.");
        }
    }
}