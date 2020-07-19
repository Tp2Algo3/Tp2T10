package ClasesPreguntas;
import java.util.List;

public class Respuesta {

    private String respuesta;

    public Respuesta(String respuesta){
        this.respuesta = respuesta;
    }

    public boolean esCorrecta(List<Respuesta> respuestas){
        return respuestas.contains(this);
    }
}
