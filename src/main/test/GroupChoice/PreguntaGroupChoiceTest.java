package GroupChoice;

import Modelo.Grupo.Grupo;
import Modelo.Preguntas.PreguntaGroupChoice;
import Modelo.Preguntas.PreguntaVerdaderoOFalso;
import Modelo.Puntajes.PuntajeClasico;
import Modelo.Respuestas.Respuesta;
import Modelo.Respuestas.RespuestaCorrecta;
import Modelo.Respuestas.RespuestaGroup;
import Modelo.Jugador.Jugador;
import Modelo.Respuestas.RespuestaIncorrecta;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntaGroupChoiceTest {

    ArrayList<RespuestaGroup> respuestasGrupo1;
    ArrayList<RespuestaGroup> respuestasGrupo2;
    ArrayList<Respuesta> respuestasIngresadas;
    ArrayList<Respuesta> respuestasIngresadasJ1;
    ArrayList<Respuesta> respuestasIngresadasJ2;
    ArrayList<ArrayList<Respuesta>> respuestasJugadores;
    PuntajeClasico puntajeClasico;
    RespuestaGroup respuestaGroup;
    PreguntaGroupChoice pregGroupChoice;
    ArrayList<Respuesta> respuestasPosibles;
    ArrayList<Integer> puntajes;
    Jugador jugador;
    Jugador jugador2;
    Grupo grupo1;
    Grupo grupo2;

    @Test
    public void test01AcertarCompletamenteUnGroupChoiceTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        grupo1 = new Grupo("Modelo.Grupo n1", new ArrayList<>());
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo(grupo1);
            grupo1.aniadirRespuesta(respuestaGroup);
        }


        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);

        assertEquals(1,puntajes.get(0));
    }

    @Test
    public void test02AcertarParcialmenteUnGroupChoiceNoTeDaElPunto(){
        //Inicialización
        grupo1 = new Grupo("Modelo.Grupo n1", new ArrayList<>());
        grupo2 = new Grupo("Modelo.Grupo n2", new ArrayList<>());
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            respuestaGroup.cambiarGrupo(grupo1);
            grupo1.aniadirRespuesta(respuestaGroup);

        }
        respuestaGroup.cambiarGrupo(grupo2);

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test03NoAcertarUnGroupChoiceNoTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        grupo1 = new Grupo("Modelo.Grupo n1", new ArrayList<>());
        grupo2 = new Grupo("Modelo.Grupo n2", new ArrayList<>());
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            grupo2.aniadirRespuesta(respuestaGroup);
            respuestaGroup.cambiarGrupo(grupo1);

        }

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test04NoResponderUnGroupChoiceNoTeDaElPunto(){
        //Inicialización
        respuestasIngresadas = new ArrayList<>();
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            respuestasIngresadas.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);

        }

        //Creación de la pregunta y assert
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        respuestasJugadores.add(respuestasIngresadas);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);
        assertEquals(0,puntajes.get(0));
    }

    @Test
    public void test05UsarExclusividadCuandoSoloUnJugadorContestaBienMultiplicaLosPuntos(){
        respuestasIngresadasJ2 = new ArrayList<>();
        jugador = new Jugador("nombre");
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        grupo1 = new Grupo("Modelo.Grupo n1", new ArrayList<>());
        grupo2 = new Grupo("Modelo.Grupo n2", new ArrayList<>());
        respuestasJugadores = new ArrayList<>();

        //Un jugador contesta
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            jugador.aniadirRespuesta(respuestaGroup);
            respuestasIngresadasJ2.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            grupo1.aniadirRespuesta(respuestaGroup);
            respuestaGroup.cambiarGrupo(grupo1);
        }

        //Creo la pregunta
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        jugador.utilizarExclusividad(pregGroupChoice);
        respuestasJugadores.add(jugador.responderPregunta());

        //El segundo jugador contesta
        ((RespuestaGroup)respuestasIngresadasJ2.get(2)).cambiarGrupo(grupo2);


        //se carga la respuesta del segundo jugador
        respuestasJugadores.add(respuestasIngresadasJ2);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);

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
        grupo1 = new Grupo("Modelo.Grupo n1", new ArrayList<>());
        grupo2 = new Grupo("Modelo.Grupo n2", new ArrayList<>());
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            jugador.aniadirRespuesta(respuestaGroup);
            respuestasIngresadasJ2.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            grupo1.aniadirRespuesta(respuestaGroup);
            respuestaGroup.cambiarGrupo(grupo1);
        }

        //Creo la pregunta
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        jugador.utilizarExclusividad(pregGroupChoice);
        jugador2.utilizarExclusividad(pregGroupChoice);
        respuestasJugadores.add(jugador.responderPregunta());

        //Calculo de puntajes individuales y final
        ((RespuestaGroup)respuestasIngresadasJ2.get(2)).cambiarGrupo(grupo2);
        respuestasJugadores.add(respuestasIngresadasJ2);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);
        //Assert
        assertEquals(4,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test07UsarUnaExclusividadCuandoAmbosJugadoresContestanBienNoDaPuntos(){
        respuestasIngresadasJ1 = new ArrayList<>();
        respuestasIngresadasJ2 = new ArrayList<>();
        jugador = new Jugador("nombre");
        respuestasPosibles = new ArrayList<>();
        puntajeClasico = new PuntajeClasico();
        grupo1 = new Grupo("Modelo.Grupo n1", new ArrayList<>());
        respuestasJugadores = new ArrayList<>();

        //Carga de respuestas
        for (int i = 0 ; i < 3 ; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            respuestasIngresadasJ1.add(respuestaGroup);
            respuestasIngresadasJ2.add(respuestaGroup);
            respuestasPosibles.add(respuestaGroup);
            grupo1.aniadirRespuesta(respuestaGroup);
            respuestaGroup.cambiarGrupo(grupo1);
        }

        //Creo la pregunta
        pregGroupChoice = new PreguntaGroupChoice(puntajeClasico, respuestasPosibles, "Soy una pregunta");
        jugador.utilizarExclusividad(pregGroupChoice);


        //Calculo de puntajes individuales y final
        respuestasJugadores.add(respuestasIngresadasJ1);
        respuestasJugadores.add(respuestasIngresadasJ2);
        puntajes = pregGroupChoice.definirPuntajesDeJugadores(respuestasJugadores);

        //Assert
        assertEquals(0,puntajes.get(0));
        assertEquals(0,puntajes.get(1));
    }

    @Test
    public void test08LasPreguntasGroupChoiceDebenTenerEntre2y6Respuestas() {
        respuestasPosibles = new ArrayList<>();
        respuestaGroup = new RespuestaGroup("Soy correcta");
        respuestasPosibles.add(respuestaGroup);
        assertThrows(RuntimeException.class, () -> new PreguntaGroupChoice(new PuntajeClasico(),respuestasPosibles, "Soy un VOF"));
        for (int i=0; i < 6; i++){
            respuestaGroup = new RespuestaGroup("Soy correcta");
            respuestasPosibles.add(respuestaGroup);
        }
        assertThrows(RuntimeException.class, () -> new PreguntaGroupChoice(new PuntajeClasico(),respuestasPosibles, "Soy un VOF"));
    }
}
