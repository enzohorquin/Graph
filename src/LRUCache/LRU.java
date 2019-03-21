package LRUCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Enzo on 21/3/2019.
 */
public class LRU {
    private int capacidad;
    private List<Item> lru;

    public LRU (int capacidad){
        this.capacidad = capacidad;
        lru = new ArrayList<>();
    }

    public void put(int key, int value){

        Item item = new Item(key,value);
        if(lru.size() < this.capacidad){
          for(int j = 0; j< lru.size();j++){
              Item ite = lru.get(j);
              ite.incrementarContador();
          }
          lru.add(item);

        }
        else{
            int index_max_cont = -1 ;
            int max_cont = -1;

            for(int i = 0; i<this.capacidad; i++){
                Item it = lru.get(i);
                if(it.getContador()>max_cont){
                    index_max_cont = i;
                    max_cont = it.getContador();
                }else{
                    it.incrementarContador();
                }
            }
            lru.remove(index_max_cont);
            lru.add(item);
        }


    }
    public int get(int key){
        for(Item i: lru){
            if(i.getKey().equals(key))
                return i.getValue();

        }
        return -1;

    }

    public void printCache(){
        for(Item I: lru){
            System.out.println(I.getKey() + " - " + I.getValue() + " contador: "+I.getContador());
        }
    }

}
