package Modelo.Puntajes;

public abstract class Puntaje{

    protected String nombre;

    public abstract int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario);

    public boolean usuarioContestoErroneamente(int respTotalesUsuario, int respCorrectasUsuario){
        if (respTotalesUsuario == 0){
            return true;
        }
        return (respTotalesUsuario>respCorrectasUsuario);
    }

    public abstract boolean admiteExclusividad();

    public String getNombre(){
        return nombre;
    }
}