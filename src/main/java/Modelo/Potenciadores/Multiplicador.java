package Modelo.Potenciadores;

public abstract class Multiplicador{

    protected int ordenMultiplicidad;


    public int multiplicarPuntos(int puntos) {
        return ordenMultiplicidad * puntos;
    }

    public int getOrdenMultiplicidad(){
        return ordenMultiplicidad;
    }

    @Override
    public boolean equals(Object obj) {
        return (ordenMultiplicidad == (((Multiplicador)obj).getOrdenMultiplicidad()));
    }
}

