package LayoutsUI.Botones;

import Controladores.UpdateEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class BotonContinuar extends Button {

    public BotonContinuar(String texto){
        super("Enviar Respuestas");
        setOnAction(new UpdateEventHandler());
        setAlignment(Pos.CENTER);
        setPrefSize(300,50);
    }
}
