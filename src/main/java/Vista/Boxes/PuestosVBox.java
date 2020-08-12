package Vista.Boxes;

import Modelo.Jugador.Jugador;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class PuestosVBox extends VBox {

    public PuestosVBox(ArrayList<Jugador> jugadores){
        for (int i=1; i<=jugadores.size(); i++){
            Label label = new Label((i)+"°: " + (jugadores.get(i-1).getNombre())+
                    " con: " + (jugadores.get(i-1).getPuntos()));
            label.setFont(new Font("Arial", 20));
            getChildren().add(label);
        }
        setAlignment(Pos.TOP_CENTER);
        setSpacing(20);
    }
}
