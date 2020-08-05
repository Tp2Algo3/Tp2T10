package ClasesPreguntas.Puntajes;

public class PuntajeClasico extends Puntaje{

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if ((respCorrectasDelUsuario == respCorrectasDeLaPregunta) && (!usuarioContestoErroneamente(respuestasTotalesDelUsuario,respCorrectasDelUsuario)))
            return 1;
        else return 0;
    }
}