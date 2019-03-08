package grafo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Enzo on 26/2/2019.
 */
public class Main {
    public static final int BLANCO = 0;
    public static final int GRIS = 1;
    public static final int NEGRO = 2;
    public static void main(String []args){


        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        Grafo g = new Grafo();

        n0.addAyacente(2,-1);
        n0.addAyacente(4,-1);

        n1.addAyacente(0,-1);

        n2.addAyacente(1,-1);
        n2.addAyacente(3,-1);

        n3.addAyacente(4,-1);

        g.addVertice(n0);
        g.addVertice(n1);
        g.addVertice(n2);
        g.addVertice(n3);
        g.addVertice(n4);


        int N = g.getCantidadVertices();
        boolean [] marca = new boolean[N];
        int [] padre = new int[N];
        int [] descubierto = new int[N];
        int [] finalizado = new int[N];
        int tiempo = 0;
        int [] visitado = new int [N];

        System.out.println("RECORRIDO DFS");
        for(int i = 0; i<N;i++){
            if(marca[i] == false)
                DFS(g,i,marca,padre,descubierto,finalizado,tiempo);
        }
        System.out.println("RECORRIDO BFS");
        for(int i=0;i<N;i++){
            if(visitado[i]==BLANCO)
                BFS(g,i,visitado);
        }


    }

    public static void DFS (Grafo g, int v, boolean [] marca, int [] padre, int [] descubierto ,int finalizado[],int tiempo){

        tiempo++;
        descubierto[v] = tiempo;
        marca[v] = true;
        System.out.println("NODO: "+v);

        List<Arco> adyacentes = g.devolverAdyacentes(v);

        for(Arco A: adyacentes){
            int x = A.getAdyacente();
            if(marca[x] == false){
                padre[x] = v;
                DFS(g,x,marca,padre,descubierto,finalizado,tiempo);
            }
        }
        tiempo++;
        finalizado[v]= tiempo;

    }
    public static void BFS(Grafo g, int v, int [] visitado){
        Queue<Integer> cola = new LinkedList<>();
        visitado[v]=GRIS;
        cola.add(v);

        while(!cola.isEmpty()) {
            int vertice = cola.remove();
            System.out.println("NODO: "+vertice);
            List<Arco> adyacentes = g.devolverAdyacentes(vertice);
            for(Arco A:adyacentes){
                int x = A.getAdyacente();
                if(visitado[x]==BLANCO){
                    visitado[x] = GRIS;
                    cola.add(x);
                }
            }
            visitado[vertice]=NEGRO;
        }



    }
}
