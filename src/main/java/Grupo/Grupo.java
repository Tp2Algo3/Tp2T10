package Grupo;

import Respuestas.RespuestaGroup;

import java.util.ArrayList;

public class Grupo {

    private ArrayList<RespuestaGroup> respuestasPertenecientes;
    private String nombreGrupo;

    public Grupo(String nombre, ArrayList<RespuestaGroup> respPertenecientes){
        respuestasPertenecientes = respPertenecientes;
        nombreGrupo = nombre;
    }

    public boolean poseeRespuesta(RespuestaGroup respuesta){
        return respuestasPertenecientes.contains(respuesta);
    }

    //Para fines de UI
    public String getNombre(){return nombreGrupo;}

    //UTILIZADA CON FINES DE TESTING
    public void aniadirRespuesta(RespuestaGroup respuesta){
        respuestasPertenecientes.add(respuesta);
    }

}
