package Vista.Boxes;

import java.util.ArrayList;

import Controladores.CheckBoxEventHandlerSeleccionar;
import Modelo.Jugador.Jugador;
import Modelo.Respuestas.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class RespuestasMultipleBox extends VBox{

    public RespuestasMultipleBox(ArrayList<Respuesta> respuestas, Jugador jugadorActual){
        for (Respuesta respuesta: respuestas){
            CheckBox checkBox = new CheckBox(respuesta.getContenido());
            checkBox.setAlignment(Pos.CENTER);
            checkBox.setOnAction(new CheckBoxEventHandlerSeleccionar(checkBox ,jugadorActual, respuesta));
            getChildren().add(checkBox);
        }
        setAlignment(Pos.CENTER);
    }
    
}