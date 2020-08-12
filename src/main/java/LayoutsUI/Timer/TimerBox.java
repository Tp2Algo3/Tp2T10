package LayoutsUI.Timer;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.VBox;
import java.util.Timer;
import java.util.TimerTask;


public class TimerBox extends VBox {
    private int duracion;
    private int tiempo_actual;
    private TimerTask temporizador;
    private ProgressIndicator porcentaje;
    private Timer contador;

    public TimerBox(int tiempo){
        duracion = tiempo;
        tiempo_actual = tiempo;
        Label tiempo_restante = new Label("Tienes "+ tiempo + " segundos.");

        porcentaje = new ProgressIndicator(-1);
        getChildren().add(tiempo_restante);
        getChildren().add(porcentaje);


        setAlignment(Pos.TOP_CENTER);
        contador = new Timer();
        temporizador = new TimerTask()
        {
            public void run()
            {
                tiempo_actual--;
                float valor = ((float)tiempo_actual)/((float)duracion);
                porcentaje.setProgress(valor);
               // tiempo_restante.setText(tiempo_actual+ " seg"); //Rompe
            }

        };
    }

    public void arrancar(){
        contador.schedule(temporizador,0,1000);
    }




}
