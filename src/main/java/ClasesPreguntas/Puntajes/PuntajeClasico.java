package ClasesPreguntas.Puntajes;

public class PuntajeClasico implements Puntaje{

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if ((respCorrectasDelUsuario == respCorrectasDeLaPregunta) && (respCorrectasDelUsuario == respuestasTotalesDelUsuario))
            return respCorrectasDelUsuario;
        else return 0;
    }
}