package ClasesPreguntas;

public class RespuestaIncorrecta extends Respuesta {

    public RespuestaIncorrecta(String respuesta){
        super(respuesta);
    }

    @Override
    public boolean esCorrecta() {
        return false;
    }
}