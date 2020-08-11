package App;

import Jugador.Jugador;
import LayoutsUI.InicioJuego;
import LayoutsUI.LayoutFinJuego;
import Preguntas.Pregunta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class KahootApp extends Application {

    private static Stage stage;
    private static ManejadorDeTurnos manejadorDeTurnos;

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
}
