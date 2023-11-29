import java.io.IOException;

public class Main {

    static private Board b;

    public static void main(String[] args ) throws IOException {
        Cities.cities start = Cities.cities.DenHaag;
        Cities.cities end = Cities.cities.Lingen;

        System.out.println("Ticket to ride shortest path calculator");

        System.out.println("--------------------------------------------------------------"); // Adds some space
        b = new Board();

        BruteForce bf = new BruteForce(b);
        bf.shortestPath(start,end);
        bf.printShortestPath();

        System.out.println("--------------------------------------------------------------"); // Adds some space

        Dijkstra d = new Dijkstra(b);
        d.shortestPath(start,end);

        System.out.println("--------------------------------------------------------------"); // Adds some space

        DijkstraToll dt = new DijkstraToll(b);
        dt.shortestPath(start,end);

        MostPopularPath mp = new MostPopularPath();
        mp.pathCalculation();

        DestinationCards dc = new DestinationCards();
        dc.csvAllDestinations();

    }
}