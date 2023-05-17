package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    public Button countButton;

    @FXML
    public Button changeButton;

    @FXML
    public TextArea resultTextArea;

    @FXML
    public TextField iterationsNumber;



    protected double x;
    protected double y;
    protected String pi=String.format("%.15f",0.0);
    protected String realPI=String.valueOf(Math.PI);
    public long numberOfIterations;

    public int numberOfPointsInCircle=0;
    public int numberOfPointsInSquare=0;







    public boolean inCircle(double x, double y)
    {
        return Math.pow(x, 2) + Math.pow(y, 2) <= 1;

    }

    public String countMethod() {
       try{

            numberOfIterations = Long.parseLong(iterationsNumber.getText());
            for (int i = 0; i < numberOfIterations; i++) {
                x = Math.random();

                y = Math.random();

                if (inCircle(x, y)) {
                    numberOfPointsInCircle++;
                }
                numberOfPointsInSquare++;

            }
            pi = String.valueOf(4 * ((double) numberOfPointsInCircle / numberOfPointsInSquare));
            resultTextArea.appendText("Pi=" + pi + "\n");


        }
       catch (NumberFormatException exception) { resultTextArea.appendText("Pogrešno unešena vrijednost.\n");}
       return pi;
    }



    public void changeScane() throws IOException {

        Parent secondPage= FXMLLoader.load(getClass().getResource("secondScene.fxml"));
        Stage window= (Stage) changeButton.getScene().getWindow();
        window.setTitle("Pi Count");
        window.setScene(new Scene(secondPage, 600, 500));


    }



}
