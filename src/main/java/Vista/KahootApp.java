package Vista;

import Modelo.Archivos.CargadorDePreguntas;
import Modelo.Archivos.LectorDeArchivosJSON;
import Modelo.Turnos.ManejadorDeTurnos;
import Modelo.Jugador.Jugador;
import Modelo.Preguntas.Pregunta;
import Modelo.Turnos.Temporizador;
import Vista.Layouts.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class KahootApp extends Application {

    private static Stage stage;
    private static ManejadorDeTurnos manejadorDeTurnos;
    private static boolean jugadorPresionoContinuar = false;

    public static void main (String[] args) {
        launch(args);
    }

    public static Stage getStage(){
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        KahootApp.stage = stage;
        stage.setTitle("Kahoot!");
        Scene escena_inicial = new Scene(InicioJuego.getLayout());
        stage.setScene(escena_inicial);
        stage.show();

    }

    public static void iniciarJuego(ArrayList<Jugador> jugadores){
        CargadorDePreguntas cargadorDePreguntas = new LectorDeArchivosJSON();
        ArrayList<Pregunta> preguntas = null;
        try {
            preguntas = cargadorDePreguntas.leerPreguntas();
        }catch(FileNotFoundException error){

        }
        manejadorDeTurnos = new ManejadorDeTurnos(jugadores, preguntas);
    }

    public static void update(){
        manejadorDeTurnos.siguienteFase();
    }

    public static void definirPuestos(ArrayList<Jugador> jugadores){
        Collections.sort(jugadores);
        stage.getScene().setRoot(LayoutFinJuego.getLayout(jugadores));
    }

    public static void mostrarPuntajes(ArrayList<Jugador> jugadores, int rondaActual, ArrayList<Integer> puntajesRonda, int rondasTotales){
        stage.getScene().setRoot(PuntajesActuales.getLayout(jugadores, rondaActual, puntajesRonda, rondasTotales));
    }

    public static void cambiarEscena(Pregunta preguntaActual, ArrayList<Jugador>jugadores, Jugador jugadorActual, Temporizador temporizador){
        if (jugadorPresionoContinuar) {
            jugadorPresionoContinuar = false;
            stage.getScene().setRoot
                    (PreguntaYRespuesta.getLayout(preguntaActual, jugadores, jugadorActual, temporizador));
        }
        else{
            stage.getScene().setRoot(IntermediarioTurnos.getLayout(jugadorActual, jugadores, preguntaActual, temporizador));
        }
    }

    public static void setJugadorPresionoContinuar(){
        jugadorPresionoContinuar=true;
    }
}
