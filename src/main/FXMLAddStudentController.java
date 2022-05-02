/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import java.net.URL;
import java.nio.channels.Pipe;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class FXMLAddStudentController implements Initializable {

    private SinglyLinkedList studentList;
    private Alert alert;

    @FXML
    private BorderPane bp;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAddOnAction(ActionEvent event) throws ListException{
        //revisar si la student list es nulo
        if(studentList == null && util.Utility.getSinglyLinkedList().isEmpty()){
            //Para que llene todos los espacios, si hay uno vacio te manda un mensaje de error
            if("".equals(idTextField.getText()) || "".equals(nameTextField.getText())
                    || "".equals(addressTextField.getText()) || "".equals(ageTextField.getText()) ){
                
                alert = new Alert(AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Add Student Algorithm");
                alert.setHeaderText("There was an error");
                alert.setContentText("Fill ALL the blank spaces");
                alert.show();
                
            }else{
                try{//llenando un objeto student
                    Student s = new Student(idTextField.getText(), nameTextField.getText(),
                            Integer.parseInt(ageTextField.getText()), addressTextField.getText());
                    studentList = new SinglyLinkedList();//Si es nulo crear uno nuevo
                    studentList.add(s);//añadiendo el objeto Student en la lsita
                    util.Utility.setSinglyLinkedList(studentList);
                    //Borrando los text field par aun mjeor control
                    idTextField.setText("");
                    ageTextField.setText("");
                    addressTextField.setText("");
                    nameTextField.setText("");
                    
                    alert = new Alert(AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Student Algorithm");
                    alert.setHeaderText("The student add successful");
                    alert.setContentText("Close or add more students");
                    alert.show();
                    
                }catch(NumberFormatException nfe){
                    ageTextField.setText("");
                    alert = new Alert(AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Add Student Algorithm");
                    alert.setHeaderText("There was an error");
                    alert.setContentText("Invalid character in age field, try again with a number");
                    alert.show();
                }
                
            }
            //SI no esta vacio entonces llenar desde aqui
        }else{
            if("".equals(idTextField.getText()) || "".equals(nameTextField.getText())
                    || "".equals(addressTextField.getText()) || "".equals(ageTextField.getText()) ){
                
                alert = new Alert(AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Add Student Algorithm");
                alert.setHeaderText("There was an error");
                alert.setContentText("Fill ALL the blank spaces");
                alert.show();
                
                
            }else{
                
                try{//llenando un objeto student
                    Student s = new Student(idTextField.getText(), nameTextField.getText(),
                            Integer.parseInt(ageTextField.getText()), addressTextField.getText());
                    util.Utility.getSinglyLinkedList().add(s);
                    util.Utility.setSinglyLinkedList(util.Utility.getSinglyLinkedList());
                    //Borrando los text field par aun mjeor control
                    idTextField.setText("");
                    ageTextField.setText("");
                    addressTextField.setText("");
                    nameTextField.setText("");
                    
                    alert = new Alert(AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Student Algorithm");
                    alert.setHeaderText("The student add successful");
                    alert.setContentText("Close or add more students");
                    alert.show();
                    
                }catch(NumberFormatException nfe){
                    ageTextField.setText("");
                    alert = new Alert(AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Add Student Algorithm");
                    alert.setHeaderText("There was an error");
                    alert.setContentText("Invalid character in age field, try again with a number");
                    alert.show();
                }
                
            }
            
        }
                    
        
  
    }

    @FXML
    private void bntCloseOnAction(ActionEvent event) {
        FXMLMainMenuController.loadPage(getClass().getResource("FXMLStudent.fxml"), bp);
    }

}
