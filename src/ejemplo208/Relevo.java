/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo208;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Cristobal Ramirez
 */
public class Relevo implements Runnable {
    
    
    private int ancho = 0; 
    private JLabel label;
    private RecursoCompartido recursoCompartido;

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public RecursoCompartido getRecursoCompartido() {
        return recursoCompartido;
    }

    public void setRecursoCompartido(RecursoCompartido recursoCompartido) {
        this.recursoCompartido = recursoCompartido;
    }

    public Relevo(JLabel label, RecursoCompartido recursoCompartido, int ancho) {
        this.label = label;
        this.recursoCompartido = recursoCompartido;
        this.ancho = ancho;
    }
    CyclicBarrier barra = new CyclicBarrier(5);
    @Override
    public void run() {
        Random r = new Random(System.nanoTime());
        int avance = 217;
        while( avance < ancho){
            /**if(recursoCompartido.isFlagWinner()){
                break;
            }**/
            if(r.nextInt(1000) < 500){
                avance ++;
            } else{
                avance += 0;
            }
                label.setLocation(avance,label.getY());
            try {
                Thread.sleep(10 + r.nextInt(50));
            } catch (InterruptedException ex) {
            }
        }
        

        recursoCompartido.setNameWinner(label.getText());   
    }
    
}
