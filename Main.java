



public class Main {

    static private Board b;

    public static void main(String[] args ){
        System.out.println("Ticket to ride shortest path calculator");

        b = new Board();

        System.out.print("Distance between " + Cities.names[Cities.cities.Emden.ordinal()] + " and " + Cities.names[Cities.cities.Groningen.ordinal()] + " is ");
        System.out.println( b.getBoard(Cities.cities.Emden, Cities.cities.Groningen));
    }
    
}
