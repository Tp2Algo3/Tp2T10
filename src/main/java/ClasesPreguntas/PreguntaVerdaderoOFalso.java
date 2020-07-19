import ClasesPreguntas.Respuesta;
import java.util.List;



public class PreguntaVerdaderoOFalso implements Pregunta{
    private List<Respuesta> respuestasCorrectas;
    private final static int PUNTAJE = 1;

    public PreguntaVerdaderoOFalso(List<Respuesta> respuestasCorrectas){
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public int calcularPuntaje(Respuesta respuesta){
        if(respuesta.esCorrecta(respuestasCorrectas)){
            return PUNTAJE;
        }

    }
}
