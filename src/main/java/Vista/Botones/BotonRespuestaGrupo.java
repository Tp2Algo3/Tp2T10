package Vista.Botones;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import Controladores.DragDrop.DragDetectedEventHandler;
import Controladores.EliminarRespuestaEventHandler;
import Modelo.Jugador.Jugador;
import Vista.Boxes.GrupoVBox;
import PatronObserver.Observer;
import Modelo.Respuestas.Respuesta;
import javafx.scene.layout.HBox;

public class BotonRespuestaGrupo extends Button implements Observer{
    private final Jugador jugadorActual;
    private final Respuesta respuesta;
    private HBox panelRespuestas;
    private GrupoVBox panelGrupo;

    public BotonRespuestaGrupo(Respuesta respuesta, Jugador jugadorActual, HBox panelRespuestas) {
        super(respuesta.getContenido());
        this.jugadorActual = jugadorActual;
        this.respuesta = respuesta;
        this.panelRespuestas = panelRespuestas;

        setSiSePuedeArrastrar();
        
        jugadorActual.agregarObservador(this);
        setCursor(Cursor.CLOSED_HAND);
    }

    @Override
    public void actualizar() {

        if(jugadorActual.getRespuestasElegidas().contains(respuesta)) {
            // El jugador acaba de aniadir una respuesta
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
    }

    private void setNoSePuedeArrastrar() {
        setOnAction(new EliminarRespuestaEventHandler(respuesta, jugadorActual));
        setOnDragDetected(null);
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