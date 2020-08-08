package Potenciadores;

public abstract class Multiplicador {

    protected int ordenMultiplicidad;


    public int multiplicarPuntos(int puntos){
        return ordenMultiplicidad*puntos;
    }
}
