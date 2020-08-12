package Controladores;

import App.KahootApp;
import LayoutsUI.Botones.BotonRespuestaGrupo;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import LayoutsUI.Boxes.GrupoVBox;

public class DragDoneEventHandler implements EventHandler<DragEvent> {
    
    BotonRespuestaGrupo boton;

    public DragDoneEventHandler(Button boton) {
        this.boton = (BotonRespuestaGrupo) boton;
    }

    public void handle(DragEvent event) {
        /* Se termino de arrastrar el objeto y se solto en una caja.*/

        /* the drag and drop gesture ended */
        /* if the data was successfully moved, clear it */
        // if (event.getTransferMode() == TransferMode.MOVE) {
            
        //     GrupoVBox panelGrupo = (GrupoVBox) event.getGestureTarget();
        //     boton.setPanelGrupo(panelGrupo);
        // }

        event.consume();
    }
}