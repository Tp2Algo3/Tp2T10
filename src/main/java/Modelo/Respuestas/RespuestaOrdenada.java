package Modelo.Respuestas;

public class RespuestaOrdenada extends Respuesta{

    private int posicionCorrecta;
    private int posicionSegunElUsuario;

    public RespuestaOrdenada(String nombreRespuesta, int posicion) {
        super(nombreRespuesta);
        this.posicionCorrecta = posicion;
    }

    @Override
    public boolean esCorrecta() {
        return this.posicionCorrecta == this.posicionSegunElUsuario;
    }


    public void setPosicionRespuesta(int posicion) {
        this.posicionSegunElUsuario = posicion;
    }

}
