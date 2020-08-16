package Controladores.CheckBox;

import Modelo.Jugador.Jugador;
import Modelo.Respuestas.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class CheckBoxEventHandlerDeseleccionar implements EventHandler<ActionEvent> {

    private CheckBox checkBox;
    private Jugador jugador;
    private Respuesta respuesta;

    public CheckBoxEventHandlerDeseleccionar(CheckBox checkBox, Jugador jugador, Respuesta respuesta) {
        this.checkBox = checkBox;
        this.jugador = jugador;
        this.respuesta = respuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        checkBox.setSelected(false);
        jugador.eliminarRespuesta(respuesta);
        checkBox.setOnAction(new CheckBoxEventHandlerSeleccionar(checkBox, jugador, respuesta));
    }

}
