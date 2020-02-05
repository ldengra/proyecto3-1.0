package com.luisdengra.practica3;

public class Bombo {

    /**
     * Atributos
     */
    private int[] bolas; //este bombo tiene que generar 6 numeros mas 1 complementario, array de 6 huecos
    private int contador;
    private int min;
    private int max;

    /**
     * constructor
     */

    public Bombo(final int MIN, final int MAX) {
        int bola = MIN;
        this.min = MIN;
        this.max = MAX;
        contador = 0;
        for(int i = MIN; i <= MAX; i++){
            contador++;
        }
        bolas = new int[contador];
        for(int i = 0; i < bolas.length; i++){
            bolas[i] = bola++;
        }
    }

    public void rellenar(){
        contador = bolas.length -1;
    }

    /**
     * lo que hacemos es que generamos una posicion aleatoria, entonces sacamos el numero de esa posicion y lo guardamos,
     * despues ese numero lo cambiamos por el que esta al final del array y restamos 1 al contador del array para que cuando
     * vuelva a seleccionar una posicion, no seleccione la ultima que es donde esta el numero que ya hemos sacado
     * @return devolvemos los numeros que sacamos
     */
    public int sacarBola(){
        int pos = Lib.aleatorio(min, contador-1);
        int bola;
        bola = bolas[pos];
        bolas[pos] = bolas[contador-1];
        bolas[--contador] = bola;

        return bola;
    }



}

