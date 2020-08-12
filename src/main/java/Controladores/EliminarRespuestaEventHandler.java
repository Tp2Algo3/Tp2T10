package Controladores;

import Modelo.Jugador.Jugador;
import Modelo.Respuestas.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;;

public class EliminarRespuestaEventHandler implements EventHandler<ActionEvent> {
    private Respuesta respuesta;
    private Jugador jugador;

    public EliminarRespuestaEventHandler(Respuesta respuesta, Jugador jugador){
        this.respuesta = respuesta;
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.eliminarRespuesta(respuesta);
    }
}
