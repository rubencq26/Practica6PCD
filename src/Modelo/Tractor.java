/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rubco
 */
public class Tractor implements Runnable {

    private static int contador = 0;
    private int estado;
    private int id;
    private List<Semaphore> semaforos;
    private Object[] fase;

    public Tractor(List<Semaphore> semaforos, Object[] fase) {
        estado = -1;
        this.id = contador;
        this.semaforos = semaforos;
        this.fase = fase;
        contador++;
    }

    @Override
    public void run() {
        Random rd = new Random(System.currentTimeMillis());
        try {
            semaforos.get(0).acquire();
            estado = 0;
            fase[0] = this;
            Thread.sleep(2000 + rd.nextInt(1000));
            semaforos.get(1).acquire();
            estado = 1;
            fase[1] = this;
            Thread.sleep(2000 + rd.nextInt(1000));
            semaforos.get(2).acquire();
            fase[0] = null;
            semaforos.get(0).release();
            estado = 2;
            fase[2] = this;
            Thread.sleep(2000 + rd.nextInt(1000));
            fase[1] = null;
            fase[2] = null;
            semaforos.get(1).release();
            semaforos.get(2).release();
        } catch (InterruptedException ex) {
            System.getLogger(Tractor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
    
    public int getIdent(){
        return id;
    }

}
