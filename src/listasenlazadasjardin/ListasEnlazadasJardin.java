/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasenlazadasjardin;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import listasenlazadasjardin.Estudiante;

/**
 *
 * @author pc
 */
public class ListasEnlazadasJardin {
            
    public static Scanner scTexto = new Scanner(System.in);
    public static Scanner scNumero = new Scanner(System.in);
    
    public static ListasEnlazadasJardin objLista = new ListasEnlazadasJardin();
    
    public static String nombre, nom,primero, ultimo;
    public static int edad, auxIzq, aux, valorIzq, valorDer, age,ed;
    
    public String ingresarNombre(){
        
        
        System.out.println("Ingrese el nombre del estudiante");
        nombre = scTexto.nextLine();
        
        return nombre;
    }
    
    public int ingresarEdad(){
        
        System.out.println("Ingrese la edad del estudiante");
        edad = scNumero.nextInt();
        
        return edad;
    }
    
    public static void main(String[] args) {
       
        boolean flag = true;
        
        int decision;

        LinkedList<Estudiante>agregar= new LinkedList<Estudiante>();
        LinkedList<Estudiante>listaNueva= new LinkedList<Estudiante>();
  
        while(flag){
            
            System.out.println("MENU\n"
                    + "1. Ingresar estudiante\n"
                    + "2. Buscar vecinos del estudiante\n"
                    + "3. Imprimir lista\n"
                    + "4. Eliminar estudiante\n"
                    + "5. Formar nueva lista por edad\n"
                    + "6. Salir");
            
            decision = scNumero.nextInt();
            
            switch (decision) {
                case 1:
                    
                    nom = objLista.ingresarNombre();
                    ed = objLista.ingresarEdad();

                    Estudiante estu = new Estudiante(nom, ed);
                    agregar.add(estu);
                    
                    Collections.sort(agregar);
                    
                break;
                
                case 2:
                    
                    nom = objLista.ingresarNombre();
                    
                    aux = 0;
                    
                    System.out.println("--------------------------------------------------------");
                    for (int i = 0; i < agregar.size(); i++) {
                        
                        primero = agregar.getFirst().getNombre();
                        ultimo = agregar.getLast().getNombre();
                        
                        if(agregar.get(i).getNombre().equals(nom)){
                            
                            if(ultimo.equals(nom)&&agregar.size()>1){
                                
                                auxIzq = agregar.size();
                                valorIzq = auxIzq-2;
                                System.out.println("El vecino a su izquierda es "+agregar.get(valorIzq).getNombre());
                                System.out.println("No tiene vecino hacia su derecha por ser el estudiante final de la lista");
                                aux = 1;
                                
                            }else if(primero.equals(nom)&&agregar.size()>1){
                                
                                System.out.println("No tiene vecino hacia su izquierda por ser el primer estudiante de la lista");
                                System.out.println("El vecino a su derecha es "+agregar.get(i+1).getNombre());
                                aux = 1;
                                
                            }else if(agregar.size()==1){
                                
                                System.out.println(nom +" es el unico en la lista, no tiene vecinos");
                                aux = 1;
                                
                            }else{
                                System.out.println("El vecino a su izquierda es "+agregar.get(i-1).getNombre());
                                System.out.println("El vecino a su derecha es "+agregar.get(i+1).getNombre());
                                aux = 1;
                            }
                            
                        }

                    }
                    
                    if(aux == 0){
                            
                            System.out.println("No se encontro el estudiante");
                            
                        }
                    
                    System.out.println("--------------------------------------------------------");
                break;
                
                case 3:
                    
                    System.out.println("--------------------------------------------------------");
                    if(agregar.isEmpty()){
                        
                        System.out.println("No hay estudiantes registrados");
                        
                    }else{
                        
                        System.out.println("Lista de estudiantes");
                    
                        for (int i = 0; i < agregar.size(); i++) {
                            
                            System.out.println("[ Nombre : "+agregar.get(i).getNombre()+", Edad : "+ agregar.get(i).getEdad()+" ]");
                        
                        }
                        
                    }
                    System.out.println("--------------------------------------------------------");
                    
                break;
                
                case 4:
                    
                    nom = objLista.ingresarNombre();
                    
                    aux = 0;
                    for (int i = 0; i < agregar.size(); i++) {
                        
                        if(agregar.get(i).getNombre().equals(nom)){
                            
                            agregar.remove(i);
                            aux = 1;
                        }


                    }
                    
                    if(aux == 0){
                            
                            System.out.println("No se encontro el estudiante");
                            
                    }
                    
                break;
                
                case 5:
                    
                    age = objLista.ingresarEdad();
                    
                    aux = 0;
                    System.out.println("--------------------------------------------------------");
                    for (int i = 0; i < agregar.size(); i++) {
                        
                        if(agregar.get(i).getEdad() == age){
                            
                            nom = agregar.get(i).getNombre();
                            ed = agregar.get(i).getEdad();
                            
                            Estudiante nuevo= new Estudiante(nom, ed);
                            
                            listaNueva.add(nuevo);
                            
                            aux = 1;
                        }


                    }
                    
                    if(aux == 0){
                            
                            System.out.println("No se encontro estudiantes con esa edad");
                            
                    }else{
                        
                        System.out.println("Lista de estudiantes con edad "+age);
                        
                        for (int i = 0; i < listaNueva.size(); i++) {
                            
                            System.out.println("[ Nombre : "+listaNueva.get(i).getNombre()+", Edad : "+ listaNueva.get(i).getEdad()+" ]");
                            
                        }
                        
                    }
                    
                    listaNueva.removeAll(listaNueva);
                    System.out.println("--------------------------------------------------------");
                break;
                
                case 6:
                    
                    flag = false;
                    
                break;
                 
            }
            
        }
        
    }
    
}
