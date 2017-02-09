package GUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    /**************************************************
     * Creates objects for each piece of the GUI
     **************************************************/

    ATM ATM1 = new ATM(0,0,0);
    ATM ATM2 = new ATM(0,0,0);
    ATM ATM3 = new ATM(0,0,0);

    /**************************************************
     * instance variables
     **************************************************/

    private int hundredsCount1 = ATM1.getHundreds(),
                fiftiesCount1 = ATM1.getFifties(),
                twentiesCount1 = ATM1.getTwenties();

    private int hundredsCount2 = ATM2.getHundreds(),
                fiftiesCount2 = ATM2.getFifties(),
                twentiesCount2 = ATM2.getTwenties();

    private int hundredsCount3 = ATM3.getHundreds(),
                fiftiesCount3 = ATM3.getFifties(),
                twentiesCount3 = ATM3.getTwenties();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**************************************************
     * FXML Variables
     **************************************************/

    @FXML
    private TextField amount1, amount2, amount3;
    @FXML
    private TextField hundreds1, hundreds2, hundreds3;
    @FXML
    private TextField fifties1, fifties2, fifties3;
    @FXML
    private TextField twenties1, twenties2, twenties3;
    @FXML
    private Label label1Hundreds, label1Fifties, label1Twenties;
    @FXML
    private Label label2Hundreds, label2Fifties, label2Twenties;
    @FXML
    private Label label3Hundreds, label3Fifties, label3Twenties;

    /**************************************************
     * Methods corresponding to GUI.ATM 1 on the GUI
     **************************************************/

    public void PutIn1(){
        int hundredsIn, fiftiesIn, twentiesIn;

        if(ATM.suspend == false){
            hundredsIn = Integer.parseInt(hundreds1.getText());
            fiftiesIn = Integer.parseInt(fifties1.getText());
            twentiesIn = Integer.parseInt(twenties1.getText());

            hundredsCount1 += hundredsIn;
            fiftiesCount1 += fiftiesIn;
            twentiesCount1 += twentiesIn;

            label1Hundreds.setText(Integer.toString(hundredsCount1));
            label1Fifties.setText(Integer.toString(fiftiesCount1));
            label1Twenties.setText(Integer.toString(twentiesCount1));

            ATM1.setHundreds(hundredsCount1);
            ATM1.setFifties(fiftiesCount1);
            ATM1.setTwenties(twentiesCount1);
        }
        else{
            throw new NullPointerException();
        }
    }


    public void TakeOut1(){
        int amountWanted;
        amountWanted = Integer.parseInt(amount1.getText());
        ATM temp = ATM1.takeOut(amountWanted);

        hundredsCount1 -= temp.getHundreds();
        fiftiesCount1 -= temp.getFifties();
        twentiesCount1 -= temp.getTwenties();

        label1Hundreds.setText(Integer.toString(hundredsCount1));
        label1Fifties.setText(Integer.toString(fiftiesCount1));
        label1Twenties.setText(Integer.toString(twentiesCount1));
    }

    /**************************************************
    * Methods corresponding to GUI.ATM 2 on the GUI
    **************************************************/

    public void PutIn2(){
        int hundredsIn, fiftiesIn, twentiesIn;

        if(ATM.suspend == false){
            hundredsIn = Integer.parseInt(hundreds2.getText());
            fiftiesIn = Integer.parseInt(fifties2.getText());
            twentiesIn = Integer.parseInt(twenties2.getText());

            hundredsCount2 += hundredsIn;
            fiftiesCount2 += fiftiesIn;
            twentiesCount2 += twentiesIn;

            label2Hundreds.setText(Integer.toString(hundredsCount2));
            label2Fifties.setText(Integer.toString(fiftiesCount2));
            label2Twenties.setText(Integer.toString(twentiesCount2));

            ATM2.setHundreds(hundredsCount2);
            ATM2.setFifties(fiftiesCount2);
            ATM2.setTwenties(twentiesCount2);
        }
        else{
            throw new NullPointerException();
        }
    }

    public void TakeOut2(){
        int amountWanted;
        amountWanted = Integer.parseInt(amount2.getText());
        ATM temp = ATM2.takeOut(amountWanted);

        hundredsCount2 -= temp.getHundreds();
        fiftiesCount2 -= temp.getFifties();
        twentiesCount2 -= temp.getTwenties();

        label2Hundreds.setText(Integer.toString(hundredsCount2));
        label2Fifties.setText(Integer.toString(fiftiesCount2));
        label2Twenties.setText(Integer.toString(twentiesCount2));
    }


    /**************************************************
    * Methods corresponding to GUI.ATM 3 on the GUI
    **************************************************/

    public void PutIn3(){
        int hundredsIn, fiftiesIn, twentiesIn;

        if(ATM.suspend == false){
            hundredsIn = Integer.parseInt(hundreds3.getText());
            fiftiesIn = Integer.parseInt(fifties3.getText());
            twentiesIn = Integer.parseInt(twenties3.getText());

            hundredsCount3 += hundredsIn;
            fiftiesCount3 += fiftiesIn;
            twentiesCount3 += twentiesIn;

            label3Hundreds.setText(Integer.toString(hundredsCount3));
            label3Fifties.setText(Integer.toString(fiftiesCount3));
            label3Twenties.setText(Integer.toString(twentiesCount3));

            ATM3.setHundreds(hundredsCount3);
            ATM3.setFifties(fiftiesCount3);
            ATM3.setTwenties(twentiesCount3);
        }
        else{
            throw new NullPointerException();
        }
    }

    public void TakeOut3(){
        int amountWanted;
        amountWanted = Integer.parseInt(amount3.getText());
        ATM temp = ATM3.takeOut(amountWanted);

        hundredsCount3 -= temp.getHundreds();
        fiftiesCount3 -= temp.getFifties();
        twentiesCount3 -= temp.getTwenties();

        label3Hundreds.setText(Integer.toString(hundredsCount3));
        label3Fifties.setText(Integer.toString(fiftiesCount3));
        label3Twenties.setText(Integer.toString(twentiesCount3));
    }

    /**************************************************
    * Suspends all takeout and put in methods
    **************************************************/

    public void suspendAll(){
        if(ATM.suspend == false){
            ATM1.suspend(true);
            ATM2.suspend(true);
            ATM3.suspend(true);
        }
        else{
            ATM1.suspend(false);
            ATM2.suspend(false);
            ATM3.suspend(false);
        }
    }

    /**************************************************
     * Close button method
     * Save ATM 1, 2, 3
     * Open ATM 1, 2, 3
     **************************************************/

    public void closeButton(){
        Platform.exit();
    }

    public void saveATM1(){
        ATM1.save("ATM1");
    }

    public void saveATM2(){
        ATM2.save("ATM2");
    }

    public void saveATM3(){
        ATM3.save("ATM3");
    }
    public void openATM1(){
        ATM1.load("ATM1");
        hundredsCount1 = ATM1.getHundreds();
        fiftiesCount1 = ATM1.getFifties();
        twentiesCount1 = ATM1.getTwenties();

        label1Hundreds.setText(Integer.toString(hundredsCount1));
        label1Fifties.setText(Integer.toString(fiftiesCount1));
        label1Twenties.setText(Integer.toString(twentiesCount1));
    }

    public void openATM2(){
        ATM2.load("ATM2");
        hundredsCount2 = ATM2.getHundreds();
        fiftiesCount2 = ATM2.getFifties();
        twentiesCount2 = ATM2.getTwenties();

        label2Hundreds.setText(Integer.toString(hundredsCount2));
        label2Fifties.setText(Integer.toString(fiftiesCount2));
        label2Twenties.setText(Integer.toString(twentiesCount2));
    }

    public void openATM3(){
        ATM3.load("ATM3");
        hundredsCount3 = ATM3.getHundreds();
        fiftiesCount3 = ATM3.getFifties();
        twentiesCount3 = ATM3.getTwenties();

        label3Hundreds.setText(Integer.toString(hundredsCount3));
        label3Fifties.setText(Integer.toString(fiftiesCount3));
        label3Twenties.setText(Integer.toString(twentiesCount3));
    }

}
