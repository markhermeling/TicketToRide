

public class Main {

    static private Board b;

    public static void main(String[] args ){
        System.out.println("Ticket to ride shortest path calculator");

        b = new Board();


        BruteForce bf = new BruteForce(b);

        bf.shortestPath(Cities.cities.Waddeneilanden, Cities.cities.Emmen);
       
        bf.printShortestPath();

        Dijkstra d = new Dijkstra(b);
        d.shortestPath(Cities.cities.Waddeneilanden, Cities.cities.Emmen);
    }
}
