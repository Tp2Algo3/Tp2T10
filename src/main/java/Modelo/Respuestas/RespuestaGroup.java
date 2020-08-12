package Modelo.Respuestas;

import Modelo.Grupo.Grupo;

public class RespuestaGroup extends Respuesta{
    private Grupo grupoElegidoPorJugador;

    public RespuestaGroup(String respuesta){
        super(respuesta);
    }

    @Override
    public boolean esCorrecta() {
        if (grupoElegidoPorJugador == null){
            return false;
        }
        return grupoElegidoPorJugador.poseeRespuesta(this);
    }

    public void cambiarGrupo(Grupo grupo){
        grupoElegidoPorJugador = grupo;
    }
}
