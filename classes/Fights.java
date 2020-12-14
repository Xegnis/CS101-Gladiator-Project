import com.sun.tools.javac.util.Name;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fights extends Application {
    private TableView<String> table = new TableView<String>();
    private ObservableList<Fighters> data =
            FXCollections.observableArrayList(

            );

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws RuntimeException {
        try {
            Scene scene = new Scene(new Group());
            stage.setTitle("Fights GUI");
            stage.setWidth(500);
            stage.setHeight(500);
            String log = GBSimulator.log;

            Label label = new Label("Fights");
            label.setFont(new Font("Arial", 20));

            table.setEditable(true);

            TableColumn<String, String> resultCol = new TableColumn<>("Battle Result");
            resultCol.setMinWidth(200);
            resultCol.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue()));

            table.getColumns().add(resultCol);
            ObservableList<String> data = FXCollections.observableArrayList(log);
            table.setItems(data);


            TextField addGladiator1 = new TextField();
            addGladiator1.setPromptText("Gladiator 1");
            addGladiator1.setMaxWidth(addGladiator1.getPrefWidth());

            TextField addGladiator2 = new TextField();
            addGladiator2.setMaxWidth(addGladiator2.getPrefWidth());
            addGladiator2.setPromptText("Gladiator 2");


            Button addButton = new Button("Add");
            addButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {

                    String name1 = addGladiator1.getText();
                    String name2 = addGladiator2.getText();
                    addGladiator1.clear();
                    addGladiator2.clear();

                    Fighter f1 = null, f2 = null;

                    for (int i = 0; i < GBSimulator.fighters.length; i ++)
                    {
                        if (GBSimulator.fighters[i].getName().equals(name1))
                        {
                            f1 = GBSimulator.fighters[i];
                        }
                        else if (GBSimulator.fighters[i].getName().equals(name2))
                        {
                            f2 = GBSimulator.fighters[i];
                        }
                    }

                    GBSimulator.battle(f1, f2);
                }
            });

            GBSimulator.clearLog();


            HBox hBox = new HBox();
            hBox.setSpacing(5);

            hBox.getChildren().addAll(addGladiator1, addGladiator2, addButton);

            VBox vBox = new VBox();
            vBox.setSpacing(5);
            vBox.setPadding(new Insets(10, 0, 0, 10));
            vBox.getChildren().addAll(label, table, hBox);

            ((Group) scene.getRoot()).getChildren().addAll(vBox);

            stage.setScene(scene);
            stage.show();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    public static class Fighters {
        private SimpleStringProperty gladiator1;
        private SimpleStringProperty versus;
        private SimpleStringProperty gladiator2;

        public Fighters(String gladiator1, String gladiator2) {
            this.gladiator1 = new SimpleStringProperty(gladiator1);
            this.versus = new SimpleStringProperty("vs");
            this.gladiator2 = new SimpleStringProperty(gladiator2);
        }

        public String getGladiator1() {
            return this.gladiator1.get();
        }

        public String getVersus() {
            return this.versus.get();
        }

        public String getGladiator2() {
            return this.gladiator2.get();
        }
    }

}