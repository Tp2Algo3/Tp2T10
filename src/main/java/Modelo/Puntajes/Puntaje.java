package Modelo.Puntajes;

public abstract class Puntaje{
    public abstract int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario);

    public boolean usuarioContestoErroneamente(int respTotalesUsuario, int respCorrectasUsuario){
        if (respTotalesUsuario == 0){
            return false;
        }
        return (respTotalesUsuario>respCorrectasUsuario);
    }

    public abstract boolean admiteExclusividad();
}