import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class MostPopularPath {
    DestinationCards dc = new DestinationCards();
    Dijkstra d = new Dijkstra(new Board());

    List<Cities.cities> currentPath = new ArrayList<>();

    private ArrayList<ArrayList<Cities.cities>> AllDestinations = dc.getAllDestinations();

     int[][]mostPopularPath = new int[Cities.cities.values().length][Cities.cities.values().length];
    public void pathCalculation() throws IOException {
        for (int i = 0; i < Cities.cities.values().length; i++) {
            for (int j = 0; j < Cities.cities.values().length; j++) {
                mostPopularPath[i][j] = 0;
            }
        }
        int count = 0;


        for (int i = 0; i < AllDestinations.size() -1; i++) {
            Cities.cities x = AllDestinations.get(i).get(0);
            Cities.cities y = AllDestinations.get(i).get(1);
            currentPath = d.shortestPath(x,y,false);
            for (int j = 0; j < currentPath.size() - 1; j++) {
                int f = currentPath.get(j).ordinal(); // from
                int t = currentPath.get(j+1).ordinal(); // to
                mostPopularPath[f][t]++;
                mostPopularPath[t][f]++;
            }
            count++;
        }
        File csvFile = new File("AllPaths.csv");
        FileWriter csvWriter = new FileWriter(csvFile);
        for (int i = 0; i < Cities.cities.values().length; i++) {
            for (int j = 0; j < Cities.cities.values().length; j++) {
                if (mostPopularPath[i][j] != 0){
                    csvWriter.write(Cities.names[i]+ "," +Cities.names[j] + "," + mostPopularPath[i][j] + "\n");
                }
            }
        }
    }
}
