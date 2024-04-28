package org.vladislava_g.diplomatestingvm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.vladislava_g.diplomatestingvm.backgroundView.BackgroundUtil;
import org.vladislava_g.diplomatestingvm.firstScene.LoaderSceneUtil;

import java.io.File;
import java.util.List;
import java.util.Objects;


public class TestScene {
    @FXML
    private AnchorPane anchorPaneTest;
    @FXML
    private Button buttonBackTest;
    @FXML
    private AnchorPane anchorPaneQuestion;

    @FXML
    void initialize() {
       initBackground();
       initBackground();
       initButtonBackTest();
       workingTestButtonParse();
    }
    void initBackground() {
        BackgroundUtil.applyBackground(anchorPaneTest, "background/TestMenuPage.jpg");}

    private void initButtonBackTest() {
        buttonBackTest.setOnMouseClicked(mouseEvent -> {
            LoaderSceneUtil.loadScene("hello-view.fxml", "Главное меню");
            ((Stage) buttonBackTest.getScene().getWindow()).close();
        });
    }
    private void workingTestButtonParse(){
        anchorPaneQuestion.getChildren().forEach(object -> {
            if(object instanceof Button button){
                button.setOnAction(actionEvent -> {
                    String buttonText = button.getText();
                    int numberIndex = buttonText.indexOf("№") + 1;

                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = numberIndex; i < buttonText.length(); i++) {
                        stringBuilder.append(buttonText.charAt(i));
                    }
                    openTestParsing(stringBuilder.toString());
                });
            }
        });
    }

    private void openTestParsing(String testNumber){
        File file = new File("tests");
        List<String> fileList = new java.util.ArrayList<>(List.of(Objects.requireNonNull(file.list())));

        String nedentTestFileName = null;

        for(String fileName : fileList){
            if(fileName.contains("test" + testNumber)){
                nedentTestFileName = fileName;
                break;
            }
        }
        parseQuestions("tests/" + nedentTestFileName, testNumber);
    }
    private void parseQuestions(String fileName, String testNumber){
        QuestionsParser questionsParser = new QuestionsParser();

        ContentTest contentTest = (ContentTest) LoaderSceneUtil.loadScene("content-test.fxml", "Тест " + testNumber);
        contentTest.initQuestions(questionsParser.parseQuestions(fileName));

        ((Stage) anchorPaneQuestion.getScene().getWindow()).close();
    }
}
