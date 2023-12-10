import java.util.ArrayList;
import java.util.List;

public class Dijkstra extends Algorithm{
    
    Dijkstra(Board b) {
        super(b);
    }
    Cities myCities = b.myCities;

    private List<City> unvisited= new ArrayList<City>();
    private  CostPath[] paths = new CostPath[myCities.names.size()];


    public void shortestPath(City start, City end) {
     
        // Add all cities to the unvisited list
        unvisited = new ArrayList<>(myCities.cities);

        // Initialize all distances to infinity
        for (int i =0 ; i < myCities.cityCount(); i++)
        {
                paths[i] = new CostPath(Integer.MAX_VALUE, new ArrayList<City>());
                paths[i].path.add(start);
        }
        // Set the distance to the start city to 0
        paths[start.index].cost = 0;
        unvisited.remove(start);
        
        long startTime = System.nanoTime();
        iterateShortestPath(start, end);
        long endTime = System.nanoTime();

        List<String> path = new ArrayList<>();
        for (City c: paths[end.index].path) {
            path.add(c.name);
        }
        System.out.println("Shortest Path: " + paths[end.index].cost + " : " + path);
        System.out.println("This Path Will Cost : " + getTollCost(end) + " Bridge Toll Token(s)");
        System.out.println("Dijkstra Shortest Path calculation time: " + (endTime-startTime) + "ns");
    }

    public void iterateShortestPath(City start, City end)
    {
        // Update the shortest path to all cities reachable from start
        for (City c : unvisited)
        {
            int cost = b.getBoard(start, c);
            if (cost > 0)
            {
                if (paths[c.index].cost > cost + paths[start.index].cost)
                {
                    paths[c.index].cost = cost + paths[start.index].cost;
                    paths[c.index].path = new ArrayList<City>(paths[start.index].path);
                    paths[c.index].path.add(c);
                }
            }
        }

        // Find the next city to visit
        City next = unvisited.get(0); // Need to give it a possible value
        for (City c : unvisited)
        {
            if (paths[c.index].cost < paths[next.index].cost)
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
    public int getTollCost( City end){
        int cost = 0;
        for(int i = 0; i < (paths[end.index].path.size() - 1) ; i++){
            cost += b.getBoard(paths[end.index].path.get(i), paths[end.index].path.get(i+1));
        }
        return cost;
    }

}
