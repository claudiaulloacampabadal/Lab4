/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Maria Celeste
 */
public class DoublyLinkedListNGTest {
    
      @Test
    public void test() {
        try {
            DoublyLinkedList list = new DoublyLinkedList();
            list.add(10);
            list.add(20);
            for (int i = 0; i < 10; i++) {
                //list.add(new java.util.Random().nextInt(99));
                list.add(util.Utility.random(99));
            }
            System.out.println(list.toString());
            System.out.println("The first element in the list is: "
                    +list.getFirst());
            System.out.println("The last element in the list is: "
                    +list.getLast());
            System.out.println("The size of the list is: "+list.size());
             System.out.println("The node "+list.getNode(1).data);
            
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(99);
                System.out.println(list.contains(value)
                        ?"The value ["+value+"] exists in the list"
                        :"The value ["+value+"] does not in the list"
                );
                if(list.contains(value)){
                    list.remove(value);
                    System.out.println("The value ["+value+"] was deleted");
                }
               
            }
            System.out.println(list.toString());
            
        } catch (ListException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(SinglyLinkedListNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     @Test
    public void testSomeMethod() {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("Laboratorio 4 Grupo #3\n DoublyLinkedList ");
        list.add(new Course("IF-3001", "Algoritmos y Estructuras de Datos", 4));
        list.add(new Course("IF-4001", "Sistemas Operativos", 4));
        list.add(new Course("IF-2000", "Programación 1", 4));
        list.add(new Course("IF-3000", "Programación 2", 4));
        list.add(new Course("IF-4000", "Arquitectura", 3));
        list.add(new Course("IF-5000", "Redes", 4));
        list.add(new Course("IF-5100", "Bases de Datos", 4));
        list.add(new Course("IF-4101", "Lenguajes app Comerciales", 4));
        list.add(new Course("IF-3100", "Sistemas de Información", 3));
       

        System.out.println("\nBusqueda de cursos\n");
        try {
            System.out.println("\n¿Existe Informática Aplicada, Id=IF-6201? " 
                    + list.contains(new Course("IF-6201", "Informática Aplicada", 0)));
            System.out.println("¿Existe Algoritmos y Estructuras de Datos, Id=IF-3001? " 
                    + list.contains(new Course("IF-3001", "Algoritmos y Estructuras de Datos", 0)));
            System.out.println("¿Existe Sistemas Operativos, Id=IF-4001? " 
                    + list.contains(new Course("IF-4001", "Sistemas Operativos", 0)));
            System.out.println("¿Existe Análisis y Diseño de Sistemas, Id=IF-6100? " 
                    + list.contains(new Course("IF-6100", "Análisis y Diseño de Sistemas", 0)));

            System.out.println("\n\nMostrar lista\n");
            for (int i = 1; i <= list.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + list.getNode(i).data);
            }
            
            System.out.println("\n Determinar posición\n");
            System.out.println("El curso Algoritmos y Estructuras de Datos Id=IF-3001 se encuentra en la posición:  :" 
                    + list.indexOf(new Course("IF-3001", "Algoritmos y Estructuras de Datos", 0)));
            System.out.println("El curso Análisis y Diseño de Sistemas con Id=IF-6100 se encuentra en la posición   :" 
                    + list.indexOf(new Course("IF-6100", "Análisis y Diseño de Sistemas", 0)));

         
            System.out.println("\nSuprima los cursos con Id= IF-5000, IF-5100");
            list.remove(new Course("IF-5000", "Redes", 0));
            list.remove(new Course("IF-5100", "Bases de Datos", 0));
            System.out.println("\n"+list.toString());
             list.sort();
            System.out.println("Ordenado lista de cursos por nombre\n" + list);
            

        } catch (ListException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(DoublyLinkedListNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
