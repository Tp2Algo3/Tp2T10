package LayoutsUI.Boxes;

import Grupo.Grupo;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class GrupoVBox extends VBox {
    Grupo grupito;
    String nombreGrupo;
    
    public GrupoVBox(Grupo grupito){
        this.grupito = grupito;
        this.nombreGrupo = grupito.getNombre();
        
        Label grupoTexto = new Label(nombreGrupo);
        getChildren().add(grupoTexto);
        
    }

    public Grupo getGrupo(){
        return this.grupito;
    }
    
}