/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class SinglyLinkedListNGTest{

    @Test
    public void test() {
        try {
            SinglyLinkedList list = new SinglyLinkedList();
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
        try {

            SinglyLinkedList list = new SinglyLinkedList();

            list.add(new Student("1", "Maria", 20, "Cartago"));
            list.add(new Student("2", "Carlos", 22, "San jose"));
            list.add(new Student("3", "Laura", 20, "Paraiso"));
            list.add(new Student("4", "Paula", 18, "Turrialba"));
            list.add(new Student("5", "Carlos", 21, "Limon"));
            list.add(new Student("6", "Fabiana", 19, "Paraiso"));
            list.add(new Student("7", "Maria", 23, "Guanacaste"));
            list.add(new Student("8", "Carlos", 25, "San carlos"));
            list.add(new Student("9", "Laura", 20, "Turrialba"));
            list.add(new Student("10", "Pedro", 24, "Heredia"));
            System.out.println("Laboratorio 4\nSinglyLinkedList");
          
            System.out.println("\nBusqueda de estudiantes\n");
            System.out.println("\nExiste Pedro ID=20? " 
                    +list.contains(new Student("20", "Pedro", 25, "Heredia")));
            System.out.println("Existe Paula ID=4? " 
                    + list.contains(new Student("4", "Paula", 18, "Turrialba")));
            System.out.println("Existe Carlos ID=5? " 
                    + list.contains(new Student("5", "Carlos", 21, "Limon")));
            System.out.println("Existe Carlos ID=8? " 
                    + list.contains(new Student("8", "Carlos", 25, "San carlos")));

            System.out.println("\n\nMostrar lista\n");
            for (int i = 1; i <= list.size(); i++) {
                System.out.println("El elemento en la posicion " + i + " es " + list.getNode(i).data);
            } 
            System.out.println("La cantidad de Carlos es "+countNames(list,"Carlos"));
            System.out.println("\n Determinar posición\n");

            System.out.println("El estudiante Carlos con ID 8 esta en la posicion  :" 
                    + list.indexOf(new Student("8", "Carlos", 25, "San carlos")));
            System.out.println("El estudiante con el ID 100 esta en la posicion  :" 
                    + list.indexOf(new Student("100", "Pedro", 24, "Heredia")));

            list.sort();
            System.out.println("Ordenado lista de estudiante por nombre\n" + list.toString());
            System.out.println("\nSuprimir los estudiantes con ID= 1,3,5");
           
            list.remove(new Student("1", "Maria", 20, "Cartago"));
            list.remove(new Student("3", "Laura", 20, "Paraiso"));
            list.remove(new Student("5", "Carlos", 21, "Limon"));
            System.out.println("\n" + list.toString());

            System.out.println("La cantidad de Carlos es "+countNames(list,"Carlos"));
            
            System.out.println("¿En la lista existe una estudiante con el nombre Karla? "+findNames(list,"Karla"));
            System.out.println("¿En la lista existe una estudiante con el nombre Fabiana? "+findNames(list,"Fabiana"));           
        } catch (ListException ex) {
            
            Logger.getLogger(SinglyLinkedListNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    } 
    
    
       
    private int countNames(SinglyLinkedList list, String name) throws ListException{
        int count = 0;
        for(int i = 1; i<= list.size(); i++){
            Student s = (Student)list.getNode(i).data;
            if(s.getName().equalsIgnoreCase(name)){
                count++;
            }
        }
        return count;

     }
    
    private boolean findNames(SinglyLinkedList list, String name) throws ListException{
        for(int i = 1; i<= list.size(); i++){
            Student s = (Student)list.getNode(i).data;
            if(s.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    
}
