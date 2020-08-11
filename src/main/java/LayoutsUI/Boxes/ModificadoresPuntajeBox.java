package LayoutsUI.Boxes;

import Jugador.Jugador;
import LayoutsUI.Botones.BotonExclusividad;
import LayoutsUI.Botones.BotonMultX2;
import LayoutsUI.Botones.BotonMultX3;
import Potenciadores.Multiplicador;
import Preguntas.Pregunta;
import javafx.scene.control.Button;
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
            switch(multiplicador.getId()){
                case 2:
                    getChildren().add(new BotonMultX2(jugador));
                    break;
                case 3:
                    getChildren().add(new BotonMultX3(jugador));
                    break;
            }
        }
        setSpacing(20);
    }

}
