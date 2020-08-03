package UI;

import Controladores.BotonJugarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;


public class InicioJuego{

    public static StackPane getLayout(){
        StackPane layout = new StackPane();
        VBox vertical_box = new VBox();
        Label label = new Label("Bienvenidos al Kahoot! del grupo T10.");
        label.setFont(new Font("Arial", 30));
        label.setPadding(new Insets(100,0,100,0));

        HBox jugador1 = generar_hbox_jugador(1);
        HBox jugador2 = generar_hbox_jugador(2);

        Button boton_empezar = new Button("Jugar");
        TextField nombre_jugador1 = (TextField) jugador1.getChildren().get(1);
        TextField nombre_jugador2 = (TextField) jugador2.getChildren().get(1);
        boton_empezar.setOnAction(new BotonJugarEventHandler(boton_empezar, nombre_jugador1, nombre_jugador2));
        boton_empezar.setPrefSize(100,50);
        HBox caja_boton = generar_hbox_boton(boton_empezar);

        vertical_box.setAlignment(Pos.TOP_CENTER);
        vertical_box.getChildren().add(label);
        vertical_box.getChildren().add(jugador1);
        vertical_box.getChildren().add(jugador2);
        vertical_box.getChildren().add(caja_boton);
        layout.getChildren().add(vertical_box);
        layout.setPrefSize(800,600);
        return layout;
    }

    private static HBox generar_hbox_jugador(int num_jugador){
        String string_label = ("Jugador " + num_jugador + " : ");
        Label jug1_label = new Label (string_label);
        String textFieldString = ("Nombre Jugador "+ num_jugador);
        TextField jugador1_nombre = new TextField(textFieldString);
        HBox jugador1 = new HBox();
        jugador1.getChildren().add(jug1_label);
        jugador1.getChildren().add(jugador1_nombre);
        jugador1.setAlignment(Pos.CENTER);
        return jugador1;
    }

    private static HBox generar_hbox_boton(Button boton){
        HBox caja_boton = new HBox();
        caja_boton.getChildren().add(boton);
        caja_boton.setAlignment(Pos.CENTER);
        caja_boton.setPadding(new Insets(100,0,0,0));
        return caja_boton;
    }

}
