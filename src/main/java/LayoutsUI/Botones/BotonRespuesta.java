package LayoutsUI.Botones;

import Controladores.AniadirRespuestaEventHandler;
import Controladores.EliminarRespuestaEventHandler;
import Jugador.Jugador;
import PatronObserver.Observer;
import Respuestas.Respuesta;
import javafx.scene.control.Button;


public class BotonRespuesta extends Button implements Observer {

    private final Jugador jugadorActual;
    private final Respuesta respuesta;
    private final String styleOriginal;

    public BotonRespuesta(Respuesta respuesta, Jugador jugadorActual) {
        super(respuesta.getContenido());
        this.jugadorActual = jugadorActual;
        this.respuesta = respuesta;
        setOnAction(new AniadirRespuestaEventHandler(respuesta, jugadorActual));
        jugadorActual.agregarObservador(this);
        this.styleOriginal = getStyle();
    }

    @Override
    public void actualizar() {
        if(jugadorActual.getRespuestasElegidas().contains(respuesta)) {
            setStyle("-fx-background-color: #69CFBF; -fx-text-fill: #000000");
            setOnAction(new EliminarRespuestaEventHandler(respuesta, jugadorActual));
        }
        else{
            setStyle(styleOriginal);
            setOnAction(new AniadirRespuestaEventHandler(respuesta, jugadorActual));
        }
    }
}
