/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domain.Course;
import domain.DoublyLinkedList;
import domain.ListException;
import domain.Student;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
 * @author Maria Celeste
 */
public class FXMLCourseController implements Initializable {
    private DoublyLinkedList courseList;
    private Alert alert;

    @FXML
    private BorderPane bp;
    @FXML
    private Button btnAdd;
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
    @FXML
    private TableColumn<Course, String> idTableColumn;
    @FXML
    private TableColumn<Course, String> nameTableColumn;
    @FXML
    private TableView<Course> courseTableVIew;
    @FXML
    private TableColumn<Course, Integer> creditsTableColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         this.courseList = util.Utility.getDoublyLinkedList(); //cargo la lista
        idTableColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        creditsTableColumn.setCellValueFactory(new PropertyValueFactory<>("Credits"));
     
        try{
            if(courseList!=null && !courseList.isEmpty()){
                for(int i=1; i<=courseList.size(); i++) {
                    courseTableVIew.getItems().add((Course)courseList.getNode(i).data);
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
        FXMLMainMenuController.loadPage(getClass().getResource("FXMLAddCourse.fxml"), bp);
    }

    @FXML
    private void btnAddFirstOnAction(ActionEvent event) {
         FXMLMainMenuController.loadPage(getClass().getResource("FXMLAddFirstCourse.fxml"), bp);
    }

    @FXML
    private void btnAddSortedOnAction(ActionEvent event) {
         FXMLMainMenuController.loadPage(getClass().getResource("FXMLAddCourseSorted.fxml"), bp);
        
    }

    @FXML
    private void btnContainsOnAction(ActionEvent event) {
        
         TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Course - Contains");
        dialog.setHeaderText("Enter the ID to search: ");
        Optional<String> id = dialog.showAndWait();
        
        dialog.setTitle("Course - Contains");
        dialog.setHeaderText("Enter the name to search:");
        Optional<String> name = dialog.showAndWait();
        
        
            
        if(!id.isPresent()||id.get().compareTo("") == 0 
            && !name.isPresent()||name.get().compareTo("") == 0   ) {
                 alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setTitle("Course Algorithm - Contains");
                 alert.setHeaderText("The list doesn't contains the element");
                 alert.show();
                      
        }else{
                 
             try {
                 Course c = new Course(id.get(),name.get() , 0);
                 if(util.Utility.getDoublyLinkedList().contains(c)){
                   alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("Course Algorithm - Contains");
                     alert.setHeaderText("The list contains: ");
                     alert.setContentText(c.toString());
                     alert.show();
                 }else{
                     alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.ERROR);
                     alert.setTitle("Course Algorithm - Contains");
                     alert.setHeaderText("The list doesn't contains the element");
                     alert.show();

                 }
             } catch (ListException ex) {
                 alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setTitle("Course Algorithm - Contains");
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
                     alert.setTitle("Course Algorithm - Size");
                     alert.setContentText( "Size: "+String.valueOf(courseList.size()));
                     alert.show();
            
        } catch (ListException ex) {
             alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.ERROR);
                     alert.setTitle("Course Algorithm - Size");
                     alert.setHeaderText(ex.getMessage());
                     alert.show();
            //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnRemoveOnAction(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Course - Remove");
        dialog.setHeaderText("Enter the ID to remove:");
        Optional<String> id = dialog.showAndWait();
        
        dialog.setTitle("Course - Remove");
        dialog.setHeaderText("Enter the name to remove:");
        Optional<String> name = dialog.showAndWait();
        
     
        if(!id.isPresent()||id.get().compareTo("") == 0 &&
           !name.isPresent()||name.get().compareTo("") == 0 ) {
                 alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.ERROR);
                 alert.setTitle("Course Algorithm - Remove");
                 alert.setHeaderText("The element doesn't exists");
                 alert.show();
          
        }else{
                 
            try {
             courseList.remove(new Course(id.get(),name.get(),0));
             util.Utility.setDoublyLinkedList(courseList);
                courseTableVIew.getItems().clear();
                if(util.Utility.getDoublyLinkedList()!=null && !util.Utility.getDoublyLinkedList().isEmpty()){
                    for(int i=1; i<= util.Utility.getDoublyLinkedList().size(); i++) {
                        courseTableVIew.getItems().add((Course)util.Utility.getDoublyLinkedList().getNode(i).data);
                            }
                        }
                       alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("Course Algorithm - Remove");
                     alert.setHeaderText("The element was removed");
                     alert.show();
            }catch (ListException ex) {
                     alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.ERROR);
                     alert.setTitle("Course Algorithm - Remove");
                     alert.setHeaderText(ex.getMessage());
                     alert.show();
                     
                     //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
                 }
         }
    }

    @FXML
    private void btnRemoveFirstOnAction(ActionEvent event) {
        try {

             courseList.removeFirst();
             util.Utility.setDoublyLinkedList(courseList);
                courseTableVIew.getItems().clear();
                if(util.Utility.getDoublyLinkedList()!=null && !util.Utility.getDoublyLinkedList().isEmpty()){
                    for(int i=1; i<= util.Utility.getDoublyLinkedList().size(); i++) {
                        courseTableVIew.getItems().add((Course)util.Utility.getDoublyLinkedList().getNode(i).data);
                            }
                        }
                       alert = new Alert(Alert.AlertType.NONE);
                     alert.setAlertType(Alert.AlertType.INFORMATION);
                     alert.setTitle("Course Algorithm - RemoveFirst");
                     alert.setHeaderText("The first element was removed");
                     alert.show();
        }catch (ListException ex) {
             alert = new Alert(Alert.AlertType.NONE);
             alert.setAlertType(Alert.AlertType.ERROR);
             alert.setTitle("Course Algorithm - RemoveFirst");
             alert.setHeaderText(ex.getMessage());
             alert.show();
             //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnClearOnAction(ActionEvent event) {
        courseList.clear();
        util.Utility.setDoublyLinkedList(courseList);
        courseTableVIew.getItems().clear();
    }

    @FXML
    private void btnGetLastOnAction(ActionEvent event) {
         try {
            alert = new Alert(Alert.AlertType.NONE);
                 alert.setAlertType(Alert.AlertType.CONFIRMATION);
                 alert.setTitle("Course Algorithm - GetLast");
                 alert.setHeaderText( "Last: "+String.valueOf(courseList.getLast()));
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
                 alert.setTitle("Course Algorithm - GetFirst");
                 alert.setHeaderText( "First: "+String.valueOf(courseList.getFirst()));
                 alert.show();
           
        } catch (ListException ex) {
            alert = new Alert(Alert.AlertType.NONE);
             alert.setAlertType(Alert.AlertType.ERROR);
             alert.setTitle("Course Algorithm - GetFirst");
             alert.setHeaderText(ex.getMessage());
             alert.show();
            //Logger.getLogger(FXMLStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
