package sample;

import javafx.scene.control.Label;

public class MetodosArbol
{
   public void preOrden(Nodo raiz, Label label){
       if (raiz != null){
           label.setText(label.getText()+raiz.getDato()+"\t");
           preOrden(raiz.getNodoIzquierdo(),label);
           preOrden(raiz.getNodoDerecho(),label);
        }
    }
    
   public void inOrden(Nodo raiz, Label label){
       if (raiz != null){
           inOrden(raiz.getNodoIzquierdo(),label);
           label.setText(label.getText()+raiz.getDato()+"\t");
           inOrden(raiz.getNodoDerecho(),label);
        }
    }

    public void postOrden(Nodo raiz, Label label){
        if (raiz != null){
            postOrden(raiz.getNodoIzquierdo(),label);
            postOrden(raiz.getNodoDerecho(),label);
            label.setText(label.getText()+raiz.getDato()+"\t");
        }
    }
    int i=1;
    public void contar(Nodo raiz, Label label){
        if (raiz != null){
            contar(raiz.getNodoIzquierdo(),label);
            contar(raiz.getNodoDerecho(),label);
            label.setText(String.valueOf("Total de elementos en el árbol son: "+i++));
        }
    }
    int menor = 100000;
    int mayor = 0;
    public void maxmin(Nodo raiz, Label label){
        if (raiz != null){
            maxmin(raiz.getNodoIzquierdo(),label);
            maxmin(raiz.getNodoDerecho(),label);
            if (raiz.getDato()>=mayor){
                mayor = raiz.getDato();
            }
            if (raiz.getDato()<=menor){
                menor = raiz.getDato();
            }
            label.setText("Número Mayor: "+mayor+"\nNúmero Menor: "+menor);
        }
    }
    boolean encontrado = false;
    public void buscar(Nodo raiz, Label label,int numero){
        encontrado = false;
        if (raiz != null){
            buscar(raiz.getNodoIzquierdo(),label,numero);
            buscar(raiz.getNodoDerecho(),label,numero);
            if (raiz.getDato()==numero) {
                label.setText(numero + " Fue encontrado");
                encontrado = true;
            }else
                if (raiz.getDato()!=numero){
                    label.setText(numero + " No encontrado");
                }
        }

    }
}
