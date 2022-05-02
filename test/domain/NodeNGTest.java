/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package domain;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class NodeNGTest {
    
    public NodeNGTest() {
    }

    @Test
    public void test() {
        //Node a = new Node("Hello World");
        //Node b = new Node(10);
        //a.next = b; //hemos enlazado los dos nodos
//        System.out.println(a.data);
//        System.out.println(b.data);
        Node first = null;
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            int value = r.nextInt(99);
            Node newNode = new Node(value);
            if(first == null)
                first = newNode;
            else{
                Node aux = first;
                while(aux.next!=null)
                    aux = aux.next;
                aux.next = newNode;
            }
        }
       Node aux = first;
       int counter = 0;
       while(aux!=null){
           counter++;
           System.out.print(aux.data+" ");
           aux = aux.next;
       }
        System.out.println("\nTotal de nodos en la lista: "+counter);
       
    }
    
}
