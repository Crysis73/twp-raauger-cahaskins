package edu.bsu.cs222;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Objects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller extends Application {

    @FXML
    public TextArea outputText;
    @FXML
    private TextField inputText;
    @FXML
    private RevisionList revisions;
    @FXML
    private AuthorList authors;
    @FXML
    private Scene scene;
    @FXML
    private Stage window;


    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "C:\\Users\\Casey Haskins\\IdeaProjects\\twp-raauger-cahaskins\\src\\test\\resources\\userinterface.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        Pane root = loader.load(fxmlStream);
        scene = new Scene(root);
        window.setScene(scene);
        window.setTitle("Two Week Project");
        window.show();
    }


    public void createRevisionList(ActionEvent actionEvent){
        try {
            this.revisions = new RevisionList(inputText.getText());
            String output = revisions.toString();
            printOutput(output);
        }catch(NullPointerException e){
            printOutput("No articles matching \"" +inputText.getText() + "\" were found. Please check your spelling and try again.");
        }
    }
    private void printOutput(String output){
        outputText.setText(output);
    }
    public void sortByNumberOfEdits(ActionEvent actionEvent){
        try {
            this.authors = new AuthorList(inputText.getText());
        }catch(NullPointerException e){
            printOutput("Please search for an article before trying to sort!");
        }
        String output = authors.toString();
        outputText.setText("");
        printOutput(output);
    }
    public void clearAllText(ActionEvent actionEvent) {
        inputText.setText("");
        outputText.setText("");
        this.authors = null;
        this.revisions = null;
    }

}