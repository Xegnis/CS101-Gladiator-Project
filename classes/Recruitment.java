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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class Recruitment extends  Application{
    private TableView<Recruiter> table = new TableView<>();
    private Recruiter[] recruiters = {new Recruiter("Gladiator", "Agility: 4, Strength: 5, " +
            "Endurance: 6, Intelligence:7"), new Recruiter("Gladiator", "Agility: 5, Strength: 3, Endurance:" +
            "4, Intelligence:6"), new Recruiter("Hoplomachus", "Agility: 4, Strength" +
            ": 7, Endurance: 5, Intelligence: 3")};
    private ObservableList<Recruiter> data =
FXCollections.observableArrayList(
                     recruiters[0], recruiters[1], recruiters[2]
            );

    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Recruitment");
        stage.setWidth(500);
        stage.setHeight(500);

        Label label = new Label("Gladiators");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn gladiatorNameCol = new TableColumn("Gladiator Type");
        gladiatorNameCol.setMinWidth(200);
        gladiatorNameCol.setCellValueFactory(new PropertyValueFactory<Fighter,
               String>("nameGlad"));

        TableColumn gladiatorAttrCol = new TableColumn("Attributes");
        gladiatorAttrCol.setMinWidth(400);
        gladiatorAttrCol.setCellValueFactory(new PropertyValueFactory<Fighter,String>
                ("descriptionGlad"));


        table.setItems(data);
        table.getColumns().addAll(gladiatorNameCol, gladiatorAttrCol);

        Button buyGlad1 = new Button("Buy Gladiator 1");
        buyGlad1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //Whatever we need to do

            }
        });

        Button buyGlad2 = new Button("Buy Gladiator 2");
        buyGlad1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //Whatever we need to do

            }
        });

        Button buyGlad3 = new Button("Buy Gladiator 3");
        buyGlad1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

               //Whatever we need to do

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
        private SimpleStringProperty nameGlad;
        private SimpleStringProperty descriptionGlad;

        public Recruiter(String nameGlad, String descriptionGlad){
            this.nameGlad = new SimpleStringProperty(nameGlad);
            this.descriptionGlad = new SimpleStringProperty(descriptionGlad);
        }

        public String getNameGlad() {
            return nameGlad.get();
        }

        public String getDescriptionGlad() {
            return descriptionGlad.get();
        }
    }
}
