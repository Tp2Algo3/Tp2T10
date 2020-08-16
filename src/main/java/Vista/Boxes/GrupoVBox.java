package Vista.Boxes;

import java.util.ArrayList;

import Controladores.DragDrop.DragDroppedEventHandler;
import Controladores.DragDrop.DragOverEventHandler;
import Modelo.Grupo.Grupo;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GrupoVBox extends VBox {
    Grupo grupito;
    String nombreGrupo;
    ArrayList<String> coloresPosibles;
    
    public GrupoVBox(Grupo grupito){
        this.grupito = grupito;
        this.nombreGrupo = grupito.getNombre();
        
        Label grupoTexto = new Label(nombreGrupo);
        grupoTexto.setFont(Font.font("Double", FontWeight.BOLD, 12));
        getChildren().add(grupoTexto);

        setMinHeight(220);
        setMinWidth(100);
        setStyle("-fx-background-color: #fdcf58; -fx-text-fill: #000000");
        setAlignment(Pos.TOP_CENTER);
        setOnDragOver(new DragOverEventHandler(this));
        setOnDragDropped(new DragDroppedEventHandler(this));
        setBorder(new Border(new BorderStroke(Color.GRAY, 
                BorderStrokeStyle.DASHED, new CornerRadii(5), BorderWidths.DEFAULT)));
        
    }

    public Grupo getGrupo(){
        return this.grupito;
    }
    
}