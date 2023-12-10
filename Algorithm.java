
public abstract class Algorithm {
    static Board b;

    Algorithm(Board b) {
        Algorithm.b = b;
    }

    
    abstract public void shortestPath(City start, City end);
   
}
