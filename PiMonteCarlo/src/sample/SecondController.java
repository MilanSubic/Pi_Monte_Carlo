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

public class SecondController extends Controller{

    @FXML
    public Button backButton;

    @FXML
    public Button countButton;

    @FXML
    public TextField decimalNumber;

    @FXML
    public TextArea resultTextArea2;

    public int numberDecimal;


    @FXML
    void countDecimal()
    {
        try {
            numberOfPointsInCircle = 0;
            numberOfPointsInSquare = 0;
            numberOfIterations = 0;
            pi = String.format("%.15f", 0.0);
            numberDecimal = Integer.parseInt(decimalNumber.getText());
            while (!(realPI.substring(0, numberDecimal + 2).equals(String.valueOf(pi).substring(0, numberDecimal + 2)))) {

                x = Math.random();
                y = Math.random();

                if (inCircle(x, y)) {
                    numberOfPointsInCircle++;
                }
                numberOfPointsInSquare++;

                numberOfIterations++;

                pi = String.format("%.15f", (4 * ((double) numberOfPointsInCircle / numberOfPointsInSquare)));

            }
            resultTextArea2.appendText("Pi=" + pi + "       Broj slučajno generisanih vrijednosti za zadatu tačnost: " + numberOfIterations + "\n");
        }
        catch (NumberFormatException exception) { resultTextArea2.appendText("Pogrešno unešena vrijednost.\n");}

    }




    public void backOnMainScene() throws IOException {

        Parent secondPage= FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window= (Stage) backButton.getScene().getWindow();
        window.setTitle("Pi Count");

        window.setScene(new Scene(secondPage, 600, 500));

    }
}
