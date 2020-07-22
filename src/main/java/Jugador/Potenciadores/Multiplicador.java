package Jugador.Potenciadores;

public class Multiplicador implements Potenciador{

    protected int ordenMultiplicidad;

    @Override
    public int multiplicarPuntos(int puntos){
        return ordenMultiplicidad*puntos;
    }
}
