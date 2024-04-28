package org.vladislava_g.diplomatestingvm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.vladislava_g.diplomatestingvm.backgroundView.BackgroundUtil;
import org.vladislava_g.diplomatestingvm.firstScene.LoaderSceneUtil;

import java.util.List;

public class ContentTest {
    @FXML
    private AnchorPane anchorPaneContent;
    @FXML
    private Button buttonBackContent;
    @FXML
    private ScrollPane scrollPaneContent;
    @FXML
    private VBox vboxContent;

    @FXML
    void initialize(){
        initBackground();
        initButtonBackContent();
    }

    void initBackground(){
        BackgroundUtil.applyBackground(anchorPaneContent, "background/DesignOfTestsPage.jpg");
    }

    private void initButtonBackContent(){
        buttonBackContent.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("test-scene.fxml", "Тесты");
            ((Stage) buttonBackContent.getScene().getWindow()).close();
        });
    }
    public void initQuestions(List<Question> questions){

    }
}
