import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import sun.jvm.hotspot.jdi.ArrayReferenceImpl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Recruitment extends  Application{
    private TableView<String> table = new TableView<>();

    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Recruitment");
        stage.setWidth(800);
        stage.setHeight(500);

        Label label = new Label("Gladiators");
        label.setFont(new Font("Arial", 20));

        GBSimulator.fillWithGladiators(3);
        GBSimulator.generateRecruits();

        table.setEditable(true);
        String recruit1 = GBSimulator.recruits[0].toString();
        String recruit2 = GBSimulator.recruits[1].toString();
        String recruit3 = GBSimulator.recruits[2].toString();

        TableColumn<String, String> gladiatorsCol = new TableColumn("Gladiators");
        gladiatorsCol.setMinWidth(200);
        gladiatorsCol.setCellValueFactory(param ->  new ReadOnlyStringWrapper(param.getValue()));

        table.getColumns().add(gladiatorsCol);

        ObservableList<String> data = FXCollections.observableArrayList(recruit1, recruit2, recruit3);
        table.setItems(data);


        Button buyGlad1 = new Button("Buy Gladiator 1 | Cost: 100");
        buyGlad1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GBSimulator.recruit(0);
                GBSimulator.clearLog();
            }
        });

        Button buyGlad2 = new Button("Buy Gladiator 2 | Cost: 100");
        buyGlad1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GBSimulator.recruit(1);
                GBSimulator.clearLog();
            }
        });

        Button buyGlad3 = new Button("Buy Gladiator 3 | Cost: 100");
        buyGlad1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                GBSimulator.recruit(2);
                GBSimulator.clearLog();
            }
        });

        HBox hBox = new HBox();
        hBox.setSpacing(5);

        hBox.getChildren().addAll(buyGlad1, buyGlad2, buyGlad3);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().addAll(label, table, hBox);

        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();
    }
    public class Recruiter{

    }
}