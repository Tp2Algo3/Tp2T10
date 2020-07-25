package ClasesPreguntas.Puntajes;

public class PuntajeClasico implements Puntaje{

    private boolean usuarioContestoErroneamente(int respTotalesUsuario, int respCorrectasUsuario){
        return (respTotalesUsuario>respCorrectasUsuario);
    }

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if ((respCorrectasDelUsuario == respCorrectasDeLaPregunta) && (!usuarioContestoErroneamente(respuestasTotalesDelUsuario,respCorrectasDelUsuario)))
            return 1;
        else return 0;
    }
}