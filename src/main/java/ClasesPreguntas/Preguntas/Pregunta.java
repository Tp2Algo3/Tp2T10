package ClasesPreguntas.Preguntas;

import java.util.ArrayList;
import ClasesPreguntas.Puntajes.Puntaje;
import ClasesPreguntas.Puntajes.PuntajePenalizacion;
import ClasesPreguntas.Respuestas.Respuesta;
import Jugador.Potenciadores.ExclusividadPuntaje;

public abstract class Pregunta {

    protected Puntaje tipoPuntaje;
    protected ArrayList<Respuesta> respuestasPosibles;
    protected String contenido;
    protected ArrayList <Boolean> jugadoresContestaronCorrectamente;
    protected ArrayList <Integer> puntajesJugadores;
    protected ArrayList <ExclusividadPuntaje> exclusividadesPuntaje;

    public Pregunta(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasPosibles, String pregunta) {
        this.tipoPuntaje = tipoPuntaje;
        this.contenido = pregunta;
        this.respuestasPosibles = respuestasPosibles;
        this.jugadoresContestaronCorrectamente = new ArrayList<>();
        this.puntajesJugadores = new ArrayList<>();
        this.exclusividadesPuntaje = new ArrayList<>();
    }

    public void calcularPuntajeIndividual(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta;
        cantRespuestasCorrectasDeLaPregunta =(int) respuestasPosibles.stream().filter(respuesta -> respuesta.esCorrecta()).count();
        cantRespuestasCorrectasDelUsuario =(int) respuestasDelUsuario
                .stream()
                .filter(respuesta -> respuesta.esCorrecta())
                .count();
        puntajesJugadores.add(this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantRespuestasCorrectasDeLaPregunta, respuestasDelUsuario.size()));
        jugadoresContestaronCorrectamente.add(!this.tipoPuntaje.usuarioContestoErroneamente(respuestasDelUsuario.size(), cantRespuestasCorrectasDelUsuario));
    }

    public ArrayList<Integer> definirPuntajesDeJugadores(){
        for(ExclusividadPuntaje exclusividad: exclusividadesPuntaje){
            exclusividad.multiplicarPuntos(puntajesJugadores,jugadoresContestaronCorrectamente);
        }
        return puntajesJugadores;
    }

    public void recibirExclusividad(){
        //Hacer admiteExclusividad al puntaje
        if (tipoPuntaje.getClass()== PuntajePenalizacion.class) {
            //Crear excepcion especifica
            throw new RuntimeException("Preguntas con penalizacion no pueden tener exclusividad de puntaje");
        }
            exclusividadesPuntaje.add(new ExclusividadPuntaje());
    }

    public String getContenido(){
        return contenido;
    }
}