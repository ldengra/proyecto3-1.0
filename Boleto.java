package com.luisdengra.practica3;


import java.util.Arrays;

public class Boleto {

    /**
     * Atributos
     */
    private int[] boleto;
    private final int MAX_NUMS = 6;
    private int reintegro;

    private int contador;
    private int min;
    private int max;

    /**
     * Constructor
     */
    public Boleto(int[] boleto) {
        this.boleto = boleto;
        this.reintegro = Lib.aleatorio(0,9);
    }


    public Boleto(final int MIN, final int MAX) {
        int numero = MIN;
        this.min = MIN;
        this.max = MAX;
        contador = 0;
        for(int i = MIN; i <= MAX; i++){
            contador++;
        }
        boleto = new int[contador];
        for(int i = 0; i < boleto.length; i++){
            boleto[i] = numero++;
        }
    }

    /**
     * metodos
     */
    @Override
    public String toString() {
        String aux = "";
        aux += String.format("Los numeros de tu boleto son: %-24s \n", getBoletoString());
        aux += String.format("Reintegro: %3s", reintegro);
        return aux;
    }

    public int[] getBoleto(){
        return boleto;
    }

    public int getReintegro(){
        return reintegro;
    }

    public String getBoletoString(){
        String aux = "";
        for(int i = 0; i < MAX_NUMS; i++){
            aux += String.format("%4s", getBoleto()[i]);
        }
        return aux;
    }

    /**
     * lo que hacemos es que generamos una posicion aleatoria, entonces sacamos el numero de esa posicion y lo guardamos,
     * despues ese numero lo cambiamos por el que esta al final del array y restamos 1 al contador del array para que cuando
     * vuelva a seleccionar una posicion, no seleccione la ultima que es donde esta el numero que ya hemos sacado
     * @return devolvemos los numeros que sacamos
     */
    public int generarBoletoAutomatico(){
        int pos = Lib.aleatorio(min, contador-1);
        int bola;
        bola = boleto[pos];
        boleto[pos] = boleto[contador-1];
        boleto[--contador] = bola;

        return bola;
    }
}
