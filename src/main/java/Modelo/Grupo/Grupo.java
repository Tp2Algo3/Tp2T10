package Modelo.Grupo;

import Modelo.Respuestas.Respuesta;
import Modelo.Respuestas.RespuestaGroup;

import java.util.ArrayList;

public class Grupo {

    private ArrayList<RespuestaGroup> respuestasPertenecientes;
    private String nombreGrupo;

    public Grupo(String nombre, ArrayList<RespuestaGroup> respPertenecientes){
        respuestasPertenecientes = respPertenecientes;
        nombreGrupo = nombre;
    }

    public boolean poseeRespuesta(RespuestaGroup respuesta){
        for (Respuesta respuestaPerteneciente: respuestasPertenecientes) {
            if (respuestaPerteneciente.getContenido().equals(respuesta.getContenido())){
                return true;
            }
        }
        return false;
    }

    //Para fines de UI
    public String getNombre(){return nombreGrupo;}

    //UTILIZADA CON FINES DE TESTING
    public void aniadirRespuesta(RespuestaGroup respuesta){
        respuestasPertenecientes.add(respuesta);
    }

}
