package Vista.Timer;


import Modelo.Turnos.Temporizador;
import javafx.scene.control.Label;

public class LabelUpdatorRunnable implements Runnable{

    private Temporizador temporizador;
    private TimerBox timerBox;

    public LabelUpdatorRunnable(TimerBox box, Temporizador temporizador){
        this.temporizador = temporizador;
        this.timerBox = box;
    }

    @Override
    public void run() {
        ((Label)timerBox.getChildren().get(0)).setText("Tienes "+ temporizador.getTiempoActual() + " segundos.");
    }
}
