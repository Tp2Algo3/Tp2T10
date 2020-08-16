package Vista.Boxes;

import Modelo.Jugador.Jugador;
import Vista.Botones.BotonExclusividad;
import Vista.Botones.BotonMultX2;
import Vista.Botones.BotonMultX3;
import Modelo.Potenciadores.Multiplicador;
import Modelo.Preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class ModificadoresPuntajeBox extends HBox{
    public ModificadoresPuntajeBox (Jugador jugador, Pregunta pregunta){
        ArrayList<Multiplicador> multiplicadores = jugador.getMultiplicadores();
        int usosExclusividadRestantes = jugador.getUsosExclusividad();
        if (usosExclusividadRestantes > 0 && pregunta.getTipoPuntaje().admiteExclusividad()){
            getChildren().add(new BotonExclusividad(jugador, pregunta));
        }
        for (Multiplicador multiplicador: multiplicadores){
            switch(multiplicador.getOrdenMultiplicidad()){
                case 2:
                    getChildren().add(new BotonMultX2(jugador));
                    break;
                case 3:
                    getChildren().add(new BotonMultX3(jugador));
                    break;
            }
        }
        setSpacing(20);
        setAlignment(Pos.BOTTOM_CENTER);
    }

}
