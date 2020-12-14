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
public class Fights extends Application {
    private TableView<Fighters> table = new TableView<Fighters>();
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

            Label label = new Label("Fights");
            label.setFont(new Font("Arial", 20));
            
            GBSimulator.readData();

            table.setEditable(true);

            TableColumn gladiator1Col = new TableColumn("Gladiator 1");
            gladiator1Col.setMinWidth(100);
            gladiator1Col.setCellValueFactory(
                    new PropertyValueFactory<PlayerGUI.Player, Integer>("gladiator1"));

            TableColumn versusCol = new TableColumn("Versus");
            versusCol.setMinWidth(200);
            versusCol.setCellValueFactory(
                    new PropertyValueFactory<PlayerGUI.Player, String>("versus"));

            TableColumn gladiator2Col = new TableColumn("Gladiator 2");
            gladiator2Col.setMinWidth(200);
            gladiator2Col.setCellValueFactory(
                    new PropertyValueFactory<PlayerGUI.Player, String>("gladiator2"));

            table.setItems(data);
            table.getColumns().addAll(gladiator1Col, versusCol, gladiator2Col);

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
