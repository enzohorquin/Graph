package LRUCache;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by Enzo on 21/3/2019.
 */
class DirectMap {
    private int capacity;
    private ArrayList<Pair<Integer, Integer>> lru;

    public DirectMap(int capacity) {
        this.capacity = capacity;
        lru = new ArrayList<> ();
        inicializarCacheVacia();
    }

    public int get(int key) {
        int index = this.getIndex(key);

        Pair<Integer,Integer> P = lru.get(index);

        if(P.getKey().equals(key))
            return P.getValue();
        else
            return -1;
    }

    public void put(int key, int value) {

        int index = this.getIndex(key);
        Pair<Integer,Integer> par = new Pair<>(key,value);
        lru.remove(index);
        lru.add(index,par);

    }
    public int getIndex(int key){
        return key % this.capacity;
    }
    private void inicializarCacheVacia(){
        for(int i=0; i<this.capacity; i++){
            lru.add(new Pair<> (-1,-1));
        }
    }
    public void printCache(){
        for(Pair P: lru){
            System.out.println(P.getKey() + " " + P.getValue());
        }
    }


}

