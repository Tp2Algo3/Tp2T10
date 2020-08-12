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

    public static StackPane getLayout(ArrayList<Jugador> jugadores, int rondaActual){
        StackPane layout = new StackPane();
        VBox verticalBox = new VBox();
        Label titulo = new Label("Puntajes para la ronda " + rondaActual);
        titulo.setFont(new Font("Arial", 30));
        titulo.setAlignment(Pos.CENTER);
        verticalBox.getChildren().add(titulo);
        for (Jugador jugador: jugadores){
            verticalBox.getChildren().add(generarHBoxPuntaje(jugador));
        }
        verticalBox.setSpacing(100);
        Button botonContinuar = new Button("Continuar");
        botonContinuar.setCursor(Cursor.HAND);
        botonContinuar.setOnAction(new UpdateEventHandler());
        verticalBox.getChildren().add(botonContinuar);
        verticalBox.setAlignment(Pos.CENTER);
        layout.getChildren().add(verticalBox);
        return layout;
    }

    private static HBox generarHBoxPuntaje(Jugador jugador){
        HBox horizontalBox = new HBox();
        Label nombreJugador = new Label(jugador.getNombre()+": ");
        nombreJugador.setFont(new Font("Arial", 20));
        Label puntajeJugador = new Label(Integer.toString(jugador.getPuntos()));
        puntajeJugador.setFont(new Font("Arial", 20));
        horizontalBox.getChildren().add(nombreJugador);
        horizontalBox.getChildren().add(puntajeJugador);
        horizontalBox.setAlignment(Pos.CENTER);
        return horizontalBox;
    }
}
