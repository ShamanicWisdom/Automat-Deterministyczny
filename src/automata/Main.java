/*
 * Lingwistyka Matematyczna Zadanie 1 - Automat Deterministyczny - Maszyna wydajaca Kawe i Herbate.
 * Szymon Zawadzki 221515.
 */

package automata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Szaman
 */
public class Main extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Automat Deterministyczny - Wydawanie Napojów");
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
}
