package Controladores.DragDrop;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MouseReleaseDragDone implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent mouseEvent) {
        mouseEvent.setDragDetect(false);
    }
}
