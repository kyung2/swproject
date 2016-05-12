package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.ValueAxis;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button left_load_button;
    @FXML
    private void clickLeftLoadButton(ActionEvent event){
        left_load_button.setText("Click");
    }
    @FXML
    private Button left_edit_button;
    @FXML
    private void clickLeftEditButton(){
        left_edit_button.setText("Click");
    }
    @FXML
    private Button left_save_button;
    @FXML
    private void clickLeftSaveButton(){
        left_save_button.setText("Click");
    }
    @FXML
    private Button right_load_button;
    @FXML
    private void clickRightLoadButton(){
        right_load_button.setText("Click");
    }
    @FXML
    private Button right_edit_button;
    @FXML
    private void clickRightEditButton() { right_edit_button.setText("Click"); }
    @FXML
    private Button right_save_button;
    @FXML
    private void clickRightSaveButton(){
        right_save_button.setText("Click");
    }
    @FXML
    private Button compare_button;
    @FXML
    private void clickCompareButton() { compare_button.setText("Click"); }
    @FXML
    private Button copy_to_left_button;
    @FXML
    private void clickCopyToLeftButton() { copy_to_left_button.setText("Click"); }
    @FXML
    private Button copy_to_right_button;
    @FXML
    private void clickCopyToRightButton() { copy_to_right_button.setText("Click"); }
}
