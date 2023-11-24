import javax.swing.*;

class Board {
    private int[][] board,tollBoard;
    private int size;

    private void createGraph()
    {

        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++) {
                board[x][y] = 0;
                tollBoard[x][y] = 0;
            }

        // All Possible Connections Between All The Train Station
        setBoard(Cities.cities.Emden, Cities.cities.Groningen, 3,3);
        setBoard(Cities.cities.Emden, Cities.cities.Lingen, 6,1);
        setBoard(Cities.cities.Emden, Cities.cities.Emmen, 4,4);
        setBoard(Cities.cities.Groningen, Cities.cities.Emmen, 3,3);
        setBoard(Cities.cities.Groningen, Cities.cities.Waddeneilanden,6,4);
        setBoard(Cities.cities.Groningen, Cities.cities.Leeuwarden,3,2);
        setBoard(Cities.cities.Groningen, Cities.cities.Zwolle,6,4);
        setBoard(Cities.cities.Waddeneilanden, Cities.cities.DenHelder,5,4);
        setBoard(Cities.cities.Waddeneilanden, Cities.cities.Sneek,3,4);
        setBoard(Cities.cities.Waddeneilanden, Cities.cities.Leeuwarden,2,3);
        setBoard(Cities.cities.Leeuwarden, Cities.cities.Sneek,1,1);
        setBoard(Cities.cities.Sneek, Cities.cities.DenHelder,4,3);
        setBoard(Cities.cities.Sneek, Cities.cities.Lelystad,4,3);
        setBoard(Cities.cities.DenHelder, Cities.cities.Haarlem,4,2);
        setBoard(Cities.cities.Haarlem, Cities.cities.Amsterdam,1,1);
        setBoard(Cities.cities.Haarlem, Cities.cities.DenHaag,2,2);
        setBoard(Cities.cities.DenHaag, Cities.cities.Rotterdam,1,1);
        setBoard(Cities.cities.DenHaag, Cities.cities.Middelburg,6,4);
        setBoard(Cities.cities.Middelburg, Cities.cities.Antwerpen,5,3);
        setBoard(Cities.cities.Antwerpen, Cities.cities.Rotterdam,5,4);
        setBoard(Cities.cities.Antwerpen, Cities.cities.Turnhout,2,2);
        setBoard(Cities.cities.Antwerpen, Cities.cities.Aarschot,2,1);
        setBoard(Cities.cities.Aarschot, Cities.cities.Hasselt,2,1);
        setBoard(Cities.cities.Aarschot, Cities.cities.Liege,5,1);
        setBoard(Cities.cities.Liege, Cities.cities.Hasselt,2,1);
        setBoard(Cities.cities.Liege, Cities.cities.Maastricht,2,1);
        setBoard(Cities.cities.Maastricht, Cities.cities.Hasselt,2,2);
        setBoard(Cities.cities.Maastricht, Cities.cities.Eindhoven,4,2);
        setBoard(Cities.cities.Maastricht, Cities.cities.Roermond,2,1);
        setBoard(Cities.cities.Roermond, Cities.cities.Eindhoven,3,3);
        setBoard(Cities.cities.Roermond, Cities.cities.Duisburg,3,2);
        setBoard(Cities.cities.Duisburg, Cities.cities.Nijmegen,4,2);
        setBoard(Cities.cities.Duisburg, Cities.cities.Enschede,6,1);
        setBoard(Cities.cities.Enschede, Cities.cities.Arnhem,5,2);
        setBoard(Cities.cities.Enschede, Cities.cities.Zwolle,4,1);
        setBoard(Cities.cities.Enschede, Cities.cities.Lingen,3,3);
        setBoard(Cities.cities.Lingen, Cities.cities.Emmen,3,2);
        setBoard(Cities.cities.Emmen, Cities.cities.Zwolle,4,3);
        setBoard(Cities.cities.Zwolle, Cities.cities.Lelystad,2,4);
        setBoard(Cities.cities.Zwolle, Cities.cities.Arnhem,4,2);
        setBoard(Cities.cities.Lelystad, Cities.cities.Amsterdam,3,3);
        setBoard(Cities.cities.Amsterdam, Cities.cities.Rotterdam,4,2);
        setBoard(Cities.cities.Amsterdam, Cities.cities.Utrecht,1,1);
        setBoard(Cities.cities.Utrecht, Cities.cities.Rotterdam,3,3);
        setBoard(Cities.cities.Utrecht, Cities.cities.Arnhem,4,1);
        setBoard(Cities.cities.Arnhem, Cities.cities.Nijmegen,1,3);
        setBoard(Cities.cities.Nijmegen, Cities.cities.Eindhoven,3,3);
        setBoard(Cities.cities.Eindhoven, Cities.cities.DenBosch,1,2);
        setBoard(Cities.cities.DenBosch, Cities.cities.Breda,2,2);
        setBoard(Cities.cities.Breda, Cities.cities.Rotterdam,2,4);
        setBoard(Cities.cities.Breda, Cities.cities.Turnhout,2,2);
        setBoard(Cities.cities.Turnhout, Cities.cities.Hasselt,3,3);
    }

    public Board() {
        this.size = Cities.cities.values().length; 
        board = new int[size][size];
        tollBoard = new int[size][size];
        this.createGraph();
    }

 



    public void setBoard(Cities.cities x, Cities.cities y, int value, int bridgeTool) {
        // Used to set the distance between 2 cities
        // First version of this program we will use just the distance. Once we have that working
        // We can switch the int to a class that contains the distance and the colours of the route and cost
        board[x.ordinal()][y.ordinal()] = value;
        board[y.ordinal()][x.ordinal()] = value;
        tollBoard[x.ordinal()][y.ordinal()] = bridgeTool;
        tollBoard[y.ordinal()][x.ordinal()] = bridgeTool;
    }

    public int getBoard(Cities.cities x, Cities.cities y) {
        return board[x.ordinal()][y.ordinal()];
    }
    public int getBridgeToll(Cities.cities x, Cities.cities y) {
        return tollBoard[x.ordinal()][y.ordinal()];
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}