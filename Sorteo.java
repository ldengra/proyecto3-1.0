package com.luisdengra.practica3;

import java.util.Arrays;

public class Sorteo {
    /**
     * Este metodo lo que hace es girar el bombo y sacar 8 numeros aleatorios, los 6 principales, el complementario y
     * el reintegro, se guarda en un solo array y la posicion 6 y 7 del array la reservamos para el R y el Comp.
     * @return devolvemos el array de enteros con los numeros aleatorios.
     */
    public int[] realizarSorteo(){
        Bombo bombo = new Bombo(1,49);
        Bombo bomboReintegro = new Bombo(0,9);
        int[] bolasGanadoras = new int[8];


        for(int i = 0; i < bolasGanadoras.length; i++){
            bolasGanadoras[i] = bombo.sacarBola();
        }
        bolasGanadoras[6] = bombo.sacarBola();
        bolasGanadoras[7] = bomboReintegro.sacarBola();



        System.out.printf("Los numeros del sorteo son:   ");

        for(int i = 0; i< 6; i++) {
            System.out.printf(" %-4s", bolasGanadoras[i]);
        }
        System.out.println();
        System.out.println("Reintegro:   " + bolasGanadoras[7]);
        System.out.println("Complementario:   " + bolasGanadoras[6]);

        return bolasGanadoras;
    }

    /**
     * Este metodo se genera una partida unica donde se le pasa el boleto y se hace la comprobacion con los numeros de
     * los bombos
     * @param b1 es el boleto que le hemos pasado
     */
    public void partidaUnica(Boleto b1){
        int nCoincidencias = 0;
        boolean complementario = false;
        int[] resultado = new int[6];
        boolean reintegro = false;

        resultado = realizarSorteo();

        nCoincidencias = comprobarApuesta(b1,resultado);
        complementario = comprobarComplementario(b1, resultado);
        reintegro = comprobarReintegro(b1, resultado);

        premios(nCoincidencias, reintegro, complementario);

    }

    /**
     * este metodo es para realizar juegos hasta obtener un premio minimo, ya sea 3 numeros o el reintegro
     * @param b1 boleto que le pasamos
     */
    public void hastaObtenerPremio(Boleto b1){
        int nCoincidencias = 0;
        int intentos = 0;
        boolean complementario = false;
        int[] resultado = new int[6];
        boolean reintegro = false;

        { //hacer bucle while que nCoincidencias sea >= 3, || (nCoincidencias>=5&&complemento==true) || (reintegro ==true)

            resultado = realizarSorteo();

            nCoincidencias = comprobarApuesta(b1,resultado);
            complementario = comprobarComplementario(b1, resultado);
            reintegro = comprobarReintegro(b1, resultado);

            intentos++;
        }
        premios(nCoincidencias, reintegro, complementario);
        System.out.println("Han hecho falta " +intentos+ " intentos.");
    }

    public void hastaObtenerPremioSR(Boleto b1){
        //crear bucle nCoincidencias sea >= 3, || (nCoincidencias>=5&&complemento==true)
    }

    public void cicloDiezMilSorteos(Boleto b1){
        int nCoincidencias = 0;
        boolean complementario = false;
        int[] resultado = new int[6];
        boolean reintegro = false;
        int intentos = 0;

        for(int i = 0; i < 10000; i++){


            resultado = realizarSorteo();

            nCoincidencias = comprobarApuesta(b1,resultado);
            complementario = comprobarComplementario(b1, resultado);
            reintegro = comprobarReintegro(b1, resultado);

            //if()

            intentos++;
        }
        premios(nCoincidencias, reintegro, complementario);
        System.out.println("Han hecho falta " +intentos+ " intentos.");
    }

    public void hastaCE(Boleto b1){
        //hasta obtener el premio de categoria especial
    }

    /**
     * Con este metodo hacemos la comprobacion con un for anidado entre los numeros de nuestro boleto con los generados
     * por el bombo
     * @param b1 nuestro boleto
     * @param bolasGanadoras array que hemos creado con el bombo
     * @return
     */
    public int comprobarApuesta(Boleto b1, int[] bolasGanadoras){
        final int POSPRIN = 6; //las primeras 6 posiciones del array principal son el sorteo principal
        int nCoincidencias = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < POSPRIN; j++){
                if(b1.getBoleto()[i]==bolasGanadoras[j]){
                    nCoincidencias++;
                }
            }
        }
        return nCoincidencias;
    }

    /**
     * Este metodo es para comprobar el complementario, ya que le hemos dado una posicion especial al array del bombo,
     * hacemos la comprobacion de nuestro boleto con el numero complementario del bombo
     * @param b1 nuestro boleto
     * @param bolasGanadoras el array creado con los numeros del bombo
     * @return si el complementario esta en nuestro boleto, devolvemos true
     */
    public boolean comprobarComplementario(Boleto b1, int[] bolasGanadoras){
        for(int i = 0; i < 6; i++){
            if(b1.getBoleto()[i] == bolasGanadoras[6]){
                return true;
            }
        }
        return false;
    }

    /**
     * Este metodo sirve para comprobar si nuestro reintegro tiene premio, lo comparamos con la posicion especial que
     * le hemos dado al reintegro en el array creado por el bombo
     * @param b1 nuestro boleto
     * @param bolasGanadoras array creado con los numeros del bombo
     * @return devolvemos true si nuestro reintegro coincide con el del bombo
     */
    public boolean comprobarReintegro(Boleto b1, int[] bolasGanadoras){
        for(int i = 0; i < 6; i++){
            if(b1.getReintegro() == bolasGanadoras[7]){
                return true;
            }
        }
        return false;
    }



    /**
     * Este metodo sirve para saber que premio hemos ganado, dependiendo de los valores de los parametros pasados, nos
     * dara un premio u otro.
     * @param nCoincidencias numero de aciertos que tenemos en nuestro boleto
     * @param reintegro el reintegro de nuestro boleto
     * @param complementario el complementario de nuestro boleto
     */
    public void premios(int nCoincidencias, boolean reintegro, boolean complementario) {


        switch (nCoincidencias) {
            case 0:

            case 1:
                if(reintegro){
                    System.out.println("Tu boleto ha sido premiado con el reintegro!!!");
                }
            case 2:
                System.out.println("Tu boleto no ha sido premiado.");
                break;
            case 3:
                System.out.println("Tu boleto ha sido premiado con el 5º premio!!!!");
                break;
            case 4:
                System.out.println("Tu boleto ha sido premiado con el 4º premio!!!!");
                break;
            case 5:
                if(complementario){
                    System.out.println("Tu boleto ha sido premiado con el 2º premio!!!!");
                }else {
                    System.out.println("Tu boleto ha sido premiado con el 3º premio!!!!");
                }
                break;
            case 6:
                if(reintegro){
                    System.out.println("Tu boleto ha sido premiado con el premio ESPECIAL!!!!");
                }else{
                    System.out.println("Tu boleto ha sido premiado con el 1º premio!!!!");
                }
        }
    }


}
