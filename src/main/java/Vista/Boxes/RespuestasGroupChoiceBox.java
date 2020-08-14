package Vista.Boxes;

import Modelo.Jugador.Jugador;
import Modelo.Respuestas.Respuesta;
import Modelo.Respuestas.RespuestaGroup;
import Vista.Botones.BotonRespuestaGrupo;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class RespuestasGroupChoiceBox extends HBox {
    public RespuestasGroupChoiceBox(ArrayList<Respuesta> respuestas, Jugador jugadorActual){
        for (Respuesta respuesta : respuestas) {
            Button boton = new BotonRespuestaGrupo(respuesta, jugadorActual, this);
            getChildren().add(boton);
        }
        double alturaActual = getHeight();
        double anchoActual = getWidth();
        setSpacing(5);
        setMinSize(anchoActual, alturaActual);
        setAlignment(Pos.CENTER);
    }
}
