package zoo_invaders;

import javafx.scene.input.KeyCode;

public class KM {

    //represent states of my game keys
    //UP,DOWN,LEFT,RIGHT
    private boolean[] keystates;

    public KM() {
        keystates = new boolean[5];
    }

    private int keycodeToIndx(KeyCode k) {
        switch (k) {
            //case UP:
            //return 0;
            //case DOWN:
            //return 1;
            case LEFT:
                return 2;
            case RIGHT:
                return 3;
            case SPACE:
                return 4;
            default:
                return -1;
        }
    }

    public void setkeystate(KeyCode k, boolean state) {
        int i = keycodeToIndx(k);
        if (i != -1) {
            keystates[i] = state;
        }
    }

    public boolean getkeystate(KeyCode k) {
        int i = keycodeToIndx(k);
        return keystates[i];
    }
}
