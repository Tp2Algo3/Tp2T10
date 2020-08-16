package Vista.Boxes;

import java.util.ArrayList;

import Controladores.CheckBox.CheckBoxEventHandlerSeleccionar;
import Modelo.Jugador.Jugador;
import Modelo.Respuestas.Respuesta;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class RespuestasMultipleBox extends VBox{

    public RespuestasMultipleBox(ArrayList<Respuesta> respuestas, Jugador jugadorActual){
        setAlignment(Pos.CENTER);
        for (Respuesta respuesta: respuestas){
            CheckBox checkBox = new CheckBox(respuesta.getContenido());
            checkBox.setAlignment(Pos.CENTER);
            checkBox.setTextAlignment(TextAlignment.JUSTIFY);
            checkBox.setOnAction(new CheckBoxEventHandlerSeleccionar(checkBox ,jugadorActual, respuesta));
            getChildren().add(checkBox);
        }
        setSpacing(10);
    }
    
}