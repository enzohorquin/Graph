import java.util.* ;
public class HelloWorld{

    public static void main(String []args){
        /* Ejercicio 1.1
        String word = new String("holao");
        System.out.println(isUnique(word));
         */

        /*Ejercicio 1.2
        String palabra1 = "seee";
        String palabra2 = "esea";
        System.out.println(isPermutation(palabra1,palabra2));
        */
       /*Ejercicio 1.4
        String palabra = "meneme";

        System.out.println(isPalindrome(palabra));
        */
       /*
       String word1 = "pale";
       String word2 = "ple";
        System.out.println("CASO 1");
       System.out.println(isOneAway(word1,word2)); //salida TRUE

        String word3 = "pales";
        String word4 = "palesa";
        System.out.println("CASO 2");
        System.out.println(isOneAway(word3,word4)); //salida TRUE

        String word5 = "pale";
        String word6 = "bale";
        System.out.println("CASO 3");
        System.out.println(isOneAway(word5,word6)); //salida TRUE

        String word7 = "pale";
        String word8 = "bake";
        System.out.println("CASO 4");
        System.out.println(isOneAway(word7,word8)); //salida FALSE

        String word9 = "pale";
        String word10 = "pal3s";
        System.out.println("CASO 5");
        System.out.println(isOneAway(word9,word10)); //salida FALSE
        */
       /*
       String word = "aaaaaaaa";
        System.out.println(compression(word));
        */
       String word1 = "waterbottle";
       String word2 = "rbottlewate";
        System.out.println(isRotation(word1,word2));
    }

    //Ejercicio 1.1
    public static boolean isUnique (String word){

        if(word.length() > 256){
            return false;
        }
        boolean [] caracteres = new boolean[256];
        for(int i=0; i<word.length();i++){
            int valor = word.charAt(i);
            System.out.println(valor);
            if(caracteres[valor])
                return false;
            caracteres[valor]=true;
        }
        return true;
    }

    //Ejercicio 1.2
    public static boolean isPermutation(String s, String t){
        return sort(s).equals(sort(t));
    }
    public static String sort (String w){
        char [] array = w.toCharArray();
        java.util.Arrays.sort(array);
        return new String(array);
    }
    //Ejercicio 1.4
    public static boolean isPalindrome(String s) {


        char[] array_word = s.toCharArray();
        Hashtable<Character,Integer> hash = getHash(array_word);
        boolean isOne = false;
        for(Character c : hash.keySet()){
            Integer val = hash.get(c);
            if(val % 2 == 1){
                if(isOne){
                    return false;
                }
               isOne=true;
            }
        }
    return true;
    }


    public static Hashtable<Character,Integer> getHash(char [] array_word){
            Hashtable<Character,Integer> contador = new Hashtable<Character,Integer>();
            for (char c : array_word) {
                Integer cont;

                if (c != ' ') {
                    if (contador.containsKey(c)) {
                        cont = contador.get(c);
                        cont = cont + 1;
                    } else {
                        cont = new Integer(1);
                    }
                    contador.put(c, cont);
                }
            }
            return contador;
        }


     public static boolean isOneAway(String word1, String word2){

        if(word1.length() + 1 == word2.length()){ //Caso insercion
            return check(word2,word1);
        }else{
            if(word1.length() == 1 + word2.length() ){ //Caso eliminacion
                return check(word1,word2);
            }
            else if(word1.length() == word2.length())
                    return checkReplace(word1,word2);
                else
                    return false;
        }
     }

    public static boolean check(String word1, String word2){
        boolean encontrado = false;
        int i=0,j=0;
    /*
        while(i<word1.length()){
            if(word1.charAt(i)==word2.charAt(j)){
                i++;
                j++;
                if(j == word2.length())
                    return true;
            }else{
                if(!encontrado){
                    encontrado=true;
                    i++;
                    if(i == word1.length())
                        return false;
                }else{
                    return false;
                }
            }
        }
        return true;
        */

        while(i<word1.length() && j<word2.length()){
            if(word1.charAt(i)!=word2.charAt(j)) {
                if (i != j) {
                    return false;
                }
                j++;
            }
                else {
                    i++;
                    j++;

                }

            }

        return true;
    }


     public static boolean checkReplace(String word1, String word2){
        if(word1.equals(word2)){
            return true;
        }
        else
            {
            boolean encontrado=false;
            int i=0;

           /* while(i<word1.length()){
                if(word1.charAt(i) == word2.charAt(i)){
                    i++;
                }else{
                    if(!encontrado){
                        encontrado=true;
                        i++;
                    }else
                        return false;
                }
            } */
           while(i<word1.length()){
               if(word1.charAt(i)!=word2.charAt(i)){
                   if(encontrado)
                       return false;
                   else
                       encontrado=true;
               }
               i++;
           }
            return true;
        }
     }

     public static String compression(String word){
         StringBuilder output = new StringBuilder();
         int count = 0;
         char act = word.charAt(0);

         for(char c : word.toCharArray()){

             if(c == act)
                 count++;
             else{
                 output.append(act);
                 output.append(count);
                 count = 1;
                 act = c;
             }
         }
         output.append(act);
         output.append(count);

         if(output.length() < word.length())
             return output.toString();
         else
             return word;
     }


     public static boolean isRotation(String word1, String word2){
         StringBuilder y = new StringBuilder();
         StringBuilder x = new StringBuilder();
         int i = 0;
         while(i< word2.length() && word1.charAt(0)!= word2.charAt(i)){
             x.append(word2.charAt(i));
             i++;
         }
         while(i<word2.length()){
             y.append(word2.charAt(i));
             i++;
         }
         y.append(x);
         return word1.equals(y.toString());
     }
     public static boolean isSubString(String w1, String w2){
         return true; // FUNCION MAGICA QUE CHEQUEA SI ES SUBSTRING DE UNO
     }
     public static boolean isRotationBetterSolution(String word1, String word2){
         if(word1.length() == word2.length()){
             String word1word1 = word1 + word1;
             return isSubString(word1word1,word2);
         }
         else
             return false;
     }
    }


