package Vista.Layouts;

import Controladores.UpdateEventHandler;
import Modelo.Jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class PuntajesActuales {

    public static StackPane getLayout(ArrayList<Jugador> jugadores, int rondaActual, ArrayList<Integer>puntajesSumados, int rondasTotales){
        StackPane layout = new StackPane();
        VBox verticalBox = new VBox();
        Label titulo = new Label("Puntajes para la ronda " + (rondaActual+1) + "/" + (rondasTotales));
        titulo.setFont(new Font("Arial", 30));
        titulo.setAlignment(Pos.CENTER);
        verticalBox.getChildren().add(titulo);
        for (int i=0; i<jugadores.size(); i++){
            verticalBox.getChildren().add(generarHBoxPuntaje(jugadores.get(i), puntajesSumados.get(i)));
        }
        verticalBox.setSpacing(100);
        Button botonContinuar = new Button("Continuar");
        botonContinuar.setCursor(Cursor.HAND);
        botonContinuar.setOnAction(new UpdateEventHandler());
        verticalBox.getChildren().add(botonContinuar);
        verticalBox.setAlignment(Pos.CENTER);
        layout.getChildren().add(verticalBox);
        layout.setStyle("-fx-background-color: \t#fdf9e1");
        return layout;
    }

    private static HBox generarHBoxPuntaje(Jugador jugador, int puntajeSumado){
        HBox horizontalBox = new HBox();
        Label nombreJugador = new Label(jugador.getNombre()+": ");
        nombreJugador.setFont(new Font("Arial", 20));
        Label puntajeJugador = new Label(jugador.getPuntos() + "  (" + puntajeSumado + ")");
        puntajeJugador.setFont(new Font("Arial", 20));
        horizontalBox.getChildren().add(nombreJugador);
        horizontalBox.getChildren().add(puntajeJugador);
        horizontalBox.setAlignment(Pos.CENTER);
        return horizontalBox;
    }
}
