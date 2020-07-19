package ClasesPreguntas.Puntajes;

public class PuntajePenalizacion implements Puntaje{
    @Override
    public int calcularPuntaje(int respuestasCorrectasUsuario, int respuestasCorrectasPregunta, int cantRespuestasUsuario){
        if (respuestasCorrectasUsuario<cantRespuestasUsuario)
            return -1;
        else if (respuestasCorrectasUsuario==respuestasCorrectasPregunta)
            return respuestasCorrectasUsuario;
        else return 0;
    }
}
