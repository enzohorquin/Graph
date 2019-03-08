package grafo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Enzo on 26/2/2019.
 */
public class Grafo {
    private List<Node> grafo;
    private int cantidad_vertices = 0;

    public Grafo (){
        this.grafo = new ArrayList<>();
    }
    public boolean  addVertice(Node v){
        if(!this.existeVertice(v.getVertice())) {
            grafo.add(v);
            cantidad_vertices++;
            return true;
        }
        else
            return false;

    }
    public boolean isEmpty(){
        return cantidad_vertices == 0;
    }
    public int getCantidadVertices(){
        return this.cantidad_vertices;
    }

    public boolean existeVertice(int v){
        for(Node N : grafo){
            if(N.getVertice() == v)
                return true;
        }
        return false;
    }

    public boolean existeArco(int origen, int destino){
        for (Node N: grafo){
            if(N.getVertice().equals(origen)){
                for(Arco A: N.getAdyacentes()){
                    if (A.getAdyacente() == destino)
                        return true;
                }
            }
        }
        return false;
    }

    public List<Integer> getVertices(){
        List<Integer> vertices = new ArrayList<>();
        for(Node N:grafo){
            vertices.add(N.getVertice());
        }
        return vertices;
    }
    public List<Node> getNodos(){
        return new ArrayList<>(grafo);
    }
    public List<Arco> devolverAdyacentes(int v){
        for(Node N: grafo){
            if(N.getVertice().equals(v))
                return N.getAdyacentes();
        }
        return null;
    }
    public void eliminarNodo(int v){
        int i = 0;
        for(Node N:grafo){
            if(N.getVertice().equals(v))
                grafo.remove(i);
            i++;
        }
    }

    public void vaciarNodo(){
        grafo = null;
        cantidad_vertices = 0;
    }
    @Override
    public String toString(){
        StringBuilder print = new StringBuilder();

        for(Node N:grafo){
            print.append(N.toString());
        }
        return new String(print);
    }

}
