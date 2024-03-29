
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class BruteForce extends Algorithm {

    
    private List<CostPath> paths;



    BruteForce(Board b) {
        super(b);
        paths = new ArrayList<CostPath>();
    }   

    public void printShortestPath()
    {
        Collections.sort(paths, (Comparator.<CostPath>
        comparingInt(path1 -> path1.cost)).thenComparingInt(path2 -> path2.cost));
        if (paths.isEmpty())
        {
            System.out.println("No paths found");
            return;
        }
        System.out.println("Shortest Path: " + paths.get(0).cost + " : " + paths.get(0).path);
        System.out.println("Longest Path: " + paths.get(paths.size()-1).cost + " : " + paths.get(paths.size()-1).path);
        System.out.println("Number of paths: " + paths.size());
    
    }

    public void listPaths()
    {
        Collections.sort(paths, (Comparator.<CostPath>
        comparingInt(path1 -> path1.cost)).thenComparingInt(path2 -> path2.cost));
        for (CostPath cp :paths) {
            System.out.print("Cost: " + cp.cost);
            System.out.print(" Path: ");
            for (City c : cp.path) {
                System.out.print(c.name +"-");
            }
            System.out.println();
        }

    }

    public void shortestPath(City start, City end) {

        List<City> visited = new ArrayList<>();
        visited.add(start);
        long startTime = System.nanoTime();
        shortestPath(start, end, 0, visited, 0);
        long endTime = System.nanoTime();
        
        System.out.println("BruteForce Shortest Path calculation time: " + (endTime-startTime) + "ns");
        return;
    }

    public void shortestPath(City start, City end, int cost, List<City> visited, int level) {
     //   System.out.println("BruteForce Shortest Path: level " + level);

        // Iterate over all cities
        for (City c : b.myCities.cities) {
            
            // The cost to go from start to the next step (c)
            int nextStep = b.getBoard(start, c);

            if (visited.contains(c)) {
                // Already visited this city
                // This is crucial step, otherwise the recursion never ends
                // DO nothing
            }
            else if (nextStep > 0 && c == end) {
                // If the cost != 0 and c is the end, then we are there
                // We have reached the end
                // Return the cost and the path
                CostPath cp = new CostPath(cost + nextStep,new ArrayList<City>(visited));
                cp.path.add(end);
                paths.add(cp);
                //System.out.println("Found path with cost " + cp.cost);
            }
            else if (nextStep > 0)
            {
                // There is a route between start and c
                // Recurse to find the all paths

                List<City>nextVisited = new ArrayList<City>(visited);
            
                nextVisited.add(c);

                shortestPath(c, end, cost+nextStep, nextVisited, level + 1);
            }
        }
        // we have tried all cities. Return
        return;
    }
}