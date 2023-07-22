public abstract class Algorithm {
    static Board b;

    Algorithm(Board b) {
        Algorithm.b = b;
    }

    
    abstract public CostPath shortestPath(Cities.cities start, Cities.cities end);
   
}
