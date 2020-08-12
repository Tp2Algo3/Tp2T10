package Modelo.Puntajes;

public class PuntajePenalizacion extends Puntaje{

    public PuntajePenalizacion(){
        this.nombre = "Puntaje Penalizacion";
    }

    @Override
    public int calcularPuntaje(int respuestasCorrectasUsuario, int respuestasCorrectasPregunta, int cantRespuestasUsuario){
        if (usuarioContestoErroneamente(cantRespuestasUsuario,respuestasCorrectasUsuario))
            return (respuestasCorrectasUsuario-cantRespuestasUsuario);
        else if (respuestasCorrectasUsuario==respuestasCorrectasPregunta)
            return respuestasCorrectasUsuario;
        else return 0;
    }

    @Override
    public boolean admiteExclusividad(){
        return false;
    }
}
