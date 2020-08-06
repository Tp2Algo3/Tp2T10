package ClasesPreguntas.Respuestas;

public class RespuestaGroup extends Respuesta{
    private int grupoCorrecto;
    private int grupoElegidoPorJugador;

    public RespuestaGroup(String respuesta, int grupo){
        super(respuesta);
        grupoCorrecto = grupo;
        grupoElegidoPorJugador = 0;
        if(grupo>2 || grupo < 1){
            throw new RuntimeException("Grupo de Respuesta invalido."); //Cambiar por Illegal
        }
    }

    @Override
    public boolean esCorrecta() {
        return grupoCorrecto == grupoElegidoPorJugador;
    }

    public void cambiarGrupo(){
        grupoElegidoPorJugador++;
        grupoElegidoPorJugador = grupoElegidoPorJugador % 3;
    }
}
