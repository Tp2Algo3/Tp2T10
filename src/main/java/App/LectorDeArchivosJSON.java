package App;

import Preguntas.*;
import Puntajes.*;
import Respuestas.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import Respuestas.RespuestaCorrecta;
import com.google.gson.*;
import org.json.*;

public class LectorDeArchivosJSON implements CargadorDePreguntas{

    @Override
    public ArrayList<Pregunta> leerPreguntas() throws FileNotFoundException {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        JsonParser parser = new JsonParser();
        Object objeto = parser.parse(new FileReader("C:\\Users\\franc\\Desktop\\Facu Franco\\Algo3\\Java\\Tp2T10\\src\\main\\java\\App\\preguntas.json"));
        JsonElement elementoJSON = (JsonElement) objeto;
        JsonObject objetoJSON = elementoJSON.getAsJsonObject();
        JsonArray arrayJSON = (JsonArray) objetoJSON.get("preguntas");
        for (Object objetoDeArray: arrayJSON) {
            preguntas.add(generarPregunta(objetoDeArray));
        }
        return preguntas;
    }

    private Pregunta generarPregunta(Object objeto){
        JsonObject objetoJSON = (JsonObject) objeto;
        JsonElement tipoPregunta = objetoJSON.get("tipoPregunta");
        if (tipoPregunta.getAsString().equals("vof")){
            return generarVoF(objetoJSON);
        }
        else if (tipoPregunta.getAsString().equals("mchoice")){
            return generarMultipleChoice(objetoJSON);
        }
        else if (tipoPregunta.getAsString().equals("gchoice")){
            return generarGroupChoice(objetoJSON);
        }
        else if (tipoPregunta.getAsString().equals("ochoice")){
            return generarOrderedChoice(objetoJSON);
        }
        return null;
    }

    private PreguntaVerdaderoOFalso generarVoF(JsonObject objetoJSON){
        Puntaje tipoPuntaje = null;
        String contenido = objetoJSON.get("contenido").getAsString();
        String tipoPuntajeString = objetoJSON.get("tipoPuntaje").getAsString();
        if (tipoPuntajeString.equals("clasico")){
            tipoPuntaje = new PuntajeClasico();
        }
        else if (tipoPuntajeString.equals("penalizacion")){
            tipoPuntaje = new PuntajePenalizacion();
        }
        ArrayList<Respuesta> respuestas = generarRespuestas(objetoJSON.get("respuestas").getAsJsonArray());
        return new PreguntaVerdaderoOFalso(tipoPuntaje,respuestas,contenido);
    }

    private PreguntaOpcionMultiple generarMultipleChoice(JsonObject objetoJSON){
        return null;
    }

    private PreguntaGroupChoice generarGroupChoice(JsonObject objetoJSON){
        return null;
    }

    private PreguntaOrderedChoice generarOrderedChoice(JsonObject objetoJSON){
        return null;
    }

    private ArrayList<Respuesta> generarRespuestas(JsonArray arrayJSON){
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        for (Object objeto: arrayJSON){
            JsonObject objetoJSON = (JsonObject) objeto;
            String tipoRespuesta = objetoJSON.get("tipoRespuesta").getAsString();
            if (tipoRespuesta.equals("Correcto")){
                respuestas.add(new RespuestaCorrecta(objetoJSON.get("contenido").getAsString()));
            }
            else if (tipoRespuesta.equals("Incorrecto")){
                respuestas.add(new RespuestaIncorrecta(objetoJSON.get("contenido").getAsString()));
            }
            else if (tipoRespuesta.equals("Ordered")){
                respuestas.add(new RespuestaOrdenada(objetoJSON.get("contenido").getAsString(),objetoJSON.get("posicion").getAsInt()));
            }
            else if (tipoRespuesta.equals("Group")){
                respuestas = null; //CAMBIAR ESTO.
            }
        }
        return respuestas;
    }

}
