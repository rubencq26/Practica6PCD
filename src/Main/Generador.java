/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author rubco
 */
public class Generador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore preadmision = new Semaphore(1);
        Semaphore descarga = new Semaphore(1);
        Semaphore documentacion = new Semaphore(1);
        List<Semaphore> semaforos = new ArrayList<>();
        semaforos.add(preadmision);
        semaforos.add(descarga);
        semaforos.add(documentacion);
        int [] fases = new int [3];
         
    }
    
}
