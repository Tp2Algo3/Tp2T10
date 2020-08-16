package Controladores.DragDrop;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;


public class DragDetectedEventHandler implements EventHandler<MouseEvent> {

    private Button boton;

    public DragDetectedEventHandler(Button boton) {
        this.boton = boton;
    }

    public void handle(MouseEvent event) {
        Dragboard dragboard = boton.startDragAndDrop(TransferMode.ANY);
        ClipboardContent contenido = new ClipboardContent();
        contenido.putString(boton.getText());
        dragboard.setContent(contenido);
        event.consume();
    }
}