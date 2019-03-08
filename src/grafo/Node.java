package grafo;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 26/2/2019.
 */
public class Node {
    private Integer vertice;
    private List<Arco> lista_adytacentes;

    public Node (int v){
        this.vertice = new Integer(v);
        this.lista_adytacentes = new ArrayList<>();
    }
    public Integer getVertice(){
        return this.vertice;
    }
    public List<Arco> getAdyacentes(){
        return new ArrayList<Arco>(this.lista_adytacentes);
    }
    public boolean addAyacente (int v, int costo){
       Arco a = new Arco(v,costo);
        return lista_adytacentes.add(a);
    }
    @Override
    public String toString(){
        StringBuilder print  = new StringBuilder();
        print.append('\n');
        print.append("NODO: "+this.vertice);
        print.append('\n');
        print.append("Lista de Adyacentes: "+'\n');
        for(Arco A: lista_adytacentes){
            System.out.println(A.getAdyacente());
            print.append(A.getAdyacente());
            print.append('\n');
        }
        print.append("Fin Nodo"+'\n');
        return new String(print);
    }
}
