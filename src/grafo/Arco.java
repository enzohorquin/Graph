package grafo;

/**
 * Created by Enzo on 26/2/2019.
 */
public class Arco {
    private int adyacente;
    private int costo;

    public Arco(int adyacente,int costo){
        this.adyacente = adyacente;
        this.costo = costo;
    }
    public int getAdyacente(){
        return this.adyacente;
    }
    public int getCosto(){
        return this.costo;
    }
}
