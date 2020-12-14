import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.application.Application;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Training extends Application{
    TableView<Trainer> table = new TableView<Trainer>();
    Trainer[] glads = {new Trainer(2, 5),new Trainer(2, 5),
            new Trainer(2, 5)};
// So right now this is hardcoded, but ideally this would take the gladiators that the user has and use that for the observable List on line 35. Then they
    //could choose to upgrade one of those gladiators. 

    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<String> data =
                FXCollections.observableArrayList("Gladiator 1", "Gladiator 2",
                        "Gladiator 3");
        ListView<String> listView = new ListView<String>(data);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        FlowPane tablePane = new FlowPane(10,10);
        BorderPane pane = new BorderPane();
        pane.setLeft(new ScrollPane(listView));
        pane.setCenter(tablePane);

        TableColumn gladOldSpeed = new TableColumn("Gladiator Previous Speed");
        gladOldSpeed.setMinWidth(100);
        gladOldSpeed.setCellValueFactory(
                new PropertyValueFactory<Trainer, Integer>("oldSpeed"));

        TableColumn gladOldStrength = new TableColumn("Player Previous Strength ");
        gladOldStrength.setMinWidth(200);
        gladOldStrength.setCellValueFactory(
                new PropertyValueFactory<Trainer, Integer>("oldStrength"));

        TableColumn gladNewSpeed = new TableColumn("Gladiator New Speed");
        gladNewSpeed.setMinWidth(100);
        gladNewSpeed.setCellValueFactory(
                new PropertyValueFactory<Trainer, Integer>("newSpeed"));

        TableColumn gladNewStrength = new TableColumn("Gladiator New Strength ");
        gladNewStrength.setMinWidth(200);
        gladNewStrength.setCellValueFactory(
                new PropertyValueFactory<Trainer, Integer>("newStrength"));

        table.getColumns().addAll(gladOldSpeed, gladOldStrength, gladNewSpeed, gladNewStrength);

        listView.getSelectionModel().selectedItemProperty().addListener(ov ->{
            tablePane.getChildren().clear();
            for (Integer i: listView.getSelectionModel().getSelectedIndices()) {
                ObservableList<Trainer> dataGlad =
                        FXCollections.observableArrayList(glads[i]);
                table.setItems(dataGlad);
                tablePane.getChildren().add(table);
                
                //This should then increase the stats of those gladiators that we use
            }
        });

        Scene scene = new Scene(pane, 450, 170);
        stage.setTitle("Gladiator Training"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show();
    }
    public static class Trainer{
        private SimpleIntegerProperty oldSpeed;
        private SimpleIntegerProperty oldStrength;
        private SimpleIntegerProperty newSpeed;
        private SimpleIntegerProperty newStrength;

        public Trainer(Integer oldSpeed, Integer oldStrength){
            this.oldSpeed = new SimpleIntegerProperty(oldSpeed);
            this.oldStrength = new SimpleIntegerProperty(oldStrength);
            this.newSpeed = new SimpleIntegerProperty(getOldSpeed()+5);
            this.newStrength = new SimpleIntegerProperty(getOldStrength() +5);
        }

        public Integer getOldSpeed() {
            return this.oldSpeed.get();
        }

        public Integer getOldStrength() {
            return this.oldStrength.get();
        }
        public Integer getNewSpeed(){
            return this.newSpeed.get();
        }
        public Integer getNewStrength(){
            return this.newStrength.get();
        }
    }

}
