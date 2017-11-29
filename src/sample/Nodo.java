package sample;
public class Nodo
{
    private int dato;
    private Nodo izq;
    private Nodo der;
    
    public Nodo(int dato){
        this.dato = dato;
    }
    public Nodo getNodoIzquierdo(){
        return izq;
    }
    public Nodo getNodoDerecho(){
        return der;
    }
    public void setNodoDerecho(Nodo nodo){
        der = nodo;
    }
    public void setNodoIzquierdo(Nodo nodo){
        izq = nodo;
    }
    public int getDato(){
        return dato;
    }
}
