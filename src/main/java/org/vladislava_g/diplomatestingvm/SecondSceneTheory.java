package org.vladislava_g.diplomatestingvm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.vladislava_g.diplomatestingvm.backgroundView.BackgroundUtil;
import org.vladislava_g.diplomatestingvm.firstScene.LoaderSceneUtil;

public class SecondSceneTheory {
    @FXML
    private AnchorPane theoryAnchorPane;
    @FXML
    private ScrollPane theoryScrollPane;
    @FXML
    private Button buttonBack;

    @FXML
    void initialize (){
        initBackground();
        initButtonBack();
    }
    void initBackground(){
        BackgroundUtil.applyBackground(theoryAnchorPane, "background/FirstPageDiploma.jpg");
    }
    private void initButtonBack(){
        buttonBack.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("hello-view.fxml", "Главное меню");
            ((Stage) buttonBack.getScene().getWindow()).close();
        });
    }
}

