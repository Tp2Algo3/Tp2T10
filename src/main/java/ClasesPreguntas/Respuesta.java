package ClasesPreguntas;
import java.util.ArrayList;

public abstract class Respuesta {

    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public abstract boolean esCorrecta();
}