package ClasesPreguntas.Puntajes;

public class PuntajePenalizacion extends Puntaje{

    @Override
    public int calcularPuntaje(int respuestasCorrectasUsuario, int respuestasCorrectasPregunta, int cantRespuestasUsuario){
        if (usuarioContestoErroneamente(cantRespuestasUsuario,respuestasCorrectasUsuario))
            return (respuestasCorrectasUsuario-cantRespuestasUsuario);
        else if (respuestasCorrectasUsuario==respuestasCorrectasPregunta)
            return respuestasCorrectasUsuario;
        else return 0;
    }
}
