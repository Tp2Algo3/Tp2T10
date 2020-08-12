package Controladores;


import Modelo.Respuestas.Respuesta;
import Modelo.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AniadirRespuestaEventHandler implements EventHandler<ActionEvent>{
    private Respuesta respuesta;
    private Jugador jugador;

    public AniadirRespuestaEventHandler(Respuesta respuesta, Jugador jugador){
        this.respuesta = respuesta;
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.aniadirRespuesta(respuesta);
    }
}
