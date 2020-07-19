package ClasesPreguntas;
import java.util.ArrayList;

public class Respuesta {

    private String respuesta;

    public Respuesta(String respuesta){
        this.respuesta = respuesta;
    }

// Revisar Disenio, esta bien que tenga la responsabilidad de saber si es correcta?
    public boolean pertenece(ArrayList<Respuesta> respuestas){
        return respuestas.contains(this);
    }
}
