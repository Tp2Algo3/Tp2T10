package Controladores.CheckBox;

import Modelo.Jugador.Jugador;
import Modelo.Respuestas.Respuesta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

public class CheckBoxEventHandlerSeleccionar implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private CheckBox checkBox;
    private Respuesta respuesta;

    public CheckBoxEventHandlerSeleccionar(CheckBox checkBox, Jugador jugadorActual, Respuesta respuesta) {
        this.checkBox = checkBox;
        this.jugador = jugadorActual;
        this.respuesta = respuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        checkBox.setSelected(true);
        jugador.aniadirRespuesta(respuesta);
        checkBox.setOnAction(new CheckBoxEventHandlerDeseleccionar(checkBox, jugador, respuesta));
    }
}
