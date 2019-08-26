/*
 * Lingwistyka Matematyczna Zadanie 1 - Automat Deterministyczny - Maszyna wydajaca Kawe i Herbate.
 * Klasa kontrolerska interfejsu graficznego.
 * Szymon Zawadzki 221515.
 */

package automata;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Szaman
 */

public class FXMLDocumentController implements Initializable 
{
    //Pictures Stuff
    Image tea = new Image("automata/pictures/Tea.png");
    ImageView teaImage = new ImageView(tea);
    Image coffee = new Image("automata/pictures/Coffee.png");
    ImageView coffeeImage = new ImageView(coffee);
    Image oneNominal = new Image("automata/pictures/1.png");
    ImageView oneNominalImage = new ImageView(oneNominal);
    Image twoNominal = new Image("automata/pictures/2.png");
    ImageView twoNominalImage = new ImageView(twoNominal);
    Image fiveNominal = new Image("automata/pictures/5.png");
    ImageView fiveNominalImage = new ImageView(fiveNominal);
    Image exit = new Image("automata/pictures/Exit.png");
    ImageView exitImage = new ImageView(exit);
    
    //FXML Stuff
    @FXML
    private Label pathLabel;
    @FXML
    private Label chosenDrink;
    @FXML
    private Label deposit;
    @FXML
    private Button teaButton;
    @FXML
    private Button coffeeButton;
    @FXML
    private Button oneNominalButton;
    @FXML
    private Button twoNominalButton;
    @FXML
    private Button fiveNominalButton;
    @FXML
    private Button exitButton;
    
    //Variables Stuff
    String path = "Ścieżka: Q0";
    
    String currentState;
    String chosenState;
    
    int chosenMainIndex;
    int chosenCurrentIndex;
    
    ArrayList<ArrayList<String>> mainList = new ArrayList<>();
    
    ArrayList<String> currentStateList = new ArrayList<>();
    
    ArrayList<String> q0List = new ArrayList<>();
    ArrayList<String> q1List = new ArrayList<>();
    ArrayList<String> q2List = new ArrayList<>();
    ArrayList<String> q3List = new ArrayList<>();
    ArrayList<String> q4List = new ArrayList<>();
    ArrayList<String> q5List = new ArrayList<>();
    ArrayList<String> q6List = new ArrayList<>();
    ArrayList<String> q7List = new ArrayList<>();
    ArrayList<String> q8List = new ArrayList<>();
    ArrayList<String> q9List = new ArrayList<>();
    ArrayList<String> q10List = new ArrayList<>();
    ArrayList<String> q11List = new ArrayList<>();
    ArrayList<String> q12List = new ArrayList<>();
    ArrayList<String> q13List = new ArrayList<>();
    ArrayList<String> q14List = new ArrayList<>();
    ArrayList<String> q15List = new ArrayList<>();
    ArrayList<String> q16List = new ArrayList<>();
    ArrayList<String> q17List = new ArrayList<>();
    ArrayList<String> q18List = new ArrayList<>();
    ArrayList<String> q19List = new ArrayList<>();
    ArrayList<String> q20List = new ArrayList<>();
    ArrayList<String> q21List = new ArrayList<>();
    ArrayList<String> q22List = new ArrayList<>();
    
    @FXML
    private void handleOneNominalButton(ActionEvent event) 
    {
        chosenCurrentIndex = 0;
        chosenMainIndex = runAutomata(chosenMainIndex, chosenCurrentIndex);
    }
    
    @FXML
    private void handleTwoNominalButton(ActionEvent event) 
    {
        chosenCurrentIndex = 1;
        chosenMainIndex = runAutomata(chosenMainIndex, chosenCurrentIndex);
    }
    
    @FXML
    private void handleFiveNominalButton(ActionEvent event) 
    {
        chosenCurrentIndex = 2;
        chosenMainIndex = runAutomata(chosenMainIndex, chosenCurrentIndex);
    }
    
    @FXML
    private void handleCoffeeButton(ActionEvent event) 
    {
        chosenDrink.setText("Wybrano Kawę");
        chosenCurrentIndex = 3;
        chosenMainIndex = runAutomata(chosenMainIndex, chosenCurrentIndex);
    }
    
    @FXML
    private void handleTeaButton(ActionEvent event) 
    {
        chosenDrink.setText("Wybrano Herbatę");
        chosenCurrentIndex = 4;
        chosenMainIndex = runAutomata(chosenMainIndex, chosenCurrentIndex);
    }
    
    //Skrypt dla guzika Exit.
    @FXML
    public void handleExit()
    {        
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButton = new ButtonType("Anuluj", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", okButton, cancelButton);
        alert.setTitle("Wyjście");
        alert.setHeaderText(null);
        alert.setContentText("Na pewno?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == okButton)
        {
            System.exit(0);
        } 
        else 
        {
            alert.close();
        }
    }
    
    public int runAutomata(int chosenMainIndex, int chosenCurrentIndex)
    {
        currentStateList.clear(); //clear temporary list for new use.
        currentStateList.addAll(mainList.get(chosenMainIndex)); //Copy possible current states pathes list.
        currentState = currentStateList.get(chosenCurrentIndex);
        chosenMainIndex = Integer.parseInt(currentState.replaceAll("\\D+","")); //rip new main index out of current state;
        currentStateList.clear(); //clear temporary list for new use.
        currentStateList.addAll(mainList.get(chosenMainIndex)); //Copy possible current states pathes list.
        path = path + " -> " + currentState;
        pathLabel.setText(path);
        if(currentState.equals("Q0") || currentState.equals("Q1") || currentState.equals("Q13"))
        {
            deposit.setText("");
        }
        else
        {
            if(currentState.equals("Q8") || currentState.equals("Q9") || currentState.equals("Q10") || currentState.equals("Q11") || currentState.equals("Q12") 
               || currentState.equals("Q16") || currentState.equals("Q19") || currentState.equals("Q20") || currentState.equals("Q21") || currentState.equals("Q22"))
            {
                deposit.setText("Wydawanie napoju. Reszta: " + currentStateList.get(5));
            }
            else
            {
                deposit.setText("Wrzucono: " + currentStateList.get(5));
            }
        }
        
        return chosenMainIndex;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //Path initialization
        pathLabel.setText(path);
        
        //Indexes initlialization
        chosenMainIndex = 0;
        chosenCurrentIndex = 0;
        
        //Coffee initialization
        coffeeImage.setFitHeight(75);
        coffeeImage.setFitWidth(75);
        coffeeButton.setGraphic(coffeeImage);
        coffeeButton.setMaxHeight(75);
        coffeeButton.setMaxWidth(75);
        
        //Tea initialization
        teaImage.setFitHeight(75);
        teaImage.setFitWidth(75);
        teaButton.setGraphic(teaImage);
        teaButton.setMaxHeight(75);
        teaButton.setMaxWidth(75);
        
        //OneNominal initialization
        oneNominalImage.setFitHeight(75);
        oneNominalImage.setFitWidth(75);
        oneNominalButton.setGraphic(oneNominalImage);
        oneNominalButton.setMaxHeight(75);
        oneNominalButton.setMaxWidth(75);
        
        //TwoNominal initialization
        twoNominalImage.setFitHeight(75);
        twoNominalImage.setFitWidth(75);
        twoNominalButton.setGraphic(twoNominalImage);
        twoNominalButton.setMaxHeight(75);
        twoNominalButton.setMaxWidth(75);
        
        //FiveNominal initialization
        fiveNominalImage.setFitHeight(75);
        fiveNominalImage.setFitWidth(75);
        fiveNominalButton.setGraphic(fiveNominalImage);
        fiveNominalButton.setMaxHeight(75);
        fiveNominalButton.setMaxWidth(75);
        
        //Exit initialization
        exitImage.setFitHeight(75);
        exitImage.setFitWidth(75);
        exitButton.setGraphic(exitImage);
        exitButton.setMaxHeight(75);
        exitButton.setMaxWidth(75);
        
        //Populate lists
        q0List.addAll(Arrays.asList("Q0", "Q0", "Q0", "Q1", "Q13", ""));
        q1List.addAll(Arrays.asList("Q2", "Q3", "Q4", "Q1", "Q13", ""));
        q2List.addAll(Arrays.asList("Q3", "Q5", "Q6", "Q2", "Q14", "1zł"));
        q3List.addAll(Arrays.asList("Q5", "Q7", "Q8", "Q3", "Q15", "2zł"));
        q4List.addAll(Arrays.asList("Q6", "Q8", "Q12", "Q4", "Q16", "5zł"));
        q5List.addAll(Arrays.asList("Q7", "Q4", "Q10", "Q5", "Q17", "3zł"));
        q6List.addAll(Arrays.asList("Q8", "Q10", "Q11", "Q6", "Q19", "6zł"));
        q7List.addAll(Arrays.asList("Q4", "Q6", "Q9", "Q7", "Q18", "4zł"));
        q8List.addAll(Arrays.asList("Q8", "Q8", "Q8", "Q8", "Q8", "0zł")); //finish
        q9List.addAll(Arrays.asList("Q9", "Q9", "Q9", "Q9", "Q9", "2zł")); //finish
        q10List.addAll(Arrays.asList("Q10", "Q10", "Q10", "Q10", "Q10", "1zł")); //finish
        q11List.addAll(Arrays.asList("Q11", "Q11", "Q11", "Q11", "Q11", "4zł")); //finish
        q12List.addAll(Arrays.asList("Q12", "Q12", "Q12", "Q12", "Q12", "3zł")); //finish
        q13List.addAll(Arrays.asList("Q14", "Q15", "Q16", "Q1", "Q13", ""));
        q14List.addAll(Arrays.asList("Q15", "Q17", "Q19", "Q2", "Q14", "1zł")); 
        q15List.addAll(Arrays.asList("Q17", "Q18", "Q20", "Q3", "Q15", "2zł")); 
        q16List.addAll(Arrays.asList("Q16", "Q16", "Q16", "Q16", "Q6", "0zł")); //finish
        q17List.addAll(Arrays.asList("Q18", "Q16", "Q21", "Q5", "Q17", "3zł"));
        q18List.addAll(Arrays.asList("Q16", "Q19", "Q22", "Q7", "Q18", "4zł")); 
        q19List.addAll(Arrays.asList("Q19", "Q19", "Q19", "Q19", "Q19", "1zł")); //finish
        q20List.addAll(Arrays.asList("Q20", "Q20", "Q20", "Q20", "Q20", "2zł")); //finish
        q21List.addAll(Arrays.asList("Q21", "Q21", "Q21", "Q21", "Q21", "3zł")); //finish
        q22List.addAll(Arrays.asList("Q22", "Q22", "Q22", "Q22", "Q22", "4zł")); //finish
        
        //Add states lists to main list.
        mainList.add(q0List);
        mainList.add(q1List);
        mainList.add(q2List);
        mainList.add(q3List);
        mainList.add(q4List);
        mainList.add(q5List);
        mainList.add(q6List);
        mainList.add(q7List);
        mainList.add(q8List);
        mainList.add(q9List);
        mainList.add(q10List);
        mainList.add(q11List);
        mainList.add(q12List);
        mainList.add(q13List);
        mainList.add(q14List);
        mainList.add(q15List);
        mainList.add(q16List);
        mainList.add(q17List);
        mainList.add(q18List);
        mainList.add(q19List);
        mainList.add(q20List);
        mainList.add(q21List);
        mainList.add(q22List);
    }    
    
}
