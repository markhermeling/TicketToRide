import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Board {
    private int[][] board,tollBoard;
    private int size;
    public Cities myCities;

    private void createGraph(String configFileName)
    {
        myCities.getCities(configFileName);
        size = myCities.size;

        board = new int[size][size];
        tollBoard = new int[size][size];
        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++) {
                board[x][y] = 0;
                tollBoard[x][y] = 0;
            }
        
        // now we read the connections from the config file
        File configFile = null;
        Scanner reader = null;

        try {
            configFile = new File(configFileName);
            reader = new Scanner(configFile);
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        reader.nextLine(); // skip the first line

        while (reader.hasNext()) {

            String line = reader.nextLine();
            String[] tokens = line.split(",");
            City from = myCities.lookup(tokens[0].trim());
            if (from == null) {
                System.out.println("Error: _" + tokens[0] + "_ not found");
                System.exit(0);
            }
            City to = myCities.lookup(tokens[1].trim());
            if (to == null) {
                System.out.println("Error: _" + tokens[1] + "_ not found");
                System.exit(0);
            }
            System.out.println("Adding connection: " + tokens[0] + " to " + tokens[1] + " cost: " + tokens[2] + " toll: " + tokens[3]);

            setBoard(from.index, to.index, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        }
    }


    Board(String configfileName) {
        super();
        myCities = new Cities();

        createGraph(configfileName);
    }

    public void setBoard(int x, int y, int value, int bridgeToll) {
        // Used to set the distance between 2 cities
        // First version of this program we will use just the distance. Once we have that working
        // We can switch the int to a class that contains the distance and the colours of the route and cost
        board[x][y] = value;
        board[y][x] = value;
        tollBoard[x][y] = bridgeToll;
        tollBoard[y][x] = bridgeToll;
    }

    public int getBoard(City x, City y) {
        return board[x.index][y.index];
    }
    public int getBridgeToll(City x, City y) {
        return tollBoard[x.index][y.index];
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