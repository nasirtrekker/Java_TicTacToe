/**
 * Created by nasirmac on 19/12/2016.
 */




import java.util.*;

/**
 *
 * @author Nasir Uddin
 */
public class GameBoard {

    private ArrayList<String> myBoard = new ArrayList<>();
    private boolean isValid;
    BoardPos A1 = new BoardPos("A1", ' ');
    BoardPos A2 = new BoardPos("A2", ' ');
    BoardPos A3 = new BoardPos("A3", ' ');
    BoardPos B1 = new BoardPos("B1", ' ');
    BoardPos B2 = new BoardPos("B2", ' ');
    BoardPos B3 = new BoardPos("B3", ' ');
    BoardPos C1 = new BoardPos("C1", ' ');
    BoardPos C2 = new BoardPos("C2", ' ');
    BoardPos C3 = new BoardPos("C3", ' ');

    // default constructor
    public GameBoard() {

        System.out.println(initBoard());
    }

    //sets up the grid
    public ArrayList<String> initBoard() {
        myBoard.clear();
        myBoard.add("\n,    1   2   3  \n");
        myBoard.add("A  " + A1.value + " | " + A2.value + " | " + A3.value + " \n");
        myBoard.add("  --- --- ---\n");
        myBoard.add("B  " + B1.value + " | " + B2.value + " | " + B3.value + " \n");
        myBoard.add("  --- --- ---\n");
        myBoard.add("C  " + C1.value + " | " + C2.value + " | " + C3.value + " \n");

        return myBoard;

    }

    //returns the boarad
    public ArrayList<String> getBoard() {
        return myBoard;
    }

    public void initPlayers(User p1, User p2) {
        Scanner in = new Scanner(System.in);
        System.out.println("Player 1:");
        System.out.println("Type in your name: ");
        p1.setName(in.nextLine());
        System.out.println("Hello," + p1.getName());

        assignSyms(p1);
        /*    p1.setSym(in.nextLine());
         System.out.println(p1.getName() + " has chosen " + p1.getSym());
         */
        if (p1.getSym() == 'X') {
            p2.setSym("O");
        } else {
            p2.setSym("X");
        }
        System.out.println("Player 2:");
        System.out.println("Type in your name: ");
        p2.setName(in.nextLine());
        System.out.println("Hello," + p2.getName());
        System.out.println(p2.getName() + " has been assigned " + p2.getSym());


    }

    public void firstTurn(User p1, User p2) {
        if (randomStart() == true) {
            System.out.println("Player 1 - " + p1.getName() + " will move first");
            p1.turn = true;
            p2.turn = false;

        } else {
            System.out.println("Player 2 - " + p2.getName() + " will move first");
            p2.turn = true;
            p1.turn = false;
        }
    }

    public void assignSyms(User p) {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose 'X' or 'O' ");
        p.setSym(in.nextLine());
        System.out.println(p.getName() + " has chosen " + p.getSym());
        while ((p.getSym() == ' ') || p.getSym() == '?') {
            System.out.println("You did not select a valid symbol.");
            assignSyms(p);
        }
    }

    public void clearConsole() {
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
    }

    private boolean randomStart() {
        double test = (double) 1 + (Math.random() * 100);
        if (test > 50) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList getGrid() {
        return myBoard;
    }

    public String testWin(User p1, User p2) {

        if ((p1.getSym() == 'X') && (A1.value == 'X') && (A2.value == 'X') && (A3.value == 'X')) //top row
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (A1.value == 'X') && (B2.value == 'X') && (C3.value == 'X')) //diagonal l - r
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (B1.value == 'X') && (B2.value == 'X') && (B3.value == 'X')) //middle row
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (p1.getSym() == 'X') && (p1.getSym() == 'X') && (C1.value == 'X') && (C2.value == 'X') && (C3.value == 'X')) // bottom row
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (C1.value == 'X') && (B2.value == 'X') && (A3.value == 'X')) // diagonal r - l
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (A1.value == 'X') && (B1.value == 'X') && (C1.value == 'X')) // left column
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (A2.value == 'X') && (B2.value == 'X') && (C2.value == 'X')) // middle column
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'X') && (A3.value == 'X') && (B3.value == 'X') && (C3.value == 'X')) // right column
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (A1.value == 'O') && (A2.value == 'O') && (A3.value == 'O')) //top row
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (A1.value == 'O') && (B2.value == 'O') && (C3.value == 'O')) //diagonal l - r
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (B1.value == 'O') && (B2.value == 'O') && (B3.value == 'O')) //middle row
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (C1.value == 'O') && (C2.value == 'O') && (C3.value == 'O')) // bottom row
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (C1.value == 'O') && (B2.value == 'O') && (A3.value == 'O')) // diagonal r - l
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (A1.value == 'O') && (B1.value == 'O') && (C1.value == 'O')) // left column
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (A2.value == 'O') && (B2.value == 'O') && (C2.value == 'O')) // middle column
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p1.getSym() == 'O') && (A3.value == 'O') && (B3.value == 'O') && (C3.value == 'O')) // right column
        {
            p1.setWinCount(p1.getWinCount() + 1);
            return p1.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (A1.value == 'X') && (A2.value == 'X') && (A3.value == 'X')) //top row
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (A1.value == 'X') && (B2.value == 'X') && (C3.value == 'X')) //diagonal l - r
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (B1.value == 'X') && (B2.value == 'X') && (B3.value == 'X')) //middle row
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (C1.value == 'X') && (C2.value == 'X') && (C3.value == 'X')) // bottom row
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (C1.value == 'X') && (B2.value == 'X') && (A3.value == 'X')) // diagonal r - l
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (A1.value == 'X') && (B1.value == 'X') && (C1.value == 'X')) // left column
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (A2.value == 'X') && (B2.value == 'X') && (C2.value == 'X')) // middle column
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'X') && (A3.value == 'X') && (B3.value == 'X') && (C3.value == 'X')) // right column
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (A1.value == 'O') && (A2.value == 'O') && (A3.value == 'O')) //top row
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (A1.value == 'O') && (B2.value == 'O') && (C3.value == 'O')) //diagonal l - r
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (B1.value == 'O') && (B2.value == 'O') && (B3.value == 'O')) //middle row
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (C1.value == 'O') && (C2.value == 'O') && (C3.value == 'O')) // bottom row
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (C1.value == 'O') && (B2.value == 'O') && (A3.value == 'O')) // diagonal r - l
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (A1.value == 'O') && (B1.value == 'O') && (C1.value == 'O')) // left column
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (A2.value == 'O') && (B2.value == 'O') && (C2.value == 'O')) // middle column
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if ((p2.getSym() == 'O') && (A3.value == 'O') && (B3.value == 'O') && (C3.value == 'O')) // right column
        {
            p2.setWinCount(p2.getWinCount() + 1);
            return p2.getName() + " is victorious";
        } else if (checkBoardFull() == true) {
            return "Tie Game.";
        }

        return "Game is not complete!";

    }

    public boolean checkBoardFull() {
        ArrayList<BoardPos> posList = new ArrayList<>();
        posList.add(A1);
        posList.add(A2);
        posList.add(A3);
        posList.add(B1);
        posList.add(B2);
        posList.add(B3);
        posList.add(C1);
        posList.add(C2);
        posList.add(C3);
        int count = 0;
        for (BoardPos s : posList) {

            if (s.value != ' ') {
                count++;
            }
            if (count == 9) {
                return true;
            }

        }
        return false;
    }

    public BoardPos checkInput(String t) {
        ArrayList<BoardPos> posList = new ArrayList<>();
        posList.add(A1);
        posList.add(A2);
        posList.add(A3);
        posList.add(B1);
        posList.add(B2);
        posList.add(B3);
        posList.add(C1);
        posList.add(C2);
        posList.add(C3);

        for (int i = 0; i < posList.size(); i++) {

            if (posList.get(i).name.equals(t)) {
                isValid = true;
                return posList.get(i);
            } else {
                isValid = false;
            }

        }
        return null;
    }

    public void turn(User p1, User p2) {
        Scanner in = new Scanner(System.in);

        if (p1.turn == true) {
            System.out.println("Player 1, " + p1.getName() + ", Select your move in the form of row, column(i.e. \"A1\")");
            String temp = in.nextLine();
            checkInput(temp);
            if (isValid == true) {
                if (checkInput(temp).value == ' ') {
                    checkInput(temp).value = p1.getSym();
                    p1.turn ^= true;
                    p2.turn ^= true;
                } else {
                    System.out.println("Invalid Command - Try again");
                    turn(p1, p2);
                }
            } else {
                System.out.println("Invalid Command - Try again");
                turn(p1, p2);
            }

        } else {
            System.out.println("Player 2, " + p2.getName() + ", Select your move in the form of row, column(i.e. \"A1\")");
            String temp = in.nextLine();
            checkInput(temp);
            if (isValid == true) {
                if (checkInput(temp).value == ' ') {
                    checkInput(temp).value = p2.getSym();
                    p1.turn ^= true;
                    p2.turn ^= true;

                } else {
                    System.out.println("Invalid Command - Try again");
                    turn(p1, p2);
                }

            } else {
                System.out.println("Invalid Command - Try again");
                turn(p1, p2);
            }

        }

    }

    public void runGame(User p1, User p2) {
        firstTurn(p1, p2);

        while (testWin(p1, p2).equals("Game is not complete!")) {
            System.out.println(initBoard());
            turn(p1, p2);
            //System.out.println(initBoard());
            System.out.println(testWin(p1, p2));

        }
        System.out.println(initBoard());
        System.out.println(displayScore(p1, p2));
        if (replayGame() == true) {
            clearBoard();
            runGame(p1, p2);

        } else {
            System.out.println("Goodbye!");
        }

    }

    public boolean replayGame() {
        Scanner in = new Scanner(System.in);
        System.out.println("Play again? Y/N");
        String temp = in.nextLine();
        if (temp.equals("y") || temp.equals("Y")) {
            return true;
        } else if (temp.equals("n") || temp.equals("N")) {
            return false;
        } else {
            System.out.println("Invalid entry");
            replayGame();
            return false;
        }

    }

    public void clearBoard() {
        ArrayList<BoardPos> Positions = new ArrayList<>();
        Positions.add(A1);
        Positions.add(A2);
        Positions.add(A3);
        Positions.add(B1);
        Positions.add(B2);
        Positions.add(B3);
        Positions.add(C1);
        Positions.add(C2);
        Positions.add(C3);

        for (BoardPos b : Positions) {
            b.value = ' ';
        }

    }

    public String displayScore(User p1, User p2) {
        return "Current Score is:\n" + p1.getName() + ": " + (p1.getWinCount() / 2) + "\n" + p2.getName() + ": " + (p2.getWinCount() / 2);

    }
}