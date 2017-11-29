package sample;
public class MetodosArbol
{
   public String preOrden(Nodo raiz){
       if (raiz != null){
           return raiz.getDato()+"\t";
           preOrden(raiz.getNodoIzquierdo());
           preOrden(raiz.getNodoDerecho());
        }
       return "";
    }
    
   public String inOrden(Nodo raiz){
       if (raiz != null){
           inOrden(raiz.getNodoIzquierdo());
           return raiz.getDato()+"\t";
           inOrden(raiz.getNodoDerecho());
        }
       return "";
    }
    
   public String postOrden(Nodo raiz){
       if (raiz != null){
           postOrden(raiz.getNodoIzquierdo());
           postOrden(raiz.getNodoDerecho());
           return raiz.getDato()+"\t";
        }
       return "";
   }
}
