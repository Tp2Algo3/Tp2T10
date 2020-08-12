package LayoutsUI.Botones;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import Controladores.AniadirRespuestaEventHandler;
import Controladores.DragDetectedEventHandler;
import Controladores.DragDoneEventHandler;
import Controladores.EliminarRespuestaEventHandler;
import Jugador.Jugador;
import LayoutsUI.Boxes.GrupoVBox;
import PatronObserver.Observer;
import Respuestas.Respuesta;
import javafx.css.Style;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BotonRespuestaGrupo extends Button implements Observer{
    private final Jugador jugadorActual;
    private final Respuesta respuesta;
    private final String styleOriginal;
    private HBox panelRespuestas;
    private GrupoVBox panelGrupo;

    public BotonRespuestaGrupo(Respuesta respuesta, Jugador jugadorActual, HBox panelRespuestas) {
        super(respuesta.getContenido());
        this.jugadorActual = jugadorActual;
        this.respuesta = respuesta;
        this.panelRespuestas = panelRespuestas;

        setSiSePuedeArrastrar();
        
        jugadorActual.agregarObservador(this);
        this.styleOriginal = getStyle();
        setCursor(Cursor.CLOSED_HAND);
    }

    @Override
    public void actualizar() {

        if(jugadorActual.getRespuestasElegidas().contains(respuesta)) {
            // El jugador acaba de aniadir una respuesta
            // setStyle("-fx-background-color: #69CFBF; -fx-text-fill: #000000");
            if (panelGrupo != null && !panelGrupo.getChildren().contains(this)) {
                panelGrupo.getChildren().add(this);
            }
            panelRespuestas.getChildren().remove(this);
            setCursor(Cursor.HAND);
            setNoSePuedeArrastrar();

        }
        else{
            // El jugador acacba de remover una respuesta
            if (panelGrupo != null) {
                panelGrupo.getChildren().remove(this);
            }
            if (!panelRespuestas.getChildren().contains(this)) {
                panelRespuestas.getChildren().add(this);
                setCursor(Cursor.CLOSED_HAND);
            }
            setSiSePuedeArrastrar();
        }
    }

    private void setSiSePuedeArrastrar(){
        setOnDragDetected(new DragDetectedEventHandler(this));
        setOnDragDone(new DragDoneEventHandler(this));  
    }

    private void setNoSePuedeArrastrar() {
        setOnAction(new EliminarRespuestaEventHandler(respuesta, jugadorActual));
        setOnDragDetected(null);
        setOnDragDone(null);
    }

    public Respuesta getRespuesta(){
        return this.respuesta;
    }

    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }

    public void setPanelGrupo(GrupoVBox panelGrupo) {
        this.panelGrupo = panelGrupo;
    }
}