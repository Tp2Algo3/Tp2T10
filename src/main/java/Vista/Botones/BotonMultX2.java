package Vista.Botones;

import Controladores.MultiplicadorEventHandler;
import Modelo.Jugador.Jugador;
import PatronObserver.Observer;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonMultX2 extends Button implements Observer {

    private Jugador jugador;

    public BotonMultX2(Jugador jugador){
        super("x2");
        this.jugador = jugador;

        setOnAction(new MultiplicadorEventHandler(jugador, 2));
        setCursor(Cursor.HAND);

        jugador.agregarObservador(this);
    }

    @Override
    public void actualizar() {
        if(jugador.getMultiplicadorActual().getId()!=1) {
            setDisable(true);
        }
    }
}
