/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Modelo.Tractor;
import Modelo.Truck;
import Vista.CochesPanel;
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
        Semaphore preadmision = new Semaphore(1);
        Semaphore descarga = new Semaphore(1);
        Semaphore documentacion = new Semaphore(1);
        List<Semaphore> semaforos = new ArrayList<>();
        semaforos.add(preadmision);
        semaforos.add(descarga);
        semaforos.add(documentacion);
        Object [] fases = new Object [3];
        Random rd = new Random(System.currentTimeMillis());
        List<Thread> hilos = new ArrayList<>();
        List<Object> referencias = new ArrayList<>();
        
        CochesPanel cochesPanel = new CochesPanel(fases,referencias);
        Ventana ven = new Ventana(cochesPanel);
        
        
        for(int i = 0; i < numHilos; i++){
            if(rd.nextInt(1000) < 700){
                Truck truck = new Truck(i,semaforos, fases, cochesPanel);
                hilos.add(truck);
                referencias.add(truck);
                hilos.get(i).start();
            }else{
                Tractor tractor = new Tractor(i, semaforos, fases, cochesPanel);
                hilos.add(new Thread(tractor));
                referencias.add(tractor);
                hilos.get(i).start();
            }
            cochesPanel.repaint();
            try {
                Thread.sleep(1000 + rd.nextInt(1000));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        for(Thread h : hilos){
            h.join();
        }
        
        
         
    }
    
    
    
}
