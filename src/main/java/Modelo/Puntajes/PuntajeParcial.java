package Modelo.Puntajes;

public class PuntajeParcial extends Puntaje{

    public PuntajeParcial(){
        this.nombre = "Puntaje Parcial";
    }

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if (usuarioContestoErroneamente(respuestasTotalesDelUsuario, respCorrectasDelUsuario))
            return 0;
        else return respCorrectasDelUsuario;
    }

    @Override
    public boolean admiteExclusividad(){
        return true;
    }
}
