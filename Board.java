



class Board {
    private int[][] board;
    private int size;

    private void createGraph()
    {
        setBoard(Cities.cities.Emden, Cities.cities.Groningen, 3);
        setBoard(Cities.cities.Emden, Cities.cities.Lingen, 7);
        setBoard(Cities.cities.Emden, Cities.cities.Emmen, 4);
        setBoard(Cities.cities.Groningen, Cities.cities.Emmen, 3);
    }

    public Board() {
        this.size = Cities.cities.values().length; 
        board = new int[size][size];
        this.createGraph();
    }

 



    public void setBoard(Cities.cities x, Cities.cities y, int value) {
        // Used to set the distance between 2 cities
        // First version of this program we will use just the distance. Once we have that working
        // We can switch the int to a class that contains the distance and the colours of the route and cost
        board[x.ordinal()][y.ordinal()] = value;
    }

    public int getBoard(Cities.cities x, Cities.cities y) {
        return board[x.ordinal()][y.ordinal()];
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