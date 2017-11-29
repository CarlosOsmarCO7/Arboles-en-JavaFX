package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    MetodosArbol arbol = new MetodosArbol();

    @FXML
    Button preBtn, postBtn, inBtn;
    @FXML
    Label labelLbl;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Nodo raiz = new Nodo(8);
        //Nodos para el Nodo7
        Nodo nodo7 = new Nodo(7);
        nodo7.setNodoIzquierdo(new Nodo(3));
        Nodo nodo5 = new Nodo(5);
        nodo7.setNodoDerecho(nodo5);
        Nodo nodo1 = new Nodo(1);
        //Nodos para el Nodo5
        nodo5.setNodoDerecho(nodo1);
        nodo5.setNodoIzquierdo(new Nodo(6));
        nodo1.setNodoIzquierdo(new Nodo(10));
        nodo1.setNodoDerecho(new Nodo(11));

        Nodo nodo9 = new Nodo(9);

        Nodo nodo2 = new Nodo(2);
        nodo9.setNodoDerecho(nodo2);
        nodo9.setNodoIzquierdo(new Nodo(4));
        //Valores para Nodo2
        nodo2.setNodoIzquierdo(new Nodo(12));
        nodo2.setNodoDerecho(new Nodo(22));

        raiz.setNodoIzquierdo(nodo7);
        raiz.setNodoDerecho(nodo9);
        this.preBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en preOrden"+arbol.preOrden(raiz));
            }
        });
        this.inBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en inOrden"+arbol.inOrden(raiz));
            }
        });
        this.postBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en postOrden"+arbol.postOrden(raiz));
            }
        });
    }

}
