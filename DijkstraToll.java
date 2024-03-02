import java.util.ArrayList;
import java.util.List;

public class DijkstraToll extends Algorithm{
    DijkstraToll(Board b) {
        super(b);
    }

    Cities myCities = b.myCities;

    private List<City> unvisited= new ArrayList<City>();
    private CostPath[] tollPath = new CostPath[myCities.cities.size()];

    public void shortestPath(City start, City end) {
        // Add all cities to the unvisited list
        unvisited = new ArrayList<>(myCities.cities);

        // Initialize all distances to infinity
        for (int i =0 ; i < myCities.cityCount(); i++)
        {
            tollPath[i] = new CostPath(Integer.MAX_VALUE, new ArrayList<City>());
            tollPath[i].path.add(start);

        }

        // Set the distance to the start city to 0
        tollPath[start.index].cost = 0;
        unvisited.remove(start);

        long startTime = System.nanoTime();
        iterateShortestPath(start, end);
        long endTime = System.nanoTime();

        List<String> path = new ArrayList<>();
        for (City c: tollPath[end.index].path) {
            path.add(c.name);
        }
        System.out.println("Smallest Toll Price: " + tollPath[end.index].cost + " : " + path);
        System.out.println("This Path will cost : " + getTrainCost(end) + " train(s)");
        System.out.println("Dijkstra Smallest Toll Price calculation time: " + (endTime-startTime) + "ns");
    }
    public void iterateShortestPath(City start, City end) {
        // Update the shortest path to all cities reachable from start
        for (City c : unvisited)
        {
            int cost = b.getBridgeToll(start, c);
            if (cost > 0)
            {
                if (tollPath[c.index].cost > cost + tollPath[start.index].cost)
                {
                    tollPath[c.index].cost = cost + tollPath[start.index].cost;
                    tollPath[c.index].path = new ArrayList<City>(tollPath[start.index].path);
                    tollPath[c.index].path.add(c);
                }
            }
        }

        // Find the next city to visit
        City next = unvisited.get(0); // Need to give it a possible value
        for (City c : unvisited)
        {
            if (tollPath[c.index].cost < tollPath[next.index].cost)
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

    public int getTrainCost( City end){
        int cost = 0;
        //Get the bridge toll from the board add that value to int cost
        for(int i = 0; i <= (tollPath[end.index].path.size() - 2) ; i++){
            cost += b.getBoard(tollPath[end.index].path.get(i), tollPath[end.index].path.get(i+1));
        }
        return cost;
    }
}


