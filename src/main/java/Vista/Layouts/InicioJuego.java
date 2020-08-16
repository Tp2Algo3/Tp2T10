package Vista.Layouts;

import Vista.Botones.BotonJugar;
import Vista.Labels.TituloInicio;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;


public class InicioJuego{

    public static StackPane getLayout(){
        ArrayList<TextField> nombresJugadores = new ArrayList<>();
        StackPane layout = new StackPane();
        VBox vertical_box = new VBox();
        Label label = new TituloInicio();

        HBox jugador1 = generar_hbox_jugador(1);
        HBox jugador2 = generar_hbox_jugador(2);

        nombresJugadores.add((TextField) jugador1.getChildren().get(1));
        nombresJugadores.add((TextField) jugador2.getChildren().get(1));
        Button botonEmpezar = new BotonJugar(nombresJugadores);

        HBox caja_boton = generar_hbox_boton(botonEmpezar);

        vertical_box.setAlignment(Pos.TOP_CENTER);
        vertical_box.getChildren().addAll(label,jugador1,jugador2,caja_boton);
        vertical_box.setSpacing(20);

        layout.setStyle("-fx-background-color: #ffe7b8");
        layout.getChildren().add(vertical_box);
        layout.setPrefSize(1024,768);

        return layout;
    }

    private static HBox generar_hbox_jugador(int num_jugador){
        String string_label = ("Jugador " + num_jugador + " : ");
        Label jug1_label = new Label (string_label);
        jug1_label.setFont(Font.font("Arial", FontWeight.BOLD,12));
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
