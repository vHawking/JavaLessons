package Lesson04.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    public javafx.scene.control.DialogPane DialogPane;
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button btn1;

    public void sendMsg() {
        textArea.appendText(textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
        btn1.setVisible(false);
        btn1.setManaged(false);
    }
}
