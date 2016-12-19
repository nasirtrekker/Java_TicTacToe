/**
 * Created by nasirmac on 19/12/2016.
 */



public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GameBoard gb = new GameBoard();
        User p1 = new User();
        User p2 = new User();

        gb.initPlayers(p1, p2);

        System.out.println(gb.initBoard());
        gb.runGame(p1, p2);

        // gb.clearConsole();


    }
}
