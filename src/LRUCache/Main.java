package LRUCache;

/**
 * Created by Enzo on 21/3/2019.
 */
public class Main {
    public static void main(String []args){
        LRU cache = new LRU(4);

        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.printCache();

        System.out.println("CACHE LLENA, A VER CUAL REEMPLAZO");
        cache.put(5,5);;
        cache.printCache();

        cache.put()










    }
}
