package org.vladislava_g.diplomatestingvm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.vladislava_g.diplomatestingvm.backgroundView.BackgroundUtil;
import org.vladislava_g.diplomatestingvm.firstScene.LoaderSceneUtil;

public class SceneLectures {
    @FXML
    private ScrollPane scrollPaneLectures;
    @FXML
    private Button buttonBackLectures;
    @FXML
    private AnchorPane lecturesAnchorPane;

    @FXML
    void initialize() {
        initBackground();
        initButtonBack();
    }

    void initBackground() {
        BackgroundUtil.applyBackground(lecturesAnchorPane, "background/LecturesPage.jpg");}
    private void initButtonBack() {
        buttonBackLectures.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("hello-view.fxml", "Главное меню");
            ((Stage) buttonBackLectures.getScene().getWindow()).close();
        });
    }
}
