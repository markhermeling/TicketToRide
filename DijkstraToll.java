import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class DijkstraToll extends Algorithm{
    DijkstraToll(Board b) {
        super(b);
    }

    private List<Cities.cities> unvisited= new ArrayList<Cities.cities>();
    private CostPath[] tollPath = new CostPath[Cities.cities.values().length];

    public void shortestPath(Cities.cities start, Cities.cities end) {
        // Add all cities to the unvisited list
        unvisited.addAll(Arrays.asList(Cities.cities.values()));

        // Initialize all distances to infinity
        for (Cities.cities x : Cities.cities.values())
        {
            tollPath[x.ordinal()] = new CostPath();
            tollPath[x.ordinal()].cost = Integer.MAX_VALUE;
            tollPath[x.ordinal()].path = new ArrayList<Cities.cities>();
            tollPath[x.ordinal()].path.add(start);

        }

        // Set the distance to the start city to 0
        tollPath[start.ordinal()].cost = 0;
        unvisited.remove(start);

        long startTime = System.nanoTime();
        iterateShortestPath(start, end);
        long endTime = System.nanoTime();

        System.out.println("Smallest Toll Price: " + tollPath[end.ordinal()].cost + " : " + tollPath[end.ordinal()].path);
        System.out.println("This Path will cost : " + getTrainCost(end) + " train(s)");
        System.out.println("Dijkstra Smallest Toll Price calculation time: " + (endTime-startTime) + "ns");
    }
    public void iterateShortestPath(Cities.cities start, Cities.cities end) {
        // Update the shortest path to all cities reachable from start
        for (Cities.cities c : unvisited)
        {
            int cost = b.getBridgeToll(start, c);
            if (cost > 0)
            {
                if (tollPath[c.ordinal()].cost > cost + tollPath[start.ordinal()].cost)
                {
                    tollPath[c.ordinal()].cost = cost + tollPath[start.ordinal()].cost;
                    tollPath[c.ordinal()].path = new ArrayList<Cities.cities>(tollPath[start.ordinal()].path);
                    tollPath[c.ordinal()].path.add(c);
                }
            }
        }



        // Find the next city to visit
        Cities.cities next = unvisited.get(0); // Need to give it a possible value
        for (Cities.cities c : unvisited)
        {
            if (tollPath[c.ordinal()].cost < tollPath[next.ordinal()].cost)
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

    public int getTrainCost( Cities.cities end){
        int cost = 0;
        //Get the bridge toll from the board add that value to int cost
        for(int i = 0; i <= (tollPath[end.ordinal()].path.size() - 2) ; i++){
            cost += b.getBoard(tollPath[end.ordinal()].path.get(i), tollPath[end.ordinal()].path.get(i+1));
        }
        return cost;
    }
}


