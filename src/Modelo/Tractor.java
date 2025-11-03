/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rubco
 */
public class Tractor implements Runnable{
    
    private static int contador = 0;
    private int estado;
    private int id;
    private List<Semaphore> semaforos;
    private int [] fase;
    
    public Tractor(List<Semaphore> semaforos, int []fase){
        estado = -1;
        this.id = contador;
        this.semaforos = semaforos;
        this.fase = fase;
        contador++;
    }
    

    @Override
    public void run() {
        try {
            semaforos.get(0).acquire();
            estado = 0;
            fase[0] = id;
            
            
        } catch (InterruptedException ex) {
            System.getLogger(Tractor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        
    }
    
}
