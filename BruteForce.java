
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
        if (paths.size() == 0)
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
            for (Cities.cities c : cp.path) {
                System.out.print(Cities.names[c.ordinal()]+"-");
            }
            System.out.println();
        }

    }

    public void shortestPath(Cities.cities start, Cities.cities end) {
     
        List<Cities.cities> visited = new ArrayList<Cities.cities>();
        visited.add(start);
        long startTime = System.currentTimeMillis();
        shortestPath(start, end, 0, visited, 0);
        long endTime = System.currentTimeMillis();
        
        System.out.println("BruteForce Shortest Path: " + (endTime-startTime) + "ms");
        return;
    }

    public void shortestPath(Cities.cities start, Cities.cities end, int cost, List<Cities.cities> visited, int level) {
     //   System.out.println("BruteForce Shortest Path: level " + level);

        
        for (Cities.cities c : Cities.cities.values()) {

            if (visited.contains(c)) {
                // Already visited this city
                continue;
            }
            int nextStep = b.getBoard(start, c);

            if (nextStep > 0 && c == end) {
                // We have reached the end
                // Return the cost and the path
                CostPath cp = new CostPath();
                cp.cost = cost + nextStep;                    
                cp.path = visited;
                cp.path.add(end);
                paths.add(cp);
                //System.out.println("Found path with cost " + cp.cost);
                continue;
            }
 

            if (nextStep > 0)
            {
                // There is a route between start and c
                // Recurse to find the shortest path

                List<Cities.cities>nextVisited = new ArrayList<Cities.cities>(visited);
            
                nextVisited.add(c);

                shortestPath(c, end, cost+nextStep, nextVisited, level + 1);
            
            }
            else
            {
                // There is no route between start and c
                // Try the next city
                continue;
            }
      
        }
        // we have tried all cities. Return
        return;

    }



}