package Respuestas;

public abstract class Respuesta {

    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public abstract boolean esCorrecta();

    public String getContenido(){
        return respuesta;
    }
}