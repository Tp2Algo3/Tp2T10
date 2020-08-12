package Controladores;

import Vista.KahootApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UpdateEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent){
        KahootApp.update();
    }
}
