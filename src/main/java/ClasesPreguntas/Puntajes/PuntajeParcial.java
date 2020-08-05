package ClasesPreguntas.Puntajes;

public class PuntajeParcial extends Puntaje{

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if (usuarioContestoErroneamente(respuestasTotalesDelUsuario, respCorrectasDelUsuario))
            return 0;
        else return respCorrectasDelUsuario;
    }
}
