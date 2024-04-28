package org.vladislava_g.diplomatestingvm.backgroundView;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import org.vladislava_g.diplomatestingvm.MainApplication;

import java.util.Objects;

public class BackgroundUtil {
    public static void applyBackground(Pane pane, String imagePath){
        System.out.println(Objects.requireNonNull(MainApplication.class.getResourceAsStream(imagePath)));
        BackgroundImage backgroundImage = new BackgroundImage(new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream(imagePath))), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(backgroundImage));

    }
}
