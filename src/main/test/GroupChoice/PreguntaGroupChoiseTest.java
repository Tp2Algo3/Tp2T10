package GroupChoice;

import ClasesPreguntas.*;
import ClasesPreguntas.Puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiseTest {

    ArrayList<Respuesta> respuestasIngresadas;
    PuntajeClasico puntajeClasico;
    RespuestaGroup respuestaGroup;
    PreguntaGroupChoice pregGroupChoice;
    ArrayList<Respuesta> respuestasPosibles;

    @Test
    public void test01AcertarCompletamenteUnGroupChoiceTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",1);
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo();

        }

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(1,pregGroupChoice.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test02AcertarParcialmenteUnGroupChoiceNoTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",1);
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo();

        }
        respuestaGroup.cambiarGrupo();

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(0,pregGroupChoice.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test03NoAcertarUnGroupChoiceNoTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",2);
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo();

        }

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(0,pregGroupChoice.calcularPuntaje(respuestasIngresadas));
    }

    @Test
    public void test04NoResponderUnGroupChoiceNoTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",1);
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);

        }

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        assertEquals(0,pregGroupChoice.calcularPuntaje(respuestasIngresadas));
    }

}
