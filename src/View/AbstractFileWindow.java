package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Abstract class for Open and Save file window
 * This class make stage with parameter ( title and controller file )
 * It is designed by FileWindow.fxml file in /View/Fxml package
 * It has two label, two text area, two button for open or left and right file
 * Created by woojin on 2016-05-18.
 *
 * @author woojin Jang
 */
abstract class AbstractFileWindow extends Stage {

    /**
     * Constructure
     *
     * @param title          Title for file window
     * @param controllerFile controller object for file window
     */
    protected AbstractFileWindow(String title, Object controllerFile) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Fxml/FileWindow.fxml"));
        loader.setController(controllerFile);

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        this.setTitle(title);
        this.setScene(scene);
        this.getIcons().add(new Image("/View/Image/mainIcon.png"));
    }

    /**
     * Init label.
     */
    abstract protected void initLabel();

    /**
     * Get window label label.
     *
     * @return the label
     */
/* get component in file window */
    protected Label getWindowLabel(){
        return (Label)(((AnchorPane)this.getScene().getRoot()).getChildren().get(7));
    }

    /**
     * Get right file label label.
     *
     * @return the label
     */
    protected Label getRightFileLabel(){
        return (Label)(((AnchorPane)this.getScene().getRoot()).getChildren().get(0));
    }

    /**
     * Get left file label label.
     *
     * @return the label
     */
    protected Label getLeftFileLabel(){
        return (Label)(((AnchorPane)this.getScene().getRoot()).getChildren().get(1));
    }

    /**
     * Get warning info text area text field.
     *
     * @return the text field
     */
    protected TextField getWarningInfoTextArea(){
        return (TextField) (((AnchorPane)this.getScene().getRoot()).getChildren().get(2));
    }

    /**
     * Get right file text area text field.
     *
     * @return the text field
     */
    protected TextField getRightFileTextArea(){
        return (TextField) (((AnchorPane)this.getScene().getRoot()).getChildren().get(3));
    }

    /**
     * Get left file text area text field.
     *
     * @return the text field
     */
    protected TextField getLeftFileTextArea(){
        return (TextField) (((AnchorPane)this.getScene().getRoot()).getChildren().get(4));
    }

    /**
     * Get right file find button button.
     *
     * @return the button
     */
    protected Button getRightFileFindButton(){
        return (Button)(((AnchorPane)this.getScene().getRoot()).getChildren().get(5));
    }

    /**
     * Get left file find button button.
     *
     * @return the button
     */
    protected Button getLeftFileFindButton(){
        return (Button)(((AnchorPane)this.getScene().getRoot()).getChildren().get(6));
    }

    /**
     * Get ok button button.
     *
     * @return the button
     */
    protected Button getOkButton(){
        return (Button)(((AnchorPane)this.getScene().getRoot()).getChildren().get(8));
    }

    /**
     * Get cancel button button.
     *
     * @return the button
     */
    protected Button getCancelButton(){
        return (Button)(((AnchorPane)this.getScene().getRoot()).getChildren().get(9));
    }
}
