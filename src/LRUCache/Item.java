package LRUCache;

import javafx.util.Pair;

/**
 * Created by Enzo on 21/3/2019.
 */
public class Item {
    private Pair<Integer,Integer> par;
    private int contador = 0;

    public Item( int key, int value){
        par = new Pair(key,value);
    }
    public void incrementarContador(){
        contador++;
    }
    public void resetearContador(){
        contador = 0;
    }
    public int getContador(){
        return this.contador;
    }
    public Integer getKey(){
        return par.getKey();
    }
    public Integer getValue(){
        return par.getValue();
    }

}
