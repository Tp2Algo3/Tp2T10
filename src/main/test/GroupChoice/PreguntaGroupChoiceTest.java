package GroupChoice;

import ClasesPreguntas.Preguntas.PreguntaGroupChoice;
import ClasesPreguntas.Puntajes.PuntajeClasico;
import ClasesPreguntas.Respuestas.Respuesta;
import ClasesPreguntas.Respuestas.RespuestaGroup;
import Jugador.Jugador;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGroupChoiceTest {

    ArrayList<Respuesta> respuestasIngresadas;
    ArrayList<Respuesta> respuestasIngresadasJ1;
    ArrayList<Respuesta> respuestasIngresadasJ2;
    PuntajeClasico puntajeClasico;
    RespuestaGroup respuestaGroup;
    PreguntaGroupChoice pregGroupChoice;
    ArrayList<Respuesta> respuestasPosibles;
    ArrayList<Integer> puntajes;
    Jugador jugador;
    Jugador jugador2;

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
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes=pregGroupChoice.definirPuntajesDeJugadores();

        assertEquals(1,puntajes.get(0));
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
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
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
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
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
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores();
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test05UsarExclusividadCuandoSoloUnJugadorContestaBienMultiplicaLosPuntos(){
        respuestasIngresadasJ1 = new ArrayList<>();
        respuestasIngresadasJ2 = new ArrayList<>();
        jugador = new Jugador("nombre");
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Un jugador contesta
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",1);
            respuestasIngresadasJ1.add(respuestaGroup);
            respuestasIngresadasJ2.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo();
        }

        //Creo la pregunta
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        jugador.utilizarExclusividad(pregGroupChoice);
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadasJ1);

        //El segundo jugador contesta
        ((RespuestaGroup)respuestasIngresadasJ2.get(2)).cambiarGrupo();


        //se carga la respuesta del segundo jugador
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadasJ2);

        puntajes = pregGroupChoice.definirPuntajesDeJugadores();

        //Assert
        assertEquals(2,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test06UsarDosExclusividadesCuandoSoloUnJugadorContestaBienMultiplicaLosPuntosDosVeces(){
        respuestasIngresadasJ1 = new ArrayList<>();
        respuestasIngresadasJ2 = new ArrayList<>();
        jugador = new Jugador("nombre");
        jugador2 = new Jugador("J2");
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",1);
            respuestasIngresadasJ1.add(respuestaGroup);
            respuestasIngresadasJ2.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo();
        }

        //Creo la pregunta
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        jugador.utilizarExclusividad(pregGroupChoice);
        jugador2.utilizarExclusividad(pregGroupChoice);
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadasJ1);

        //Calculo de puntajes individuales y final
        ((RespuestaGroup)respuestasIngresadasJ2.get(2)).cambiarGrupo();
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadasJ2);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores();

        //Assert
        assertEquals(4,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test07UsarUnaExclusividadCuandoAmbosJugadoresContestaBienNoDaPuntos(){
        respuestasIngresadasJ1 = new ArrayList<>();
        respuestasIngresadasJ2 = new ArrayList<>();
        jugador = new Jugador("nombre");
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta",1);
            respuestasIngresadasJ1.add(respuestaGroup);
            respuestasIngresadasJ2.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo();
        }

        //Creo la pregunta
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        jugador.utilizarExclusividad(pregGroupChoice);


        //Calculo de puntajes individuales y final
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadasJ1);
        pregGroupChoice.calcularPuntajeIndividual(respuestasIngresadasJ2);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores();

        //Assert
        assertEquals(0,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }
}
