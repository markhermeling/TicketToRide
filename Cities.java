import javax.crypto.Cipher;
import java.io.*;
import java.util.*;
import java.lang.System;


public class Cities {

    // TODO: Next step: Remove the enum completely and change the rest of the classes to
    // use the cityCount() function instead of cities.length
    // All instances of Cities.cities need to be replaced with a for loop and an int
    // Need to figure out how to acces Cities through BruteForce

     List<String> names = new ArrayList<>();

    public  int size;

    public List<City> cities = new ArrayList<>();

    public  int cityCount() {
        return cities.size();
    }

    public  City lookup(String string) // Finds the city that the string is related to
    {
        for (City c: cities) {
            if (Objects.equals(string, c.name))
                return c;
        }
        return null;
    }
    public  void getCities(String configFileName){
        // We read the cities from the config file here
        System.out.println("Reading config file: " + configFileName);
        File configFile = null;
        Scanner reader = null;

        try {
            configFile = new File(configFileName);
            reader = new Scanner(configFile);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        if (reader.hasNext()) {
            // The first line has the list of cities
            String line = reader.nextLine();
            String[] str = line.split(",");
            for (String s : str) {
                names.add(s.trim());
            }
            size = names.size();
            System.out.println( "Cities: " );
            for (int i = 0; i < names.size(); i++) {
                City c =  new City (i,names.get(i).trim());
                cities.add(c);
                System.out.print(c.name + ", ");
            }

        }
        System.out.println("Reading connections");

    }
}