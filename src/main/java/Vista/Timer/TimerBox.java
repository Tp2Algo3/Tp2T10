package Vista.Timer;
import Modelo.Turnos.Temporizador;
import PatronObserver.Observer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;


public class TimerBox extends VBox implements Observer {
    private final ProgressIndicator porcentaje;
    private final Temporizador temporizador;

    public TimerBox(Temporizador temporizador){
        temporizador.agregarObservador(this);
        Label tiempo_restante = new Label("Tienes "+ temporizador.getDuracion() + " segundos.");
        this.temporizador = temporizador;
        porcentaje = new ProgressIndicator(-1);
        getChildren().add(tiempo_restante);
        getChildren().add(porcentaje);
        setAlignment(Pos.TOP_CENTER);
    }

    public void arrancar(){
        temporizador.iniciar();
    }

    @Override
    public void actualizar(){
        porcentaje.setProgress(temporizador.getPorcentajeActual());
    }




}
