public class PreguntaVerdaderoOFalso implements Pregunta{
    private List<Respuesta> respuestasCorrectas;

    public PreguntaVerdaderoOFaslo(List<Respuesta> respuestasCorrectas){
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public int calcularPuntaje(Respuesta respuesta){
        respuesta.esCorrecta(respuestasCorrectas);
    }
}
