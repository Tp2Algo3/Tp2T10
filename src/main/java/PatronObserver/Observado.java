package PatronObserver;

import java.util.ArrayList;

public abstract class Observado {

    protected ArrayList<Observer> observadores;

    public void agregarObservador(Observer observer){
        observadores.add(observer);
    }

    public void quitarObservador(Observer observer){
        observadores.remove(observer);
    }

    public void notificar(){
        for (Observer observer : observadores) {
            observer.actualizar();
        }
    }
}
