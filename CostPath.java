import java.util.List;

public class CostPath {
    public int cost;
    public List<City> path;
    public CostPath(int cost,List<City> path){
        this.path = path;
        this.cost = cost;
    }
}
