
import java.util.Date;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa Pau y Alejandro Martí
 */
public class Miembro {
    private String nombre;
    private String apellidos;
    private static int numMiembros = 0;
    private int idMiembro = 0;
    private String idcliente;
    //static private int contadorMiembro = 0;
    private ArrayList<Moto> motos = new ArrayList<Moto>();
    /**
     * Constructor miembro
     */
    public Miembro(){
        nombre = "Sin informacion";
        apellidos = "Sin informacion";
        idMiembro = numMiembros;
        numMiembros++;
        idcliente = String.format("%03d", idMiembro);
    }
    /**
     * getNombre
     * 
     * Devuelve el nombre del miembro
     * 
     * @return 
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * getApellidos
     * 
     * Devuelve los apellidos del miembro
     * 
     * @return 
     */
    public String getApellidos(){
        return apellidos;
    }
    /**
     * getId_miembro
     * 
     * Devuelve el id del miembro
     * 
     * @return 
     */
    public String getId_miembro(){
        return idcliente;
    }
    /**
     * getMotos
     * 
     * Devuelve las motos que posee el miembro actualmente
     * @return 
     */
    public ArrayList<Moto> getMotos(){
        return motos;
    }
    /**
     * setNombre
     * 
     * Permite introducir el nombre del miembro
     * 
     * @param nom 
     */
    public void setNombre(String nom){
        this.nombre = nom;
    }
    /**
     * setApellidos
     * 
     * Permite introducir los apellidos del miembro
     * 
     * @param ape 
     */
    public void setApellidos(String ape){
        this.apellidos = ape;
    }
    /**
     * setIdMiembro
     * 
     * Permite establecer el id del miembro
     * 
     */
    public void setIdMiembro(){
        this.idMiembro = numMiembros;
    }
    /**
     * setMotos
     * 
     * Permite añadir motos al miembro
     * @param moto 
     */
    public void addMotos(Moto moto){
            motos.add(moto);
    }
    /**
     * removeMotos
     * 
     * Permite añadir motos al miembro
     * @param moto 
     */
    public void removeMotos(String matricula){
        int coincidencias = 0;
        for (int i = 0; i <= motos.size(); i++) {
            if (motos.get(i).getMatricula().equals(matricula)) {
                motos.remove(i);
                return;
            }
        }
        if (coincidencias < 1) {
            System.out.println("Error");
        }
        return;
    }
    /**
     * toString
     * 
     * Permite devolver la informacion del miembro
     * 
     * @return 
     */
   public String toString() {
        return "";
    }
    
    
}
