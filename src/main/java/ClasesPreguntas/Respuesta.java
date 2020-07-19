package ClasesPreguntas;
import java.util.ArrayList;

public class Respuesta {

    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    // Revisar Disenio, esta bien que tenga la responsabilidad de san=ber si es correcta?
    public boolean pertenece(ArrayList<Respuesta> respuestas) {
        for (Respuesta respuesta_posible : respuestas) {
            if (respuesta_posible.getRespuesta().equals(this.respuesta)) {
                return true;
            }
        }
        return false;
    }
}