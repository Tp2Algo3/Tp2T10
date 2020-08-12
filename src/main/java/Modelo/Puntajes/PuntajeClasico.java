package Modelo.Puntajes;

public class PuntajeClasico extends Puntaje{

    public PuntajeClasico(){
        this.nombre = "Puntaje Clásico";
    }

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if ((respCorrectasDelUsuario == respCorrectasDeLaPregunta) && (!usuarioContestoErroneamente(respuestasTotalesDelUsuario,respCorrectasDelUsuario)))
            return 1;
        else return 0;
    }

    @Override
    public boolean admiteExclusividad(){
        return true;
    }
}