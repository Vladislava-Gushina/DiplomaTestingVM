module org.vladislava_g.diplomatestingvm {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens org.vladislava_g.diplomatestingvm to javafx.fxml;
    opens org.vladislava_g.diplomatestingvm.firstScene to javafx.fxml;
    exports org.vladislava_g.diplomatestingvm;

}