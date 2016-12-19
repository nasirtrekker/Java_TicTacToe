/**
 * Created by nasirmac on 19/12/2016.
 */



/**
 *
 * @author Nasir Uddin
 */
public class User {

    private char sym;
    private String name;
    public boolean turn;
    private int WinCount = 0;

    public char getSym() {
        return sym;
    }

    public String getName() {
        return name;
    }
    public int getWinCount() {
        return WinCount;
    }

    public void setSym(String s) {
        if ((s.equals("x") || s.equals("X"))) {
            sym = 'X';
        } else if ((s.equals("o") || s.equals("O"))) {
            sym = 'O';
        } else {
            sym = '?';
        }

    }

    public void setName(String s) {
        name = s;

    }

    public void setWinCount(int a){
        WinCount = a;
    }


}
