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
    private TableView<Recruiter> table = new TableView<Recruiter>();

    private ObservableList<Recruiter> data =
            FXCollections.observableArrayList(
                new Recruiter("1","Gladiator 1", "Fighter", 100),
                    new Recruiter("2","Gladiator 2", "Animal", 50),
                    new Recruiter("3","Gladiator 3", "Special Fighter", 200)
            );
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Recruitment");
        stage.setWidth(500);
        stage.setHeight(500);

        Label label = new Label("Gladiators");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn gladiatorNumCol = new TableColumn("Gladiator Number");
        gladiatorNumCol.setMinWidth(200);
        gladiatorNumCol.setCellValueFactory(new PropertyValueFactory<Recruiter, String>("numGlad"));

        TableColumn gladiatorNameCol = new TableColumn("Gladiator Name");
        gladiatorNameCol.setMinWidth(200);
        gladiatorNameCol.setCellValueFactory(new PropertyValueFactory<Recruiter, String>("nameGlad"));

        TableColumn gladiatorDescriptionCol = new TableColumn("Gladiator Description");
        gladiatorDescriptionCol.setMinWidth(200);
        gladiatorDescriptionCol.setCellValueFactory(new PropertyValueFactory<Recruiter, String>("descriptionGlad"));

        TableColumn gladiatorCostCol = new TableColumn("Gladiator Cost");
        gladiatorCostCol.setMinWidth(200);
        gladiatorCostCol.setCellValueFactory(new PropertyValueFactory<Recruiter, String>("costGlad"));

        table.setItems(data);
        table.getColumns().addAll(gladiatorNumCol, gladiatorNameCol, gladiatorDescriptionCol, gladiatorCostCol);

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
    public static class Recruiter{
        private SimpleStringProperty numGlad;
        private SimpleStringProperty nameGlad;
        private SimpleStringProperty descriptionGlad;
        private SimpleIntegerProperty costGlad;

        public Recruiter(String numGlad, String nameGlad, String descriptionGlad, Integer costGlad){
            this.numGlad = new SimpleStringProperty(numGlad);
            this.nameGlad = new SimpleStringProperty(nameGlad);
            this.descriptionGlad = new SimpleStringProperty(descriptionGlad);
            this.costGlad = new SimpleIntegerProperty(costGlad);
        }

    }
}
