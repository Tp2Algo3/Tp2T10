package Controladores.DragDrop;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;


public class MouseClickDragEventHandler implements EventHandler<MouseEvent> {

    private Button boton;

    public MouseClickDragEventHandler(Button boton){
        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Dragboard dragboard = boton.startDragAndDrop(TransferMode.ANY);
        ClipboardContent contenido = new ClipboardContent();
        contenido.putString(boton.getText());
        dragboard.setContent(contenido);
        mouseEvent.setDragDetect(true);
    }
}
