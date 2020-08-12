package Controladores;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.*;


public class DragDetectedEventHandler implements EventHandler<MouseEvent> {

    Button boton;

    public DragDetectedEventHandler(Button boton) {
        this.boton = boton;
    }

    public void handle(MouseEvent event) {
        /* drag was detected, start a drag-and-drop gesture*/
        /* allow any transfer mode */
        Dragboard db = boton.startDragAndDrop(TransferMode.ANY);
        
        /* Put a string on a dragboard */
        ClipboardContent content = new ClipboardContent();
        content.putString(boton.getText());
        db.setContent(content);

        db.setDragView(new Text(boton.getText()).snapshot(null, null), event.getX(), event.getY());

        event.consume();
    }
}