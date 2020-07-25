package ClasesPreguntas.Puntajes;

public class PuntajeParcial implements Puntaje{

    private boolean usuarioContestoErroneamente(int respTotalesUsuario, int respCorrectasUsuario){
        return (respTotalesUsuario>respCorrectasUsuario);
    }

    @Override
    public int calcularPuntaje(int respCorrectasDelUsuario, int respCorrectasDeLaPregunta, int respuestasTotalesDelUsuario) {
        if (usuarioContestoErroneamente(respuestasTotalesDelUsuario, respCorrectasDelUsuario))
            return 0;
        else return respCorrectasDelUsuario;
    }
}
