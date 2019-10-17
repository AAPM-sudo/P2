
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa Pau y Alejandro Martí
 */
public class Cesion {
    
    private Moto moto;
    private Miembro miembro_1;
    private Miembro miembro_2;
    private Date fecha;
    /**
     * Cesion
     * 
     * Contructor de la clase cesion
     * 
     */
    public Cesion(){
        moto = new Moto();
        miembro_1 = new Miembro();
        miembro_2 = new Miembro();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        fecha = new Date(System.currentTimeMillis());
    }
    /**
     * setMoro
     * 
     * Permite introducir los datos de la moto a ceder
     * 
     * @param moto_cesion 
     */
    public void setMoto(Moto moto_cesion){
        this.moto = moto_cesion;
    }
    /**
     * setMiembro1
     * 
     * Permite introducir los datos del miembro 1 de la cesion
     * @param miembro1 
     */
    public void setMiembro1(Miembro miembro1){
        this.miembro_1 = miembro1;
    }
    /**
     * setMiembro2
     * 
     * Permite introducir los datos del miembro 2 de la cesion
     * @param miembro2
     */
    public void setMiembro2(Miembro miembro2){
        this.miembro_2 = miembro2;
    }
    /**
     * setFecha
     * 
     * Permite introducir la fecha de la sesion
     * 
     * @param fecha_cesion 
     */
    public void setFecha(Date fecha_cesion){
        this.fecha = fecha_cesion;
    }
    /**
     * toString
     * 
     * Permite devolver una cadena con la informacion de la cesion
     * 
     * @return String cadena con los datos del miembro
     */
    public String toString() {
        return "Miembro " + miembro_1.getId_miembro() + " cede " + moto.toString() + " a Miembro " + miembro_2.getId_miembro() + " el " + fecha +  ".";
    }
}
