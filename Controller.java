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
        //Se declcara cuales son las dos ramas de la raiz
        raiz.setNodoIzquierdo(nodo7);
        raiz.setNodoDerecho(nodo9);
        //Evento para el botón preOrden
        this.preBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Se agrega la etiqueta a el label
                labelLbl.setText("Recorrido en preOrden: \n");
                //Se invoca el método preOrden desde la clase arbol y agrega como parámetro lo que es la raiz y un label en el cual se
                //Mostrarán el resultado de la lectura en PreOrden
                arbol.preOrden(raiz,labelLbl);
            }
        });
        //Evento para el botón inOrden
        this.inBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en inOrden: \n");
                //Se invoca el método inOrden desde la clase arbol y agrega como parámetro lo que es la raiz y un label en el cual se
                //Mostrarán el resultado de la lectura en InOrden
                arbol.inOrden(raiz,labelLbl);
            }
        });
        //Evento para el botón postOrden
        this.postBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelLbl.setText("Recorrido en postOrden:\n");
                //Se invoca el método postOrden desde la clase arbol y agrega como parámetro lo que es la raiz y un label en el cual se
                //Mostrarán el resultado de la lectura en PostOrden
                arbol.postOrden(raiz,labelLbl);
            }
        });
        //Evento para el botón contar
        this.contarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //se invoca el método contar de la clase arbol y se asignan los parámetros de raiz y un label
                arbol.contar(raiz,labelLbl);
            }
        });
        //Evento del botón MaxMin
        this.maxminBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //método maxmin de la clase arbol y se le agrega como parámetro la raiz del árbol y un label
                arbol.maxmin(raiz,labelLbl);
            }
        });
        //Evento para el botón buscar
        this.buscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Se inicia un try-catch que sirve para saber si la prueba falla
                //y de esto sabremos porque falla despues se sale y no hace nada, despues
                //si se vuelve a intentar ya procede sin fallas
                    try {
                        //se invoca el método buscar de la clase arbol y se asigna como parámetro la raiz del árbol
                        //un label  y lo que contenga el cuadro de texto BuscarTxt convertido a enteros
                        arbol.buscar(raiz, labelLbl, Integer.parseInt(buscarTxt.getText()));
                    } catch (Exception e) {
                        //Si falló el try-catch retornará un mensaje
                        labelLbl.setText("Ingresa números");
                    }
                    //se limpia el cuadro de texto.
                    buscarTxt.clear();
            }
        });
    }

}
