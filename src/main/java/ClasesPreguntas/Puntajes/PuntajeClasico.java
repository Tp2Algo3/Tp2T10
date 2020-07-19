package ClasesPreguntas.Puntajes;

public class PuntajeClasico implements Puntaje{

    @Override
    public int calcularPuntaje(int respCorrectas, int respuestasTotales) {
        return respCorrectas;
    }
}