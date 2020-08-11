package Controladores;

import PatronObserver.Observer;
import Respuestas.Respuesta;
import Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class AniadirRespuestaEventHandler implements EventHandler<ActionEvent>{

    private Button boton;
    private Respuesta respuesta;
    private Jugador jugador;

    public AniadirRespuestaEventHandler(Button boton, Respuesta respuesta, Jugador jugador){
        this.boton = boton;
        this.respuesta = respuesta;
        this.jugador = jugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        jugador.aniadirRespuesta(respuesta);
        boton.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW,null,null)));
    }
}
