/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.CochesPanel;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rubco
 */
public class Truck extends Thread{
    
    
    private int estado;
    private int id;
    private List<Semaphore> semaforos;
    private Object [] fase;
    private CochesPanel cochesPanel;
    private boolean finish;
    
    public Truck(int id,List<Semaphore> semaforos, Object []fase, CochesPanel cochesPanel){
        estado = -1;
        this.id = id;
        this.semaforos = semaforos;
        this.fase = fase;
        this.cochesPanel = cochesPanel;
        finish = false;
    }
    
    @Override
    public void run() {
        Random rd = new Random(System.currentTimeMillis());
        try {
            semaforos.get(0).acquire();
            estado = 0;
            fase[0] = this;
            cochesPanel.repaint();
            sleep(2000 + rd.nextInt(1000));
            semaforos.get(1).acquire();
            fase[0] = null;
            semaforos.get(0).release();
            estado = 1;
            fase[1] = this;
            cochesPanel.repaint();
            sleep(2000 + rd.nextInt(1000));
            semaforos.get(2).acquire();
            fase[1] = null;
            semaforos.get(1).release();
            estado = 2;
            fase[2] = this;
            cochesPanel.repaint();
            sleep(2000 + rd.nextInt(1000));
            fase[2] = null;
            estado = -1;
            finish = true;
            semaforos.get(2).release();
            cochesPanel.repaint();
            
        } catch (InterruptedException ex) {
            System.getLogger(Truck.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    public int getIdent(){
        return id;
    }

    public int getEstado() {
        return estado;
    }

    

    public boolean isFinish() {
        return finish;
    }

    
    
    
    
}
