import java.util.*;

public class DestinationCards {
    private int destination[][];
    private int size = Cities.cities.values().length;
     private  List<Cities.cities> citiesX = new ArrayList<>();
    private List<Cities.cities> citiesY= new ArrayList<>();

    private ArrayList<ArrayList<Cities.cities>> allDestination = new ArrayList<>();

    private void createGraph()
    {
        // All Destination Cards
        setDestination(Cities.cities.Groningen, Cities.cities.Amsterdam,21);
        setDestination(Cities.cities.Groningen, Cities.cities.Enschede,14);
        setDestination(Cities.cities.Leeuwarden, Cities.cities.DenBosch,24);
        setDestination(Cities.cities.Sneek, Cities.cities.Utrecht,16);
        setDestination(Cities.cities.Sneek, Cities.cities.Eindhoven,26);
        setDestination(Cities.cities.DenHelder, Cities.cities.Liege,29);
        setDestination(Cities.cities.DenHelder, Cities.cities.Rotterdam,14);
        setDestination(Cities.cities.DenHaag, Cities.cities.Liege,18);
        setDestination(Cities.cities.Liege, Cities.cities.Duisburg,12);
        setDestination(Cities.cities.Arnhem, Cities.cities.DenBosch,10);
        setDestination(Cities.cities.Leeuwarden, Cities.cities.Antwerpen,32);
        setDestination(Cities.cities.Duisburg, Cities.cities.Rotterdam,23);
        setDestination(Cities.cities.Lingen, Cities.cities.Duisburg,14);
        setDestination(Cities.cities.Leeuwarden, Cities.cities.Haarlem,15);
        setDestination(Cities.cities.DenHaag, Cities.cities.Antwerpen,14);
        setDestination(Cities.cities.Hasselt, Cities.cities.Breda,12);
        setDestination(Cities.cities.Zwolle, Cities.cities.Haarlem,14);
        setDestination(Cities.cities.Emmen, Cities.cities.Lelystad,13);
        setDestination(Cities.cities.Zwolle, Cities.cities.Maastricht,18);
        setDestination(Cities.cities.Waddeneilanden, Cities.cities.DenHaag,20);
        setDestination(Cities.cities.Amsterdam, Cities.cities.Antwerpen,19);
        setDestination(Cities.cities.Enschede, Cities.cities.Eindhoven,15);
        setDestination(Cities.cities.Breda, Cities.cities.Eindhoven,7);
        setDestination(Cities.cities.Amsterdam, Cities.cities.Maastricht,20);
        setDestination(Cities.cities.Roermond, Cities.cities.Middelburg,21);
        setDestination(Cities.cities.Zwolle, Cities.cities.Rotterdam,17);
        setDestination(Cities.cities.Arnhem, Cities.cities.DenHaag,14);
        setDestination(Cities.cities.Amsterdam, Cities.cities.Rotterdam,10);
        setDestination(Cities.cities.Amsterdam, Cities.cities.Nijmegen,13);
        setDestination(Cities.cities.Lelystad, Cities.cities.Aarschot,24);
        setDestination(Cities.cities.Emden, Cities.cities.Utrecht,22);
        setDestination(Cities.cities.Utrecht, Cities.cities.Middelburg,19);
        setDestination(Cities.cities.Enschede, Cities.cities.Amsterdam,15);
        setDestination(Cities.cities.Emden, Cities.cities.Waddeneilanden,16);
        setDestination(Cities.cities.Rotterdam, Cities.cities.Antwerpen,13);
        setDestination(Cities.cities.Rotterdam, Cities.cities.Turnhout,12);
        setDestination(Cities.cities.Nijmegen, Cities.cities.Antwerpen,21);
        setDestination(Cities.cities.Groningen, Cities.cities.Middelburg,34);
        setDestination(Cities.cities.Waddeneilanden, Cities.cities.Duisburg,31);
        setDestination(Cities.cities.Groningen, Cities.cities.Breda,31);
        setDestination(Cities.cities.Amsterdam, Cities.cities.DenHaag,9);
        setDestination(Cities.cities.Emmen, Cities.cities.Antwerpen,33);
        setDestination(Cities.cities.Lingen, Cities.cities.DenHaag,26);
        setDestination(Cities.cities.Haarlem, Cities.cities.Breda,12);
        setDestination(Cities.cities.Utrecht, Cities.cities.Hasselt,22);

    }

    public DestinationCards() {
        destination = new int[size][size];
        this.createGraph();
    }

    public void setDestination(Cities.cities x, Cities.cities y, int points) {
        destination[x.ordinal()][y.ordinal()] = points;
        destination[y.ordinal()][x.ordinal()] = points;

    }
    public int getDestination(Cities.cities x, Cities.cities y) {
        return destination[x.ordinal()][y.ordinal()];
    }
    public ArrayList<ArrayList<Cities.cities>> getAllDestinations() {

        for (Cities.cities cX: Cities.cities.values()) {
            for (Cities.cities cY: Cities.cities.values()) {
                if (getDestination(cX, cY) != 0) {
                    citiesX.add(cX);
                    citiesY.add(cY);
                }
            }
        }
        for (int j = 0; j <= (citiesY.size() -1); j++) {
            for (int i = citiesY.size()-1; i >= 0; i--) {
                if (citiesY.get(i) == citiesY.get(j) && citiesX.get(j) == citiesX.get(i)){
                    citiesX.remove(j);
                    citiesY.remove(j);
                }
            }
        }
        for (int i = 0; i <= citiesY.size()-1;i++){
            allDestination.add(new ArrayList<>());
            allDestination.get(i).add(citiesX.get(i));
            allDestination.get(i).add(citiesY.get(i));
        }
        return allDestination;
    }
}