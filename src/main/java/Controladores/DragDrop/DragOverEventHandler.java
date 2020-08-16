package Controladores.DragDrop;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;

public class DragOverEventHandler implements EventHandler<DragEvent> {

    VBox panelGrupo;

    public DragOverEventHandler(VBox panelGrupo) {
        this.panelGrupo = panelGrupo;
    }

    public void handle(DragEvent event) {
        /* data is dragged over the target */
        /* accept it only if it is not dragged from the same node 
         * and if it has a string data */
        if (event.getGestureSource() != panelGrupo &&
                event.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        
        event.consume();
    }
}