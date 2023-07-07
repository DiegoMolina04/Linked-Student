/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listasenlazadasjardin;


public class Estudiante implements Comparable<Estudiante>{
    
String nombre;
Integer edad;

public Estudiante (String nom, int ed){
    
    nombre = nom;
    edad = ed;
    
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Estudiante o) {
        return edad.compareTo(o.getEdad());
    }
 
}
