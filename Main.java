

public class Main {

    static private Board b;

    public static void main(String[] args ){
        b = new Board("Netherlands.txt");

        City start = b.myCities.lookup("Waddeneilanden");
        City end = b.myCities.lookup("Rotterdam");


        System.out.println("Ticket to ride shortest path calculator");

        System.out.println("--------------------------------------------------------------"); // Adds some space

        //BruteForce bf = new BruteForce(b);
        // bf.shortestPath("Waddeneilanden", "Emmen");
        //bf.printShortestPath();

        System.out.println("--------------------------------------------------------------"); // Adds some space

        Dijkstra d = new Dijkstra(b);
        d.shortestPath(start, end);


        System.out.println("--------------------------------------------------------------"); // Adds some space

        DijkstraToll dt = new DijkstraToll(b);
        dt.shortestPath(start, end);
        

    }
}