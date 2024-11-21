package Evidencia_2;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

public class Tombola{
   PriorityQueue<Integer> numeros = new PriorityQueue<>(30);
   String[] nombre_premios = {"Wii U","PSP","Boletos al cine","Un juego de platos","Juego de tazas","Carro a control remoto","Audifonos","Estuche","Bocina","Un mini refri"};
   HashMap<Integer,String > premios = new HashMap<>();
   Random random = new Random();
   public void generar_numeros(){
    for (int i=0;i<30;i++) {
        Integer agregar = random.nextInt(50)+1;
        //System.out.println(agregar);
        if (verificador_repeticion(new PriorityQueue<>(numeros),agregar)==false) {
            numeros.add(agregar); 
            if (i<10) {
            premios.put(agregar, nombre_premios[i]);
            }
        }else{
            i--;
        }
    }
   }

   public Boolean verificador_repeticion(PriorityQueue<Integer> temporal, Integer numero_verificar){
    if (temporal.isEmpty()) {
        return false;
    }
    if (temporal.poll().equals(numero_verificar)) {
        return true;
    }else
        return verificador_repeticion(temporal, numero_verificar);
   }


   public void sorteo(){
    if (numeros.isEmpty()) {
        System.out.println("No se han generado los numeros ganadores");
    }else if (premios.isEmpty()) {
        System.out.println("No se han generado los numeros para ganar los premios");
    }
    for (int i=0;i<30;i++) {
        Integer indice =numeros.poll();
        System.out.print("Numero ganador: "+indice+", ");
        if (premios.containsKey(indice)) {
            System.out.println(premios.get(indice));
        }else{
            System.out.println("premio en efectivo");
        }
    }
    
   }
}