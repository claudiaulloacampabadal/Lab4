/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Course;
import domain.DoublyLinkedList;
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
public class FXMLAddCourseSortedController implements Initializable {

    private Alert alert;
    private DoublyLinkedList courseList;
    @FXML
    private BorderPane bp;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField creditsTextField;
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
         if(courseList == null && util.Utility.getDoublyLinkedList().isEmpty()){
            //Para que llene todos los espacios, si hay uno vacio te manda un mensaje de error
            if("".equals(idTextField.getText()) || "".equals(nameTextField.getText())
                    || "".equals(creditsTextField.getText()) ){
                
                alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Add Course Sorted Algorithm");
                alert.setHeaderText("There was an error");
                alert.setContentText("Fill ALL the blank spaces");
                alert.show();
                
            }else{
                try{//llenando un objeto student
                    Course s = new Course(idTextField.getText(), nameTextField.getText(),
                            Integer.parseInt(creditsTextField.getText()));
                    courseList = new DoublyLinkedList();//Si es nulo crear uno nuevo
                    courseList.addInSortedList(s);//añadiendo el objeto Student en la lsita
                    util.Utility.setDoublyLinkedList(courseList);
                    //Borrando los text field par aun mjeor control
                    idTextField.setText("");
                    creditsTextField.setText("");
                    nameTextField.setText("");
                    
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Course Sorted Algorithm");
                    alert.setHeaderText("The course add successful");
                    alert.setContentText("Close or add more courses");
                    alert.show();
                    
                }catch(NumberFormatException nfe){
                    creditsTextField.setText("");
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Add Sorted Course Algorithm");
                    alert.setHeaderText("There was an error");
                    alert.setContentText("Invalid character in age field, try again with a number");
                    alert.show();
                }
                
            }
            //SI no esta vacio entonces llenar desde aqui
        }else{
            if("".equals(idTextField.getText()) || "".equals(nameTextField.getText())
                || "".equals(creditsTextField.getText()) ){
                
                alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Add Sorted Course Algorithm");
                alert.setHeaderText("There was an error");
                alert.setContentText("Fill ALL the blank spaces");
                alert.show();
                
                
            }else{
                
                try{//llenando un objeto student
                    Course s = new Course(idTextField.getText(), nameTextField.getText(),
                            Integer.parseInt(creditsTextField.getText()));
                    util.Utility.getDoublyLinkedList().addInSortedList(s);
                    util.Utility.setDoublyLinkedList(util.Utility.getDoublyLinkedList());
                    //Borrando los text field par aun mjeor control
                    idTextField.setText("");
                    creditsTextField.setText("");
                    nameTextField.setText("");
                    
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Add Sorted Course Algorithm");
                    alert.setHeaderText("The student add successful");
                    alert.setContentText("Close or add more students");
                    alert.show();
                    
                }catch(NumberFormatException nfe){
                    creditsTextField.setText("");
                    alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Add Sorted Course Algorithm");
                    alert.setHeaderText("There was an error");
                    alert.setContentText("Invalid character in age field, try again with a number");
                    alert.show();
                }
                
            }
            
        }
    }

    @FXML
    private void bntCloseOnAction(ActionEvent event) {
        FXMLMainMenuController.loadPage(getClass().getResource("FXMLCourse.fxml"), bp);
    }
    
}
