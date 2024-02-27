
/*
 * Autores: Sebastian Felipe Moreno Martinez 
 * 			Victor Manuel Velasquez Benavides
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Diario {

		    private ArrayList<Entrada> misEntradas;
		    //Lo que entra en toda contenedora es un objeto.
		    private Scanner lector;
		    
		    public Diario() {
		        misEntradas = new ArrayList<>();
		        lector = new Scanner(System.in);
		    }
		    
		    public void mostrarOpciones() { 
		    boolean activo=true;
		    do {
		    System.out.println("========== MENÚ DE OPCIONES ==========\n"
		            + "1. Agregar Entrada\n"
		            + "2. Consultar Entrada\n"
		            + "3. Eliminar Entrada\n"
		            + "4. Modificar Entrada\n"
		            + "5. Terminar Programa\n");
		    
		    int opcion=lector.nextInt();
		    switch(opcion){
		        case 1:
		        	agregarEntrada();
		        break;
		           
		        case 2:
		            consultarEntrada(); 
		        break;
		        
		        case 3:
		        	eliminarEntrada();
		        break;
		        
		        case 4:
		            modificarEntrada();
		        break;
		        
		        case 5:
		        	activo=false;
		            System.out.println("Programa terminado.");
		        break;
		        
		        default:
		            System.out.println("Opción Incorrecta, intenta nuevamente.");
		        }
		    }
		    while (activo);  
			}
		    public void agregarEntrada() {
		    	int tamanoLista = misEntradas.size();
		        
		        // Verifica si la lista está vacía para asignar el ID de la primera entrada como 1
		        int nuevoldEntrada = tamanoLista == 0 ? 1 : misEntradas.get(tamanoLista - 1).getIdEntrada() + 1;
		        System. out.println ("La nueva entrada tiene Id: "+nuevoldEntrada);
		      
		        Date fecha = new Date();
		        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		        String fecha1 = formato.format(fecha);
		        System.out.println("Fecha actual: "+fecha1);

		        Scanner lector = new Scanner(System.in);
		        System.out.println("Ingresa la descripción de la entrada: ");
		        String descripcion = lector.nextLine();
		      
		        Entrada nuevaEntrada = new Entrada(nuevoldEntrada, fecha1, descripcion);
		        misEntradas.add(nuevaEntrada);
		        System.out.println("La entrada fue agregada exitosamente");
		    }
		    public void consultarEntrada() {
		    	if (misEntradas.isEmpty()) {
		            System.out.println("No hay entradas registradas en el sistema.");
		        }
		    	else {
		        Scanner lector = new Scanner(System.in);
		        System.out.println("Ingresa la fecha de la entrada que deseas buscar (en formato dd-MM-yyyy): ");
		        String fechaBuscar = lector.nextLine();

		        for (Entrada entrada : misEntradas) {
		            if (entrada.getFecha().equals(fechaBuscar)) {
		                System.out.println("Entrada encontrada:\n"
		                		+ " Id: "+entrada.getIdEntrada()
		                		+ "\n Fecha: "+ entrada.getFecha()
		                		+ "\n Descripción: "+ entrada.getDescripcion());
		                break;
		            }
		            else {
		            	System.out.println("La fecha ingresada no cuenta con entradas. ");
		            }
		        }
		    	}
		    }
		    
		    public void eliminarEntrada() {
		        if (misEntradas.isEmpty()) {
		            System.out.println("No hay entradas registradas en el sistema.");
		        }
		        else {
		        System.out.println("Digite el Id de la entrada que quiere eliminar: ");
		        int id = lector.nextInt();
		        Iterator<Entrada> iterador = misEntradas.iterator();
		        while (iterador.hasNext()) {
		            Entrada entrada = iterador.next();
		            if (entrada.getIdEntrada() == id) {
		                System.out.println("¿Estás seguro que quieres eliminar esta entrada?");
		                System.out.println("Ingrese: 1 para confirmar o 2 para cancelar: ");
		                int confirmacion = lector.nextInt();
		                if (confirmacion == 1) {
		                    iterador.remove();
		                    System.out.println("La entrada con Id: " + id + " ha sido eliminada.");
		                } else {
		                    System.out.println("La entrada no ha sido eliminada.");
		                }
		                break;
		            }
		            else {
		            	System.out.println("El Id: " + id + " no esta disponible para eliminar");
		            }
		        }
		    }
		    }
		    
		    public void modificarEntrada() {
		        if (misEntradas.isEmpty()) {
		            System.out.println("No hay entradas registradas en el sistema.");
		        } else {
		            System.out.println("Digite el Id de la entrada que quiere modificar: ");
		            int id = lector.nextInt();
		           
		            for (Entrada entrada : misEntradas) {
		                if (entrada.getIdEntrada() == id) {
		                    System.out.println("Ingrese la nueva descripción para la entrada con Id " + id + ": ");
		                    lector.nextLine();
		                    String nuevaDescripcion = lector.nextLine();
		                    entrada.setDescripcion(nuevaDescripcion);
		                    System.out.println("La descripción de la entrada con Id " + id + " ha sido modificada correctamente.");
		                    break;
		                }
		            
		            else {
		            	System.out.println("El Id: " + id + " no está disponible para modificar.");
		            }
		            }
		        }
		    }

		    public static void main(String[] args) {
		    	Diario organizador = new Diario();
		    	organizador.mostrarOpciones();
		    }
		
}