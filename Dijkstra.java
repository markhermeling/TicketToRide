import java.util.ArrayList;
import java.util.List;

public class Dijkstra extends Algorithm{
    
    Dijkstra(Board b) {
        super(b);
    }

    private List<Cities.cities> unvisited= new ArrayList<Cities.cities>();;
    private CostPath[] paths = new CostPath[Cities.cities.values().length];

    public void shortestPath(Cities.cities start, Cities.cities end) {
     
        // Add all cities to the unvisited list
        for (Cities.cities c : Cities.cities.values())
        {
            unvisited.add(c);
        }

        // Initialize all distances to infinity
        for (Cities.cities x : Cities.cities.values())
        {
                paths[x.ordinal()] = new CostPath();
                paths[x.ordinal()].cost = Integer.MAX_VALUE;
                paths[x.ordinal()].path = new ArrayList<Cities.cities>();
                paths[x.ordinal()].path.add(start);
        }
        
        // Set the distance to the start city to 0
        paths[start.ordinal()].cost = 0;
        unvisited.remove(start);
        
        long startTime = System.nanoTime();
        iterateShortestPath(start, end);
        long endTime = System.nanoTime();
        
        System.out.println("Shortest Path: " + paths[end.ordinal()].cost + " : " + paths[end.ordinal()].path);
        System.out.println("Dijkstra Shortest Path calculation time: " + (endTime-startTime) + "ns");
        
        return;
    }

    public void iterateShortestPath(Cities.cities start, Cities.cities end)
    {
        // Update the shortest path to all cities reachable from start
        for (Cities.cities c : unvisited)
        {
            int cost = b.getBoard(start, c);
            if (cost > 0)
            {
                if (paths[c.ordinal()].cost > cost + paths[start.ordinal()].cost)
                {
                    paths[c.ordinal()].cost = cost + paths[start.ordinal()].cost;
                    paths[c.ordinal()].path = new ArrayList<Cities.cities>(paths[start.ordinal()].path);
                    paths[c.ordinal()].path.add(c);
                }
            }
        }

  
        
        // Find the next city to visit
        Cities.cities next = unvisited.get(0); // Need to give it a possible value
        for (Cities.cities c : unvisited)
        {
            if (paths[c.ordinal()].cost < paths[next.ordinal()].cost)
            {
                next = c;
            }
        }
        unvisited.remove(next);
        // If the next city is the end city we are done
        if (next == end)
        {
            return;
        }
        iterateShortestPath(next, end);
    }

}
