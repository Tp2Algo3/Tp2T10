package Vista.Timer;
import Modelo.Turnos.Temporizador;
import PatronObserver.Observer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;


public class TimerBox extends VBox implements Observer {
    private final ProgressIndicator porcentaje;
    private final Temporizador temporizador;
    private final LabelUpdatorRunnable updatorTiempoRestante;

    public TimerBox(Temporizador temporizador){
        temporizador.agregarObservador(this);
        Label tiempoRestante = new Label("Tienes "+ temporizador.getDuracion() + " segundos.");
        this.temporizador = temporizador;
        this.updatorTiempoRestante = new LabelUpdatorRunnable(this, temporizador);
        porcentaje = new ProgressIndicator(-1);
        getChildren().add(tiempoRestante);
        getChildren().add(porcentaje);
        setAlignment(Pos.TOP_CENTER);
    }

    public void arrancar(){
        temporizador.iniciar();
    }

    @Override
    public void actualizar(){
        Platform.runLater(updatorTiempoRestante);
        porcentaje.setProgress(temporizador.getPorcentajeActual());
    }




}
