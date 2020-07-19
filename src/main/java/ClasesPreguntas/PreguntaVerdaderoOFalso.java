import ClasesPreguntas.Respuesta;
import java.util.List;
import ClasesPrehuntas.Puntajes.*

public class PreguntaVerdaderoOFalso implements Pregunta{

    private List<Respuesta> respuestasCorrectas;
    private Puntaje tipoPuntaje;
    private List<Respuesta> respuestasPosibles;
    private String pregunta;

    public PreguntaVerdaderoOFalso(List<Respuesta> respuestasCorrectas, Puntaje tipoPuntaje, List<Respuesta> respuestasPosibles, String pregunta){
        this.respuestasCorrectas = respuestasCorrectas;
        this.tipoPuntaje = tipoPuntaje;
        this.pregunta = pregunta;
        this.respuestasPosibles = respuestasPosibles;
    }


    public int calcularPuntaje(List<Respuesta> respuestas) {
        int cantRespuestasCorrectas = 0;
        for (Respuesta resp in:respuestas){
            if (resp.esCorrecta(respuestasCorrectas))
                cantRespuestasCorrectas++;
        }
        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasespuestas));
    }


    }
}
