package ClasesPreguntas;

import ClasesPreguntas.Puntajes.Puntaje;

import java.util.ArrayList;

public class PreguntaOrderedChoice extends Pregunta{

    public PreguntaOrderedChoice(Puntaje tipoPuntaje, ArrayList<Respuesta> respuestasOrdenadas, String pregunta){
        super(tipoPuntaje, respuestasOrdenadas, pregunta);
        if(respuestasPosibles.size() > 5 || respuestasPosibles.size() < 2)
            throw new RuntimeException("Cantidad de respuestas posibles inválida.");
    }

//    @Override
//    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
//        int cantRespuestasCorrectasDeLaPregunta =(int) respuestasPosibles
//                .stream()
//                .filter(respuesta -> respuesta.esCorrecta())
//                .count();
//    }

    @Override
    public int calcularPuntaje(ArrayList<Respuesta> respuestasDelUsuario) {
        int cantRespuestasCorrectasDelUsuario = 0;

        for (int i = 0; i < respuestasDelUsuario.size(); i++) {
            RespuestaOrdenada respuestaOrdenada = (RespuestaOrdenada) respuestasDelUsuario.get(i);
            respuestaOrdenada.setPosicionSegunElUsuario(i);

            if (respuestaOrdenada.esCorrecta()) { cantRespuestasCorrectasDelUsuario++; }
        }

        int cantOpcionesDeLaPregunta = this.respuestasPosibles.size();

        return (this.tipoPuntaje.calcularPuntaje(cantRespuestasCorrectasDelUsuario, cantOpcionesDeLaPregunta, respuestasDelUsuario.size()));
    }
}
