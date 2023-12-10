import java.io.*;
import java.util.*;
import java.lang.System;


public class Cities {
    
    // TODO: Next step: Remove the enum completely and change the rest of the classes to
    // use the cityCount() function instead of cities.length
    // All instances of Cities.cities need to be replaced with a for loop and an int
    // Need to figure out how to acces Cities through BruteForce
    
    

    static enum cities { Emden, Groningen, Lingen, Emmen, Waddeneilanden, Leeuwarden, Sneek, DenHelder, Zwolle,
    Lelystad, Enschede, Haarlem, Amsterdam, Utrecht, Arnhem, Nijmegen, DenBosch, Maastricht, Rotterdam, DenHaag,
    Eindhoven, Duisburg, Breda, Antwerpen, Liege, Turnhout, Roermond, Middelburg, Aarschot, Hasselt };

    static String[] names;
    
    public Cities() {
        names = new String[]{"Emden", "Groningen", "Lingen", "Emmen", "Waddeneilanden", "Leeuwarden", "Sneek", "Den Helder", "Zwolle",
    "Lelystad", "Enschede", "Haarlem", "Amsterdam", "Utrecht", "Arnhem", "Nijmegen", "Den Bosch", "Maastricht", "Rotterdam", "Den Haag",
    "Eindhoven", "Duisburg", "Breda", "Antwerpen", "Liège", "Turnhout", "Roermond", "Middelburg", "Aarschot", "Hasselt"}; 

    }

    public int cityCount() {
        return names.length;
    }

    public int lookup(String name)
    {
        
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name.trim())) {
                return i;
            }
        }
        return -1;
    }

    public Cities(String configFileName) {
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
            names = line.split(",");

            for (int i = 0; i < names.length; i++) {
                names[i] = names[i].trim();
            }
            System.out.println( "Cities: " + Arrays.toString(names));
        }

        System.out.println("Reading conncections");

       
    }


}
    