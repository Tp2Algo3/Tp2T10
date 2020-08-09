package Potenciadores;

public abstract class Multiplicador {

    protected int ordenMultiplicidad;
    protected int id;


    public int multiplicarPuntos(int puntos){
        return ordenMultiplicidad*puntos;
    }
    public int getId(){return id;}
}
