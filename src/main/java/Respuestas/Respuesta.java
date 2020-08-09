package Respuestas;

public abstract class Respuesta implements Cloneable{

    private String respuesta;

    public Respuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public abstract boolean esCorrecta();

    public String getContenido(){
        return respuesta;
    }

    public Respuesta clone(){
        Object clon;
        try {
            clon = super.clone();
        }catch(CloneNotSupportedException excepcion){
            throw new RuntimeException("No se puede clonar al objeto.");
        }
        return (Respuesta)clon;
    }
}