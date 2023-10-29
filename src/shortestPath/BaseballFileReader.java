package shortestPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseballFileReader {
    /**
     * Parses the target csv file and generates an arraylist of all possible routes
     * @param filePath Name of the target csv file
     * @return ArrayList of all possible flight routes between cities
     **/
    public ArrayList<Connection> readFile(String filePath) {
        File file = new File(filePath);
        ArrayList<Connection> routes = new ArrayList<Connection>();

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                //read in the next line
                String curr_line = input.nextLine();
                //split the line by comma
                String[] elements = curr_line.split(",");
                //create a new connection by using the elements in the current line
                Connection new_entry = new Connection(elements[0], elements[1].trim(), Integer.parseInt(elements[2].trim()));
                //add to possible routes
                routes.add(new_entry);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return routes;
    }
}
