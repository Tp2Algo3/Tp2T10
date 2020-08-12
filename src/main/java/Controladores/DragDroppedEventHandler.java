package Controladores;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;
import Grupo.Grupo;
import Jugador.Jugador;
import LayoutsUI.Botones.BotonRespuestaGrupo;
import LayoutsUI.Boxes.GrupoVBox;
import Respuestas.RespuestaGroup;

public class DragDroppedEventHandler implements EventHandler<DragEvent> {

    GrupoVBox panelGrupo;

    public DragDroppedEventHandler(GrupoVBox panelGrupo) {
        this.panelGrupo = panelGrupo;
    }

    public void handle(DragEvent event) {
        /* data dropped */
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            BotonRespuestaGrupo botonRespuesta = (BotonRespuestaGrupo)event.getGestureSource();

            botonRespuesta.setPanelGrupo(panelGrupo);
            Grupo grupo = panelGrupo.getGrupo();
            RespuestaGroup respuestaGrupo =(RespuestaGroup) botonRespuesta.getRespuesta();
            respuestaGrupo.cambiarGrupo(grupo);
            Jugador jugadorActual = botonRespuesta.getJugadorActual(); 
            jugadorActual.aniadirRespuesta(respuestaGrupo);

            success = true;
        }
        /* let the source know whether the string was successfully 
         * transferred and used */
        event.setDropCompleted(success);
        
        event.consume();
     }
}