/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelo.Tractor;
import Modelo.Truck;
import Vista.Ventana;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rubco
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int numHilos = 20;
        Ventana ven = new Ventana();
        
        
        /*Semaphore preadmision = new Semaphore(1);
        Semaphore descarga = new Semaphore(1);
        Semaphore documentacion = new Semaphore(1);
        List<Semaphore> semaforos = new ArrayList<>();
        semaforos.add(preadmision);
        semaforos.add(descarga);
        semaforos.add(documentacion);
        int [] fases = new int [3];
        Random rd = new Random(System.currentTimeMillis());
        List<Thread> hilos = new ArrayList<>();
        for(int i = 0; i < numHilos; i++){
            if(rd.nextInt(1000) < 700){
                hilos.add(new Truck(semaforos, fases));
                hilos.get(i).start();
            }else{
                hilos.add(new Thread(new Tractor(semaforos, fases)));
                hilos.get(i).start();
            }
            try {
                Thread.sleep(1000 + rd.nextInt(1000));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        for(Thread h : hilos){
            h.join();
        }
        
        */
         
    }
    
}
