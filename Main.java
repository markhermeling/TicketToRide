

public class Main {

    static private Board b;

    public static void main(String[] args ){
        System.out.println("Ticket to ride shortest path calculator");

        System.out.println("--------------------------------------------------------------"); // Adds some space
        b = new Board();

        BruteForce bf = new BruteForce(b);
        bf.shortestPath(Cities.cities.Waddeneilanden, Cities.cities.Emmen);
        bf.printShortestPath();

        System.out.println("--------------------------------------------------------------"); // Adds some space

        Dijkstra d = new Dijkstra(b);
        d.shortestPath(Cities.cities.Waddeneilanden, Cities.cities.Emmen);

        System.out.println("--------------------------------------------------------------"); // Adds some space

        DijkstraToll dt = new DijkstraToll(b);
        dt.shortestPath(Cities.cities.Waddeneilanden, Cities.cities.Emmen);
    }
}