package ClasesPreguntas;
import java.util.List;

public class Respuesta {

    private String respuesta;

    public Respuesta(String respuesta){
        this.respuesta = respuesta;
    }

// Revisar Disenio, esta bien que tenga la responsabilidad de san=ber si es correcta?
    public boolean pertenece(List<Respuesta> respuestas){
        return respuestas.contains(this);
    }
}
