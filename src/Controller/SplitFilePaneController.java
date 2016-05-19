package Controller;

import View.AlarmWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

/**
 * Created by woojin on 2016-05-15.
 * FilePanel Controller.
 * has Load, Save, Edit button action.
 * in Load button action, make file chooser.
 */
public class SplitFilePaneController implements Initializable {
    @FXML
    private TextArea left_text_area, right_text_area;
    @FXML
    private Button left_load_button, left_edit_button, left_save_button;
    @FXML
    private Button right_load_button, right_edit_button, right_save_button;
    @FXML
    private SplitPane split_pane;
    @FXML
    private Button compare_button;
    /*
    * 기본적으로 로드 가능. 수정 불가, 저장 불가
    * */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        boolean[] change = {true,true,true};
        ableButtons("right","true","false","false");
        ableButtons("left","true","false","false");
        System.out.println(split_pane);
    }
    /*
    * 파일을 읽어서 내용이 있을 경우 edit 버튼 활성화
    * load 버튼을 누를 경우 파일을 읽어서 text area 에 파일 내용을 적는다.
    * 이미 파일이 있을 경우는 덮어쓰기
    * */
    @FXML
    private void clickLeftLoadButton(){
        fileChooser();

        ableButtons("left","true","true","false");
        System.out.println("Click");
    }
    @FXML
    private void clickRightLoadButton(){
        fileChooser();

        ableButtons("right","true","true","false");
        System.out.println("Click");
    }
    /*
    * 기본은 text area 수정 불가
    * edit 버튼을 클릭하면 수정 가능하게 바꿈
    * edit 이 가능할 때는 edit 와 save 버튼 말고는 모두 비활성화
    * 수정 가능한 상황에서 한 번 더 버튼을 누르면 다시 수정 불가
    * 그 후 비활성화 된 load 버튼을 활성화로
    * */
    @FXML
    private void clickLeftEditButton() {
        boolean edit_flag = left_text_area.isEditable();
        if(edit_flag){
            //수정이 가능할 때 - 누르면 수정이 불가능해짐. 로드는 가능해짐. 모델에 있는 정보를 바꿈
            left_text_area.setEditable(false);

            ableButtons("left","true",null,null);
        }
        else{
            //수정이 불가능 할 때 = 누르면 수정이 가능. 로드 불가능, 저장 가능
            left_text_area.setEditable(true);

            ableButtons("left","false",null,"true");
        }
    }
    @FXML
    private void clickRightEditButton() {
        boolean edit_flag = right_text_area.isEditable();
        if(edit_flag){
            //수정이 가능할 때 - 누르면 수정이 불가능해짐, 로드 불가능, 파일은 저장?
            right_text_area.setEditable(false);

            ableButtons("right","true",null,null);
        }
        else{
            //수정이 불가능 할 때 - 누르면 수정 가능, 로드 불가능, 저장 가능
            right_text_area.setEditable(true);

            ableButtons("right","false",null,"true");
        }
    }
    /*
    * edit 버튼을 눌러서 수정이 가해진 상황 일 경우 save 버튼이 활성화 된다.
    * 수정 사항을 저장한 후에는 로드 가능, 수정 가늗, 저장 불가능으로 된다.
    * */
    @FXML
    private void clickLeftSaveButton(){
        AlarmWindow saveAlarmWindow = new AlarmWindow("Save File Alarm","Would you Save this file?");
        saveAlarmWindow.showAndWait();

        if((boolean)saveAlarmWindow.getUserData()) {
            left_text_area.setEditable(false);

            ableButtons("left","true",null,"false");
        }
    }
    @FXML
    private void clickRightSaveButton(){
        AlarmWindow saveAlarmWindow = new AlarmWindow("Save File Alarm","Would you Save this file?");
        saveAlarmWindow.showAndWait();

        if((boolean)saveAlarmWindow.getUserData()) {
            right_text_area.setEditable(false);

            ableButtons("right","true",null,"false");
        }
    }

    private void fileChooser(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("FileChooser");
        File selectedFile = fileChooser.showOpenDialog(null);
        try{
            System.out.println( selectedFile.getAbsolutePath() );
        }catch (Exception NullPointException){
            System.out.println("No Select FIle");
        }
    }

    /*
    * file pane 버튼의 able 과 disable 을 해준다.
    * position 에 left 와 right 를 통해서 위치를 선택
    * 각각 load, edit, save에 true || false 를 통해서 able 과 disable 을 한다.
    * null 일 경우 그 버튼은 현상 유지
    * */
    private void ableButtons(String position, String load, String edit, String save){
        boolean f_load, f_edit, f_save;
        if(load == "true") f_load = true;
        else f_load = false;

        if(edit == "true") f_edit = true;
        else f_edit = false;

        if(save == "true") f_save = true;
        else f_save = false;

        if(position == "left"){
            if(load != null) left_load_button.setDisable(!f_load);
            if(edit != null) left_edit_button.setDisable(!f_edit);
            if(save != null) left_save_button.setDisable(!f_save);
        }
        else{
            if(load != null) right_load_button.setDisable(!f_load);
            if(edit != null) right_edit_button.setDisable(!f_edit);
            if(save != null) right_save_button.setDisable(!f_save);
        }
    }
}
