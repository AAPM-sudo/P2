/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ainhoa Pau y Alejandro Martí
 */
class Moto {
    static private int idMoto = 0;
    private String descripcion;
    private String idPropietario;
    private String matricula;
    private int precio;
    /**
     * 
     */
    public Moto(){
        descripcion = "Sin informacion";
        idPropietario = "Sin informacion";
        matricula = "Sin informacion";
        precio = 0;
        idMoto++;
    }
    /**
     * getDescripcion
     * 
     * Permite mostrar la descripcion de la moto
     * 
     * @return String descripcion
     */
    public String getDescripcion(){
        return descripcion;
    }
    /**
     * 
     * @return 
     */
    public String getId_propietario(){
        return idPropietario;
    }
    /**
     * 
     * @return 
     */
    public String getMatricula(){
        return matricula;
    }
    /**
     * 
     * @return 
     */
    public int getPrecio(){
        return precio;
    }
    /**
     * 
     * @return 
     */
    public int getId(){
        return idMoto;
    }
    /**
     * 
     * @param desc 
     */
    public void setDescripcion(String desc){
        this.descripcion = desc;
    }
    /**
     * 
     * @param idProp 
     */
    public void setPropietario(String idProp){
        this.idPropietario = idProp;
    }
    /**
     * 
     * @param matriculaM 
     */
    public void setMatricula(String matriculaM){
        this.matricula = matriculaM ;
    }
    /**
     * 
     * @param coste 
     */
    public void setPrecio(int coste){
        this.precio = coste;
    }
    /**
     * 
     * @return 
     */
    public String toString() {
        return "Moto " + matricula;
    }
}
