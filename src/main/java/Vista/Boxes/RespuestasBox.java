package Vista.Boxes;

import Modelo.Jugador.Jugador;
import Vista.Botones.BotonRespuesta;
import Modelo.Respuestas.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class RespuestasBox extends VBox {

    public RespuestasBox(ArrayList<Respuesta> respuestas, Jugador jugadorActual){
        for (Respuesta respuesta: respuestas){
            Button boton = new BotonRespuesta(respuesta, jugadorActual);
            getChildren().add(boton);
        }
        setSpacing(25);
        setAlignment(Pos.CENTER);
    }
}
