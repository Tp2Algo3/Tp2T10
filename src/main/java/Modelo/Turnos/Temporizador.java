package Modelo.Turnos;

import PatronObserver.Observado;
import PatronObserver.Observer;
import Vista.KahootApp;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Temporizador extends Timer {

    private final TimerTask tarea;
    private ArrayList<Observer> observers;
    private int tiempoActual;
    private final int duracion;
    private float porcentajeActual;
    private final Observado observadorIntermediario;

    public Temporizador(int demora){
        duracion = demora;
        tiempoActual = demora;
        tarea = new TimerTask()
        {
            public void run()
            {
                tiempoActual-=1000;
                porcentajeActual = ((float)tiempoActual)/((float)duracion);
                observadorIntermediario.notificar();
                if (tiempoActual==0){
                    KahootApp.update();
                }
            }
        };
        observadorIntermediario = new ObservadoTimer();
    }

    public int getDuracion(){
        return duracion/1000;
    }

    public float getPorcentajeActual(){
        return porcentajeActual;
    }

    public void agregarObservador(Observer observer){
        observadorIntermediario.agregarObservador(observer);
    }

    public void quitarObservador(Observer observer){
        observadorIntermediario.quitarObservador(observer);
    }

    public void iniciar(){
        schedule(tarea,0,1000);
    }

    public Temporizador generarNuevoTemporizador(){
        cancel();
        purge();
        Temporizador nuevo = new Temporizador(duracion);
        return nuevo;
    }
}
