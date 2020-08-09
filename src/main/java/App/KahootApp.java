package App;

import Jugador.Jugador;
import LayoutsUI.InicioJuego;
import LayoutsUI.PuntajesActuales;
import Preguntas.Pregunta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class KahootApp extends Application {

    private static Stage stage;
    private static ManejadorDeTurnos manejadorDeTurnos;
    private static ArrayList<Pregunta> preguntas;

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
        preguntas = LectorDeArchivos.leerPreguntas();
        manejadorDeTurnos = new ManejadorDeTurnos(jugadores, preguntas);
    }

    public static void update(){
        manejadorDeTurnos.update();
    }
}
