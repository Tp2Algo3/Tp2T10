package Modelo.Archivos;

import Modelo.Grupo.Grupo;
import Modelo.Preguntas.*;
import Modelo.Puntajes.*;
import Modelo.Respuestas.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import Modelo.Respuestas.RespuestaCorrecta;
// import sun.text.normalizer.NormalizerBase;

import com.google.gson.*;

public class LectorDeArchivosJSON implements CargadorDePreguntas{

    @Override
    public ArrayList<Pregunta> leerPreguntas() throws FileNotFoundException {
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        JsonParser parser = new JsonParser();
        Object objeto = parser.parse(new FileReader("src/main/resources/preguntas.json"));
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

        switch (tipoPuntajeString) {
            case "clasico":
                tipoPuntaje = new PuntajeClasico();
                break;
            case "penalizacion":
                tipoPuntaje = new PuntajePenalizacion();
                break;
        }
        ArrayList<Respuesta> respuestas = generarRespuestas(objetoJSON.get("respuestas").getAsJsonArray());
        return new PreguntaVerdaderoOFalso(tipoPuntaje,respuestas,contenido);
    }

    private PreguntaOpcionMultiple generarMultipleChoice(JsonObject objetoJSON){
        Puntaje tipoPuntaje = null;
        String contenido = objetoJSON.get("contenido").getAsString();
        String tipoPuntajeString = objetoJSON.get("tipoPuntaje").getAsString();

        switch (tipoPuntajeString) {
            case "clasico":
                tipoPuntaje = new PuntajeClasico();
                break;
            case "penalizacion":
                tipoPuntaje = new PuntajePenalizacion();
                break;
            case "parcial":
                tipoPuntaje = new PuntajeParcial();
                break;
        }
        ArrayList<Respuesta> respuestas = generarRespuestas(objetoJSON.get("respuestas").getAsJsonArray());
        return new PreguntaOpcionMultiple(tipoPuntaje,respuestas,contenido);

    }

    private PreguntaGroupChoice generarGroupChoice(JsonObject objetoJSON){
        Puntaje tipoPuntaje = new PuntajeClasico();
        String contenido = objetoJSON.get("contenido").getAsString();
        ArrayList lista= generarGruposYRespuestas(objetoJSON.get("grupos").getAsJsonArray());

        ArrayList<Grupo> gruposPosibles = (ArrayList<Grupo>)lista.get(0);
        ArrayList<Respuesta> respuestas = (ArrayList<Respuesta>)lista.get(1);
        
        PreguntaGroupChoice pregunta = new PreguntaGroupChoice(tipoPuntaje,respuestas,contenido);
        pregunta.setGruposPosibles(gruposPosibles);
        return pregunta;
    }

    private PreguntaOrderedChoice generarOrderedChoice(JsonObject objetoJSON){
        Puntaje tipoPuntaje = new PuntajeClasico();
        String contenido = objetoJSON.get("contenido").getAsString();
        ArrayList<Respuesta> respuestas = generarRespuestas(objetoJSON.get("respuestas").getAsJsonArray());
        return new PreguntaOrderedChoice(tipoPuntaje,respuestas,contenido);
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
        }
        return respuestas;
    }

    private ArrayList generarGruposYRespuestas(JsonArray arrayGruposJson){
        ArrayList listaGeneral = new ArrayList();
        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Respuesta> respuestas = new ArrayList<>();
        for (Object objeto: arrayGruposJson){
            JsonObject objetoJSON = (JsonObject) objeto;
            String nombre = objetoJSON.get("nombre").getAsString();

            ArrayList<RespuestaGroup> respuestasDelGrupo = new ArrayList<>();

            JsonArray respuestasGrupo = objetoJSON.get("respuestas").getAsJsonArray();
            for (JsonElement respuestaJElement: respuestasGrupo){
                RespuestaGroup respuesta = generarRespuestaGroup(respuestaJElement.getAsJsonObject());
                respuestas.add(respuesta);
                respuestasDelGrupo.add(respuesta);
            }
            grupos.add(new Grupo(nombre, respuestasDelGrupo));
        }
        listaGeneral.add(grupos);
        listaGeneral.add(respuestas);
        return listaGeneral;
    }

    private RespuestaGroup generarRespuestaGroup(JsonObject respuesta){
        String contenido = respuesta.get("contenido").getAsString();
        return new RespuestaGroup(contenido);
    }

}
