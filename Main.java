

public class Main {

    static private Board b;

    public static void main(String[] args ){
        Cities.cities start = Cities.cities.Waddeneilanden;
        Cities.cities end = Cities.cities.Emmen;

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
    }
}