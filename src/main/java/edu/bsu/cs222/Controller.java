package edu.bsu.cs222;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.stream.util.StreamReaderDelegate;

public class Controller extends Application {

    @FXML
    private TextField inputText;
    @FXML
    private RevisionList revisions;
    @FXML
    private TextArea outputText;


    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:\\Users\\Casey Haskins\\IdeaProjects\\twp-raauger-cahaskins\\src\\main\\java\\edu\\bsu\\cs222\\userinterface.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

        // Create the Pane and all Details
        Pane root = loader.load(fxmlStream);

        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Two Week Project");
        // Display the Stage
        stage.show();
    }

    @FXML
    public void createRevisionList(ActionEvent actionEvent) {
        this.revisions = new RevisionList(inputText.getText());
        printOutput();
    }
    @FXML
    public void printOutput(){
        String result = revisions.toString();
        outputText.setText(result);
    }
    public void sortByTime(ActionEvent actionEvent){
        if(revisions.isEmpty()){
            outputText.setText("Please enter a search term so we have a list to sort! ");
        } else{
            revisions.sortByTimestamp();
            printOutput();
        }
    }


}