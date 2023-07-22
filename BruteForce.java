
import java.util.List;

public class BruteForce extends Algorithm {

    

    BruteForce(Board b) {
        super(b);
    }   

    public CostPath shortestPath(Cities.cities start, Cities.cities end) {
        System.out.println("BruteForce Shortest Path: level 0");
        CostPath cp = shortestPath(start, end, 0, null, 1);
    
        return cp;
    }

    public CostPath shortestPath(Cities.cities start, Cities.cities end, int cost, List<Cities.cities> visited, int level) {
        System.out.println("BruteForce Shortest Path: level " + level);

        for (Cities.cities c : Cities.cities.values()) {

            if (visited.contains(c)) {
                // Already visited this city
                continue;
            }
            if (b.getBoard(start, c) > 0)
            {
                // There is a route between start and c
                // Add the cost of the route to the cost
                cost += b.getBoard(start, c);
                visited.add(c);
                if (c == end) {
                    // We have reached the end
                    // Return the cost and the path
                    CostPath cp = new CostPath();
                    cp.cost = cost;
                    cp.path = visited;
                    System.out.println("Reached the end: " + cost + visited);
                    return cp;
                }

                CostPath cp = shortestPath(c, end, cost, visited, level + 1);
            
            }
      
        }
        CostPath cp = new CostPath();
        cp.cost = 0;
        cp.path = null;
        return cp;
    }



}