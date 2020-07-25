package ClasesPreguntas.Puntajes;

public class PuntajePenalizacion implements Puntaje{

    private boolean usuarioContestoErroneamente(int respTotalesUsuario, int respCorrectasUsuario){
        return (respTotalesUsuario>respCorrectasUsuario);
    }

    @Override
    public int calcularPuntaje(int respuestasCorrectasUsuario, int respuestasCorrectasPregunta, int cantRespuestasUsuario){
        if (usuarioContestoErroneamente(cantRespuestasUsuario,respuestasCorrectasUsuario))
            return (respuestasCorrectasUsuario-cantRespuestasUsuario);
        else if (respuestasCorrectasUsuario==respuestasCorrectasPregunta)
            return respuestasCorrectasUsuario;
        else return 0;
    }
}
