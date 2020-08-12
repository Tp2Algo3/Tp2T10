package Vista.Botones;

import Controladores.AniadirRespuestaEventHandler;
import Controladores.EliminarRespuestaEventHandler;
import Modelo.Jugador.Jugador;
import PatronObserver.Observer;
import Modelo.Respuestas.Respuesta;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonRespuestaOrdenada extends Button implements Observer {

    private final Jugador jugadorActual;
    private final Respuesta respuesta;
    private final String styleOriginal;
    private HBox respDeUsuario;
    private VBox panelRespuestas;

    public BotonRespuestaOrdenada(Respuesta respuesta, Jugador jugadorActual, HBox respDeUsuario, VBox panelRespuestas) {
        super(respuesta.getContenido());
        this.jugadorActual = jugadorActual;
        this.respuesta = respuesta;
        this.respDeUsuario = respDeUsuario;
        this.panelRespuestas = panelRespuestas;

        setOnAction(new AniadirRespuestaEventHandler(respuesta, jugadorActual));
        setCursor(Cursor.HAND);

        jugadorActual.agregarObservador(this);
        this.styleOriginal = getStyle();
    }

    @Override
    public void actualizar() {
        if(jugadorActual.getRespuestasElegidas().contains(respuesta)) {
            setStyle("-fx-background-color: #69CFBF; -fx-text-fill: #000000");
            if (!respDeUsuario.getChildren().contains(this)) {
                respDeUsuario.getChildren().add(this);
            }
            panelRespuestas.getChildren().remove(this);
            setOnAction(new EliminarRespuestaEventHandler(respuesta, jugadorActual));
        }
        else{
            setStyle(styleOriginal);
            respDeUsuario.getChildren().remove(this);
            if (!panelRespuestas.getChildren().contains(this)) {
                panelRespuestas.getChildren().add(this);
            }
            setOnAction(new AniadirRespuestaEventHandler(respuesta, jugadorActual));
        }
    }
}