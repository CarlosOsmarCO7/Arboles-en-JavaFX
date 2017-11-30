package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    MetodosArbol arbol = new MetodosArbol();

    @FXML
    Button preBtn, postBtn, inBtn, maxminBtn, contarBtn, buscarBtn;
    @FXML
    Label labelLbl;
    @FXML
    TextField buscarTxt;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Se declara e inicializa el nodo raiz
        Nodo raiz = new Nodo(8);
        //Nodos para el Nodo7
        Nodo nodo7 = new Nodo(7);
        //Nodo izquierdo de 7
        nodo7.setNodoIzquierdo(new Nodo(3));
        //Se declara el nodo 5 que será el nodo derecho del nodo 7
        Nodo nodo5 = new Nodo(5);
        nodo7.setNodoDerecho(nodo5);
        //Nodo 1 que será nodo derecho del nodo 5
        Nodo nodo1 = new Nodo(1);
        //Nodos para el Nodo5
        nodo5.setNodoDerecho(nodo1);
        //Nuevos nodo 6 que es nodo derecho de 5
        nodo5.setNodoIzquierdo(new Nodo(6));
        //Nuevos nodos que son declarados de izquierda o derecha del nodo1
        nodo1.setNodoIzquierdo(new Nodo(10));
        nodo1.setNodoDerecho(new Nodo(11));
        //Nodo 9 que será declarado como nodo derecho de raiz
        Nodo nodo9 = new Nodo(9);
        //Nodo 2 que será nodo derecho
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
                labelLbl.setText("Recorrido en preOrden: \n");
                arbol.preOrden(raiz,labelLbl);
            }
        });
        this.inBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en inOrden: \n");
                arbol.inOrden(raiz,labelLbl);
            }
        });
        this.postBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en postOrden:\n");
                arbol.postOrden(raiz,labelLbl);
            }
        });
        this.contarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                arbol.contar(raiz,labelLbl);
            }
        });
        this.maxminBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                arbol.maxmin(raiz,labelLbl);
            }
        });
        this.buscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    try {
                        arbol.buscar(raiz, labelLbl, Integer.parseInt(buscarTxt.getText()));
                    } catch (Exception e) {
                        labelLbl.setText("Ingresa números");
                    }
                    buscarTxt.clear();
            }
        });
    }

}
