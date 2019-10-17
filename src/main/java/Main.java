
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ainhoa Pau y Alejandro Martí
 */
public class Main {

    static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola
    static int select = -1; //opción elegida del usuario
    static int id_numerico = 0;
    static String id_generado = "00000";
    private ArrayList<Miembro> miembros = new ArrayList<Miembro>();
    private ArrayList<Moto> motos = new ArrayList<Moto>();
    private ArrayList<Cesion> cesiones = new ArrayList<Cesion>();

    public static void main(String[] args) {
        Main a = new Main();
        a.Menu();
    }
    /**
     * Menu
     * 
     * Función que nos permite mostrar un menu por pantalla
     * 
     */
    public void Menu() {
        //Mientras la opción elegida sea 0, preguntamos al usuario
        while(select != 0){
                    //Try catch para evitar que el programa termine si hay un error
            try{
                System.out.println("Bienvenido a nuetra aplicación, elija la opción que desee: \n" +
                                    "0.- Salir de la aplicación sin guardar datos\n" +
                                    "1.- Registrar Miembro\n" +
                                    "2.- Registrar Moto\n" +
                                    "3.- Registrar Cesion\n" +
                                    "4.- Ver Miembros\n" +
                                    "5.- Ver Motos\n" +
                                    "6.- Ver Cesiones\n" +
                                    "7.- Guardar los datos y Salir");
                select = Integer.parseInt(scanner.nextLine()); 
                
                switch (select) {
                    case 1:
                        registroMiembro();
                        break;
                    case 2:
                        registroMoto();
                        break;
                    case 3:
                        registroCesion();
                        break;
                    case 4:
                        System.out.println("LISTADO DE MIEMBROS CON MOTOS EN POSESION: \n");
                        mostrarMiembros();
                        break;
                    case 5:
                        System.out.println("LISTADO DE MOTOS REGISTRADAS: \n");
                        mostrarMotos();
                        break;
                    case 6:
                        System.out.println("LISTADO DE CESIONES REALIZADAS: \n");
                        mostrarCesiones();
                        break;
                    case 7: 
                        guardarDatos();
                        System.exit(0);
                    break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }

                System.out.println("\n"); //Mostrar un salto de línea en Java

            } catch (Exception e) {
                System.out.println("");
            }
        }
    }
    
    /**
     * registroMiembro
     * 
     * Pide los datos de un nuevo miembro por pantalla 
     * 
     */
    public void registroMiembro() {
        Miembro newMiembro = new Miembro();
        System.out.println("REGISTRO DEL MIEMBRO: \n");
        System.out.println("Introduce el nombre del nuevo miembro: ");
        newMiembro.setNombre(InputString());
        System.out.println("Introduce los apellidos del miembro: ");
        newMiembro.setApellidos(InputString());
        newMiembro.setIdMiembro();
        miembros.add(newMiembro);
    }
    
    /**
     * registroMoto
     * 
     * Pide los datos de una nueva moto por pantalla
     * 
     */
    public void registroMoto() {
        String newMatricula = "";
        Moto newMoto = new Moto();
        System.out.println("REGISTRO DE LA MOTO: \n");
        System.out.println("Introduce la descripción de la moto: ");
        newMoto.setDescripcion(InputString());
        System.out.println("Introduce la matrícula de la moto: ");
        newMatricula = scanner.nextLine();
        newMoto.setMatricula(newMatricula);
        System.out.println("Introduce el precio de la moto: ");
        newMoto.setPrecio(Inputint());
        motos.add(newMoto);
    }
    /**
     * registroCesion
     * 
     * Pide los datos por pantalla de una nueva cesion
     */
    public void registroCesion() {
        Cesion newCesion = new Cesion();
        Miembro member1, member2;
        String matricula, miembro1, miembro2;
        boolean ok = false;
        Moto motoCorrecta = new Moto();
        System.out.println("REGISTRO DE LA CESION: \n");
        System.out.println("Introduce la matrícula de la moto a ceder: ");
        matricula = scanner.nextLine();
        motoCorrecta = buscarMoto(matricula);
       // motoCorrecta.setMatricula(matricula);
        System.out.println("Introduce el nombre del miembro que cede: ");
        miembro1 = scanner.nextLine();
        System.out.println("Introduce el nombre del miembro receptor: ");
        miembro2 = scanner.nextLine();
        if(comprobarCesiones(miembro2,motoCorrecta.getPrecio())){
            newCesion.setMiembro1(buscarMiembro(miembro1));
            newCesion.setMiembro2(buscarMiembro(miembro2));
            newCesion.setMoto(motoCorrecta);

            cesiones.add(newCesion);
            buscarMiembro(miembro2).addMotos(motoCorrecta);
            buscarMiembro(miembro1).removeMotos(matricula);
            System.out.println("Generado: " + newCesion);
        }else{
            return;
        }
            
        
    }
    /**
     * 
     * @param miembro 
     */
    public boolean comprobarCesiones(String miembro, int precio){
        System.out.println("Comprobar cesiones"+ "entrada");
        Miembro miembrobuscado = buscarMiembro(miembro);
        int preciototal = 0;
        boolean result = true;
        
        for (int i = 0; i< miembrobuscado.getMotos().size();i++){
            System.out.println("entrada al for");
            preciototal = preciototal + miembrobuscado.getMotos().get(i).getPrecio();
            System.out.println(miembrobuscado.getMotos().get(i).getPrecio());
        }
        
        if((preciototal + precio) > 6000){
            
            System.out.println("Error, coste total de las motos > 6000");
            result = false;
        }
        return result;
    }
    /**
     * buscarMoto
     * 
     * Permite buscar una moto en el vector
     * 
     * @param matricula Matricula de la moto a Buscar
     * @return 
     */
    public Moto buscarMoto(String matricula) {
        Moto buscado = new Moto();
        int coincidencias = 0;
        for (int i = 0; i <= motos.size(); i++) {
            if (motos.get(i).getMatricula().equals(matricula)) {
                return motos.get(i);
            }
        }
        if (coincidencias > 1) {
            System.out.println("Advertencia: existe mas de una moto con la misma matricula");
        }
        return buscado;
    }
    /**
     * buscarMiembro
     * 
     * Permite buscar un miembro por su nombre
     * 
     * @param miembro
     * @return 
     */
    public Miembro buscarMiembro(String miembro) {
        Miembro buscado = new Miembro();
        int coincidencias = 0;
        for (int i = 0; i <= miembros.size(); i++) {
            if (miembros.get(i).getNombre().equals(miembro)) {
                return miembros.get(i);
            }
        }
        if (coincidencias > 1) {
            System.out.println("Advertencia: existe mas de un miembro con ese nombre,se usará el más reciente");
        } else if (coincidencias < 1) {
            System.out.println("Error");
        }
        System.out.println();
        return null;
    }
    
    /**
     * mostrarMiembros
     * 
     * Permite mostrar los miembros del vector miembros
     * 
     */
    public void mostrarMiembros() {
        System.out.println("Miembros:");
        for (int i = 0; i <= miembros.size(); i++) {
            System.out.println("--------------------------------------------");
            System.out.println("Número socio: " + miembros.get(i).getId_miembro());
            System.out.println("Nombre:" + miembros.get(i).getNombre());
            System.out.println("Apellidos:" + miembros.get(i).getApellidos());
            System.out.println("Motos:" + miembros.get(i).getMotos());
            System.out.println("Motos:" + miembros.get(i).getMotos().size());
        }
    }
    /**
     * mostrarMotos
     * 
     * Permite mostrar todas las motos registradas
     */
    public void mostrarMotos() {
        System.out.println("Motos:");
        System.out.println(motos.size());
        if (motos.size() == 0) {
            System.out.println("No se han encontrado motos");
        } else {
            for (int i = 0; i <= motos.size(); i++) {
                System.out.println("--------------------------------------------");
                System.out.println("Número moto: " + motos.get(i).getId());
                System.out.println("Matricula: " + motos.get(i).getMatricula());
                System.out.println("Descripción:" + motos.get(i).getDescripcion());
                System.out.println("Precio:" + motos.get(i).getPrecio());
                if (motos.get(i).getId_propietario() != null) {
                    System.out.println("Propietario actual :" + motos.get(i).getId_propietario());
                } else {
                    System.out.println("Sin propietario");
                }
            }
        }

    }
    /**
     * mostrarCesiones
     * 
     * Permite mostrar todas las cesiones registradas
     * 
     */
    private void mostrarCesiones() {
        System.out.println("Cesiones:");
        if (motos.size() == 0) {
            System.out.println("No se han encontrado cesiones");
        } else {
                for (int i = 0; i <= cesiones.size(); i++) {
                    System.out.println(cesiones.get(i));
                }
        }
    }
    /**
     * InputString
     * 
     * Permite introducir por pantalla una cadena de caracteres valida
     */
    public String InputString() {
        String strWord = new String();
        boolean isValidInput = false;
        do {
            strWord = scanner.nextLine();

            if (!(strWord.isEmpty()) && !(Character.isWhitespace(strWord.charAt(0)))) {
                isValidInput = true;
            } else {
                System.out.println("Entrada Incorrecta, Intentelo de nuevo");
            }
        } while (!isValidInput);
        return strWord;
    }
    /**
     * inputInt
     * 
     * Permite introducir por pantalla un entero valido
     * 
     * @return strnumber numero introducido por pantalla
     */
    public int Inputint() {
        int strnumber;
        boolean isValidInput = false;
        do {
            strnumber = scanner.nextInt();

            if (strnumber > 0 && strnumber < 999999999) {
                isValidInput = true;
            } else {
                System.out.println("Entrada Incorrecta, Intentelo de nuevo");
            }
        } while (!isValidInput);
        return strnumber;
    }
    /**
     * guardarDatos
     * 
     * Permite guardar los datos en un fichero
     */
    public void guardarDatos() {
        String nombreArchivo = "";
        System.out.println("GUARDAR DATOS MOSTRADOS EN UN FICHERO. \n");
        System.out.println("Porfavor, introduzca el nombre del archivo que quiera crear: ");
        nombreArchivo = scanner.nextLine();
        System.out.println(nombreArchivo);
        try{
            File archivo;
            PrintWriter escribir;
            archivo = new File(nombreArchivo + ".txt"); //No creo que sea ese el argumento
        
            if(archivo.createNewFile()){
                System.out.println("Archivo creado.");
                escribir = new PrintWriter (archivo);
                escribir.println("Hola mundo :)");
                escribir.println("Miembros:");
                if (motos.size() == 0) {
                    escribir.println("No se han encontrado miembros");
                } else {
                        for(int i=0;i<miembros.size();i++)
                        {
                            escribir.println("--------------------------------------------");
                            escribir.println("Número socio: " + miembros.get(i).getId_miembro());
                            escribir.println("Nombre:" + miembros.get(i).getNombre());
                            escribir.println("Apellidos:" + miembros.get(i).getApellidos());
                            escribir.println("Motos:" + miembros.get(i).getMotos());
                        }
                }
                
                escribir.println("Cesiones:");
                
               /* if (motos.size() == 0) {
                    escribir.println("No se han encontrado cesiones");
                } else {
                    for (int i = 0; i <= cesiones.size(); i++) {
                        escribir.println(cesiones.get(i));
                    }
                }
                */
                escribir.close();

            }
        } catch(IOException e){
            System.err.println("No se ha podido crear el archivo." +e);
        }
    }
}
