package Modelo.Respuestas;

public class RespuestaCorrecta extends Respuesta {

    public RespuestaCorrecta(String respuesta){
        super(respuesta);
    }

    @Override
    public boolean esCorrecta() {
        return true;
    }
}
