package ejemplo208;

/**
 *
 * @author Cristobal Ramirez
 */
public class RecursoCompartido {
    private boolean flagWinner = false; //True = someone has arrived
    private String nameWinner = "";

    public synchronized boolean isFlagWinner() {
        return flagWinner;
    }

    public synchronized void setFlagWinner(boolean flagWinner) {
        this.flagWinner = flagWinner;
    }

    public String getNameWinner() {
        return nameWinner;
    }

    int lugar =0;
    public synchronized void setNameWinner(String nameWinner) {
        if ( !isFlagWinner() ){
        this.nameWinner = nameWinner;
        //flagWinner = true;
        lugar ++;
        System.out.println( lugar + "er. Lugar: " + nameWinner );
        }
    }
}
