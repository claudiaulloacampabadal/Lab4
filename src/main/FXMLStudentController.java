/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package main;

import domain.ListException;
import domain.SinglyLinkedList;
import domain.Student;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class FXMLStudentController implements Initializable {
    private SinglyLinkedList studentList;
    private Alert alert;
    
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private BorderPane bp;
    @FXML
    private TableColumn<Student, String> idTableColumn;
    @FXML
    private TableColumn<Student, String> nameTableColumn;
    @FXML
    private TableColumn<Student, Integer> ageTableColumn;
    @FXML
    private TableColumn<Student, String> addressTableColumn;
    @FXML
    private Button btnAddFirst;
    @FXML
    private Button btnAddSorted;
    @FXML
    private Button btnContains;
    @FXML
    private Button btnSize;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnRemoveFirst;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnGetLast;
    @FXML
    private Button btnGetFirst;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.studentList = util.Utility.getSinglyLinkedList(); //cargo la lista
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ageTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        try{
            if(studentList!=null && !studentList.isEmpty()){
                for(int i=1; i<=studentList.size(); i++) {
                    studentTableView.getItems().add((Student)studentList.getNode(i).data);
                }
            }
        }catch(ListException ex){
            //Mostrar la excepción: Student list is empty
            alert = new Alert(Alert.AlertType.NONE);
            alert.setHeaderText("Add Student Algorithm");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }    

    @FXML
    private void btnAddOnAction(ActionEvent event) {
        FXMLMainMenuController.loadPage(getClass().getResource("FXMLAddStudent.fxml"), bp);
    }

    @FXML
    private void btnAddFirstOnAction(ActionEvent event) {
        FXMLMainMenuController.loadPage(getClass().getResource("FXMLAddFirstStudent.fxml"), bp);
    }

    @FXML
    private void btnAddSortedOnAction(ActionEvent event) {
         FXMLMainMenuController.loadPage(getClass().getResource("FXMLAddSortedStudent.fxml"), bp);
    }

    @FXML
    private void btnContainsOnAction(ActionEvent event) {
        
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Student - Contains");
        dialog.setHeaderText("Enter the ID to search: ");
        Optional<String> id = dialog.showAndWait();
        
        dialog.setTitle("Student - Contains");
        dialog.setHeaderText("Enter the name to search:");
        Optional<String> name = dialog.showAndWait();
        
        
            
        if(!id.isPresent()||id.get().compareTo("") == 0 
            && !name.isPresent()||name.get().compareTo("") == 0   ) {
                 alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setTitle("Student Algorithm - Contains");
                 alert.setHeaderText("The list doesn't contains the element");
                 alert.show();
                      
        }else{
                 
             try {
                 Student s = new Student(id.get(),name.get() , 0, "");
                 if(util.Utility.getSinglyLinkedList().contains(s)){
                   alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("Student Algorithm - Contains");
                     alert.setHeaderText("The list contains: ");
                     alert.setContentText(s.toString());
                     alert.show();
                 }else{
                     alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.ERROR);
                     alert.setTitle("Student Algorithm - Contains");
                     alert.setHeaderText("The list doesn't contains the element");
                     alert.show();

                 }
             } catch (ListException ex) {
                 alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setTitle("Student Algorithm - Contains");
                 alert.setHeaderText(ex.getMessage());
                 alert.show();

                 //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
        
    }

    @FXML
    private void btnSizeOnAction(ActionEvent event) {
        try {
             alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.CONFIRMATION);
                     alert.setTitle("Student Algorithm - Size");
                     alert.setHeaderText( "Size: "+String.valueOf(studentList.size()));
                     alert.show();
            
        } catch (ListException ex) {
             alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.ERROR);
                     alert.setTitle("Student Algorithm - Size");
                     alert.setHeaderText(ex.getMessage());
                     alert.show();
            //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Boton para remover
    @FXML
    private void btnRemoveOnAction(ActionEvent event) {
         TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Student - Remove");
        dialog.setHeaderText("Enter the ID to remove:");
        Optional<String> id = dialog.showAndWait();
        
        dialog.setTitle("Student - Remove");
        dialog.setHeaderText("Enter the name to remove:");
        Optional<String> name = dialog.showAndWait();
        
     
        if(!id.isPresent()||id.get().compareTo("") == 0 &&
           !name.isPresent()||name.get().compareTo("") == 0 ) {
                 alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setTitle("Student Algorithm - Remove");
                 alert.setHeaderText("The element doesn't exists");
                 alert.show();
          
        }else{
                 
            try {
             studentList.remove(new Student(id.get(),name.get(),0,""));
             util.Utility.setSinglyLinkedList(studentList);
                studentTableView.getItems().clear();
                if(util.Utility.getSinglyLinkedList()!=null && !util.Utility.getSinglyLinkedList().isEmpty()){
                    for(int i=1; i<= util.Utility.getSinglyLinkedList().size(); i++) {
                        studentTableView.getItems().add((Student)util.Utility.getSinglyLinkedList().getNode(i).data);
                            }
                        }
                       alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("Student Algorithm - Remove");
                     alert.setHeaderText("The element was removed");
                     alert.show();
            }catch (ListException ex) {
                     alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.ERROR);
                     alert.setTitle("Student Algorithm - Remove");
                     alert.setHeaderText(ex.getMessage());
                     alert.show();
                     
                     //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
                 }
         }
        
    
    }

    @FXML
    private void btnRemoveFirstOnAction(ActionEvent event) {
        try {

             studentList.removeFirst();
             util.Utility.setSinglyLinkedList(studentList);
                studentTableView.getItems().clear();
                if(util.Utility.getSinglyLinkedList()!=null && !util.Utility.getSinglyLinkedList().isEmpty()){
                    for(int i=1; i<= util.Utility.getSinglyLinkedList().size(); i++) {
                        studentTableView.getItems().add((Student)util.Utility.getSinglyLinkedList().getNode(i).data);
                            }
                        }
                       alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("Student Algorithm - RemoveFirst");
                     alert.setHeaderText("The first element was removed");
                     alert.show();
        }catch (ListException ex) {
             alert = new Alert(Alert.AlertType.NONE);
             alert.setAlertType(Alert.AlertType.ERROR);
             alert.setTitle("Student Algorithm - RemoveFirst");
             alert.setHeaderText(ex.getMessage());
             alert.show();
             //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnClearOnAction(ActionEvent event) {
        studentList.clear();
        util.Utility.setSinglyLinkedList(studentList);
        studentTableView.getItems().clear();
    }

    @FXML
    private void btnGetLastOnAction(ActionEvent event) {
        try {
            alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Student Algorithm - GetLast");
                 alert.setHeaderText( "Last: "+String.valueOf(studentList.getLast()));
                 alert.show();
           
        } catch (ListException ex) {
            alert = new Alert(Alert.AlertType.NONE);
             alert.setAlertType(Alert.AlertType.ERROR);
             alert.setTitle("Course Algorithm - GetLast");
             alert.setHeaderText(ex.getMessage());
             alert.show();
            //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           
    }

    @FXML
    private void btnGetFirstOnAction(ActionEvent event) {
        
         try {
            alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Student Algorithm - GetFirst");
                 alert.setHeaderText( "First: "+String.valueOf(studentList.getFirst()));
                 alert.show();
           
        } catch (ListException ex) {
            alert = new Alert(Alert.AlertType.NONE);
             alert.setAlertType(Alert.AlertType.ERROR);
             alert.setTitle("Student Algorithm - GetFirst");
             alert.setHeaderText(ex.getMessage());
             alert.show();
            //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
