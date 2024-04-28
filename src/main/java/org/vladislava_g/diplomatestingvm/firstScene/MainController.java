package org.vladislava_g.diplomatestingvm.firstScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.vladislava_g.diplomatestingvm.backgroundView.BackgroundUtil;

public class MainController {
    @FXML
    private Pane mainPane;
    @FXML
    private VBox mainVBox;
    @FXML
    private Button buttonTheory;
    @FXML
    private Button buttonLecture;
    @FXML
    private Button buttonTest;

    @FXML
    void initialize (){
        initBackground();
        initButtonTheory();
        initButtonLecture();
        initButtonTest();
    }

    void initBackground(){
        BackgroundUtil.applyBackground(mainPane, "background/MainMenuPage.jpg");
    }
    private void initButtonTheory(){
        buttonTheory.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("theory.fxml", "Теория");
            ((Stage) buttonTheory.getScene().getWindow()).close();
        });
    }
    private void initButtonLecture(){
        buttonLecture.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("lectures.fxml", "Лекции");
            ((Stage) buttonLecture.getScene().getWindow()).close();
        });
    }

    private void initButtonTest(){
        buttonTest.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("test-scene.fxml", "Тесты");
            ((Stage) buttonTest.getScene().getWindow()).close();
        });
    }
}