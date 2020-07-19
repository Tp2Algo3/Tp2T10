package ClasesPreguntas;
import java.util.List;

public class Respuesta {
    public boolean esCorrecta(List<Respuesta> respuestas){
        return respuestas.contains(this);
    }
}
