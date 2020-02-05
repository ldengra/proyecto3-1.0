package com.luisdengra.practica3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    private static Scanner input;
    Sorteo sorteo = new Sorteo();

    /**
     * Metodo principal, desde aqui arranca el primer menu y desde el switch vamos a la opcion seleccionada
     */
    public Principal() {


        input = new Scanner(System.in);
        int opcion;

        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    juegoUnico();
                    break;
                case 2:
                    hastaObtenerPremio();
                    break;
                case 3:
                    hastaObtenerPremioSR();
                    break;
                case 4:
                    cicloDiezMilSorteos();
                    break;
                case 5:
                    hastaCE();

                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while (opcion != 0);

        input.close();

    }

    /**
     * Esto es el menu que se imprime al iniciar el programa.
     * @return devuelve la opcion que usaremos en el switch del metodo principal
     */
    public int menuPrincipal() {
        int opcion = -1;
        do {
            Lib.limpiarPantalla();
            System.out.println("*********************");
            System.out.println("**    PRIMITIVA    **");
            System.out.println("*********************");
            System.out.println("1. Juego unico.");
            System.out.println("2. Jugar hasta obtener premio.");
            System.out.println("3. Jugar hasta obtener premio (Sin reintegro).");
            System.out.println("4. Ciclo de 10000 sorteos.");
            System.out.println("5. Jugar hsata ganar la categoria especial.");
            System.out.println("---------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-5]");
                Lib.pausa();
            }

        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    /**
     * Metodo de juego unico, este metodo solo hara una partida, con el switch llamaremos a los metodos con el boleto
     * seleccionado
     */
    public void juegoUnico(){
        int opcion = -1;
        do {
            System.out.println("***JUEGO UNICO***");
            System.out.println("1. Generar boleto manualmente.");
            System.out.println("2. Generar boleto automaticamente");
            System.out.println("----------------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);

        switch (opcion){
            case 1:
                sorteo.partidaUnica(rellenarManual());
                break;
            case 2:
                sorteo.partidaUnica(rellenarAutomatico());
                break;

            case 0:
                System.out.println("Hasta pronto!");
                break;
        }
    }

    /**
     * Este metodo jugara hasta obtener cualquier premio, reintegro incluido, con el switch llamaremos al metodo con el
     * boleto elegido
     */
    public void hastaObtenerPremio(){
        int opcion = -1;
        do {
            System.out.println("***JUEGO HASTA OBTENER PREMIO***");
            System.out.println("1. Generar boleto manualmente.");
            System.out.println("2. Generar boleto automaticamente");
            System.out.println("----------------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);

        switch (opcion){
            case 1:
                sorteo.hastaObtenerPremio(rellenarManual());
                break;
            case 2:
                sorteo.hastaObtenerPremio(rellenarAutomatico());
                break;

            case 0:
                System.out.println("Hasta pronto!");
                break;
        }
    }

    /**
     * Jugaremos hasta que obtengamos un premio sin incluir el reintegro
     */
    public void hastaObtenerPremioSR(){
        int opcion = -1;
        do {
            System.out.println("***JUEGO HASTA OBTENER PREMIO (SIN REINTEGRO)***");
            System.out.println("1. Generar boleto manualmente.");
            System.out.println("2. Generar boleto automaticamente");
            System.out.println("----------------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);

        switch (opcion){
            case 1:
                sorteo.hastaObtenerPremioSR(rellenarManual());
                break;
            case 2:
                sorteo.hastaObtenerPremioSR(rellenarAutomatico());
                break;

            case 0:
                System.out.println("Hasta pronto!");
                break;
        }
    }

    /**
     * metodo para jugar 10.000 sorteos, una vez realizados, nos dara las veces que ha sacado cada premio
     */
    public void cicloDiezMilSorteos(){
        int opcion = -1;
        do {
            System.out.println("***CICLO 10.000 sorteos***");
            System.out.println("1. Generar boleto manualmente.");
            System.out.println("2. Generar boleto automaticamente");
            System.out.println("----------------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);

        switch (opcion){
            case 1:
                sorteo.cicloDiezMilSorteos(rellenarManual());
                break;
            case 2:
                sorteo.cicloDiezMilSorteos(rellenarAutomatico());
                break;

            case 0:
                System.out.println("Hasta pronto!");
                break;
        }
    }

    public void hastaCE(){
        int opcion = -1;
        do {
            System.out.println("***HASTA CATEGORIA ESPECIAL***");
            System.out.println("1. Generar boleto manualmente.");
            System.out.println("2. Generar boleto automaticamente");
            System.out.println("----------------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción");
            opcion = Integer.parseInt(input.nextLine());
            if (opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);

        switch (opcion){
            case 1:
                sorteo.hastaCE(rellenarManual());
                break;
            case 2:
                sorteo.hastaCE(rellenarAutomatico());
                break;

            case 0:
                System.out.println("Hasta pronto!");
                break;
        }
    }


    /**
     * Este metodo es para rellenar de forma manual el boleto. Se que se puede hacer con un for y ahorrar codigo, pero
     * no encontraba la manera de hacerlo y que no se cerrase el programa a la hora de validar el numero introducido.
     * Validamos que el numero se encuentre entre el 1 y el 49 y que no este ya repetido
     * @return devuelve un boleto relleno con nuestros numeros.
     */
    public Boleto rellenarManual(){

        int[] boletoAux = new int[6];
        int numero;
        boolean validado = false;

        do {
            System.out.println("Inserta el primer numero:");
            numero = input.nextInt();
            input.nextLine();
            if(numero>=0 && numero<=49) {
                boletoAux[0] = numero;
                validado=true;
            }else {
                System.out.println("El numero introducido no esta comprendido entre el 0 y el 49, inserte un numero valido.");
            }
        }while (!validado);

        do {
            validado = false;
            System.out.println("Inserta el segundo numero:");
            numero = input.nextInt();
            input.nextLine();

            if(busquedaLineal(boletoAux, numero) || !validarNumero(numero)){
                System.out.println("el numero que has introducido ya esta en el boleto o no esta comprendido entre el 0 y el 49. Inserta otro diferente.");
            }else{
                boletoAux[1] = numero;
                validado = true;
            }
        }while (!validado);
        do {
            validado = false;
            System.out.println("Inserta el tercer numero:");
            numero = input.nextInt();
            input.nextLine();

            if(busquedaLineal(boletoAux, numero) || !validarNumero(numero)){
                System.out.println("el numero que has introducido ya esta en el boleto o no esta comprendido entre el 0 y el 49. Inserta otro diferente.");
            }else{
                boletoAux[2] = numero;
                validado = true;
            }
        }while (!validado);
        do {
            validado = false;
            System.out.println("Inserta el cuarto numero:");
            numero = input.nextInt();
            input.nextLine();

            if(busquedaLineal(boletoAux, numero) || !validarNumero(numero)){
                System.out.println("el numero que has introducido ya esta en el boleto o no esta comprendido entre el 0 y el 49. Inserta otro diferente.");
            }else{
                boletoAux[3] = numero;
                validado = true;
            }
        }while (!validado);
        do {
            validado = false;
            System.out.println("Inserta el quinto numero:");
            numero = input.nextInt();
            input.nextLine();

            if(busquedaLineal(boletoAux, numero) || !validarNumero(numero)){
                System.out.println("el numero que has introducido ya esta en el boleto o no esta comprendido entre el 0 y el 49. Inserta otro diferente.");
            }else{
                boletoAux[4] = numero;
                validado = true;
            }
        }while (!validado);
        do {
            validado = false;
            System.out.println("Inserta el sexto numero:");
            numero = input.nextInt();
            input.nextLine();

            if(busquedaLineal(boletoAux, numero) || !validarNumero(numero)){
                System.out.println("el numero que has introducido ya esta en el boleto o no esta comprendido entre el 0 y el 49. Inserta otro diferente.");
            }else{
                boletoAux[5] = numero;
                validado = true;
            }
        }while (!validado);
        Arrays.sort(boletoAux);
        Boleto b1 = new Boleto(boletoAux);

        System.out.println(b1.toString());

        return b1;
    }

    /**
     * este metodo es para hacer una busqueda dentro del array para ver si esta repetido, si esta repetido, devolvera true
     * y el metodo de rellenar manualmente nos dira que introduzcamos un numero valido
     * @param array es el array del boleto que le pasamos
     * @param dato es el numero que queremos saber si esta dentro del array
     * @return devuelve si el numero esta repetido o no
     */
    static boolean busquedaLineal(int[] array, int dato) {
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] == dato) {
                return true;
            }
        }
        return false;
    }

    /**
     * Con este metodo validamos si el numero se encuentra en el rango del 1 al 49
     * @param numero numero que queremos comprobar
     * @return devuelve true si esta dentro del rango y false si esta fuera
     */
    static boolean validarNumero(int numero){
        if(numero>=0 && numero<=49){
            return true;
        }
        return false;
    }

    /**
     * con este metodo rellenamos de forma automatica el boleto, lo que hago es crear un objeto boleto de 49 posiciones.
     * otro boleto con 7 posiciones, 6 para el principal y el 7 para el reintegro y un auxiliar para ayudarme a traspasar
     * los datos.
     * @return devuelve un boleto relleno
     */
    public Boleto rellenarAutomatico(){

        Boleto boletoAuto = new Boleto(1,49);

        int[] boletoAux = new int[7];

        for(int i = 0; i < boletoAux.length; i++){
            boletoAux[i] = boletoAuto.generarBoletoAutomatico();
        }
        Arrays.sort(boletoAux);
        Boleto b1 = new Boleto(boletoAux);

        System.out.println(b1.toString());
        return b1;
    }


}
