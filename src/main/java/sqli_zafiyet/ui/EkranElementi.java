package sqli_zafiyet.ui;

import java.io.IOException;

public abstract class EkranElementi {

    protected final void ekraniTemizle(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
