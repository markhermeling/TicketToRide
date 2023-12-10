import java.util.List;

public abstract class Algorithm {
    static Board b;

    Algorithm(Board b) {
        Algorithm.b = b;
    }

    
    abstract public List<Cities.cities> shortestPath(Cities.cities start, Cities.cities end, boolean print);
   
}
