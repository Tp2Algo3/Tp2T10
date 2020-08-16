package Vista.Botones;

import Controladores.MultiplicadorEventHandler;
import Modelo.Jugador.Jugador;
import Modelo.Potenciadores.MultiplicadorPorTres;
import PatronObserver.Observer;
import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonMultX3 extends Button implements Observer {

    private Jugador jugador;

    public BotonMultX3(Jugador jugador){
        super("x3");
        this.jugador = jugador;
        
        setOnAction(new MultiplicadorEventHandler(jugador, new MultiplicadorPorTres()));
        setCursor(Cursor.HAND);

        jugador.agregarObservador(this);
    }

    @Override
    public void actualizar(){
        if(jugador.getMultiplicadorActual().getOrdenMultiplicidad()!=1) {
            setDisable(true);
        }
    }
}