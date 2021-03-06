/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.SinglyLinkedList;
import domain.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Maria Celeste
 */
public class FXMLAddFirstStudentController implements Initializable {
    
    private Alert alert;
    private SinglyLinkedList studentList;

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
    private void btnAddOnAction(ActionEvent event) {
        //revisar si la student list es nulo
        if(studentList == null && util.Utility.getSinglyLinkedList().isEmpty()){
            //Para que llene todos los espacios, si hay uno vacio te manda un mensaje de error
            if("".equals(idTextField.getText()) || "".equals(nameTextField.getText())
                    || "".equals(addressTextField.getText()) || "".equals(ageTextField.getText()) ){
                
                alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Add First Student Algorithm");
                alert.setHeaderText("There was an error");
                alert.setContentText("Fill ALL the blank spaces");
                alert.show();
                
            }else{
                try{//llenando un objeto student
                    Student s = new Student(idTextField.getText(), nameTextField.getText(),
                            Integer.parseInt(ageTextField.getText()), addressTextField.getText());
                    studentList = new SinglyLinkedList();//Si es nulo crear uno nuevo
                    studentList.addFirst(s);//a??adiendo el objeto Student en la lsita
                    util.Utility.setSinglyLinkedList(studentList);
                    //Borrando los text field par aun mjeor control
                    idTextField.setText("");
                    ageTextField.setText("");
                    addressTextField.setText("");
                    nameTextField.setText("");
                    
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add First Student Algorithm");
                    alert.setHeaderText("The student add successful");
                    alert.setContentText("Close or add more students");
                    alert.show();
                    
                }catch(NumberFormatException nfe){
                    ageTextField.setText("");
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Add First Student Algorithm");
                    alert.setHeaderText("There was an error");
                    alert.setContentText("Invalid character in age field, try again with a number");
                    alert.show();
                }
                
            }
            //SI no esta vacio entonces llenar desde aqui
        }else{
            if("".equals(idTextField.getText()) || "".equals(nameTextField.getText())
                    || "".equals(addressTextField.getText()) || "".equals(ageTextField.getText()) ){
                
                alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Add First Student Algorithm");
                alert.setHeaderText("There was an error");
                alert.setContentText("Fill ALL the blank spaces");
                alert.show();
                
                
            }else{
                
                try{//llenando un objeto student
                    Student s = new Student(idTextField.getText(), nameTextField.getText(),
                            Integer.parseInt(ageTextField.getText()), addressTextField.getText());
                    util.Utility.getSinglyLinkedList().addFirst(s);
                    util.Utility.setSinglyLinkedList(util.Utility.getSinglyLinkedList());
                    //Borrando los text field par aun mjeor control
                    idTextField.setText("");
                    ageTextField.setText("");
                    addressTextField.setText("");
                    nameTextField.setText("");
                    
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add irst Student Algorithm");
                    alert.setHeaderText("The student add successful");
                    alert.setContentText("Close or add more students");
                    alert.show();
                    
                }catch(NumberFormatException nfe){
                    ageTextField.setText("");
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Add First Student Algorithm");
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
