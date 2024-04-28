package org.vladislava_g.diplomatestingvm.firstScene;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.vladislava_g.diplomatestingvm.MainApplication;

import java.io.IOException;

public class LoaderSceneUtil {
    public static Object loadScene(String path, String title){
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(path));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent parent = fxmlLoader.getRoot();
        Scene scene = new Scene(parent);

        Stage stage = new Stage();
        stage.setTitle(title);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        return fxmlLoader.getController();
    }
}
