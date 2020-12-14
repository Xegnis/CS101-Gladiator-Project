//Essentially the place where the makers can see all the accounts, their gladiators, and their balances.

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

public class PlayerGUI extends Application{

    private TableView<Player> table = new TableView<Player>();
    private ObservableList<Player> data =
            FXCollections.observableArrayList(

            );

    public static void main(String[] args){
            launch(args);
    }

@Override
public void start(Stage stage) throws RuntimeException{
    try {
        Scene scene = new Scene(new Group());
        stage.setTitle("Player GUI");
        stage.setWidth(450);
        stage.setHeight(500);

        Label label = new Label("Players");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn playerIdCol = new TableColumn("Player ID");
        playerIdCol.setMinWidth(100);
        playerIdCol.setCellValueFactory(
                new PropertyValueFactory<Player, Integer>("playerId"));

        TableColumn playerNameCol = new TableColumn("Player Name");
        playerNameCol.setMinWidth(200);
        playerNameCol.setCellValueFactory(
                new PropertyValueFactory<Player, String>("playerName"));

        TableColumn playerGladiatorCol = new TableColumn("Player Gladiators");
        playerGladiatorCol.setMinWidth(200);
        playerGladiatorCol.setCellValueFactory(
                new PropertyValueFactory<Player, String>("playerGladiators"));

        TableColumn playerBalanceCol = new TableColumn("Player Balance");
        playerBalanceCol.setMinWidth(100);
        playerBalanceCol.setCellValueFactory(
                new PropertyValueFactory<Player, Integer>("playerBalance"));

        table.setItems(data);
        table.getColumns().addAll(playerIdCol, playerNameCol, playerGladiatorCol, playerBalanceCol);

        TextField addPlayerId = new TextField();
        addPlayerId.setPromptText("Player ID");
        addPlayerId.setMaxWidth(playerIdCol.getPrefWidth());

        TextField addPlayerName = new TextField();
        addPlayerName.setMaxWidth(playerNameCol.getPrefWidth());
        addPlayerName.setPromptText("Player Name");

        TextField addPlayerGladiators = new TextField();
        addPlayerGladiators.setMaxWidth(playerGladiatorCol.getPrefWidth());
        addPlayerGladiators.setPromptText("Player Gladiators");

        TextField addPlayerBalance = new TextField();
        addPlayerBalance.setPromptText("Player Balance");
        addPlayerBalance.setMaxWidth(playerBalanceCol.getPrefWidth());

        Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                data.add(new Player(Integer.parseInt(addPlayerId.getText()), addPlayerName.getText(),
                        addPlayerGladiators.getText(), Integer.parseInt(addPlayerBalance.getText())
                ));
                addPlayerId.clear();
                addPlayerName.clear();
                addPlayerGladiators.clear();
                addPlayerBalance.clear();
                //Not sure if we are using this, but when the player adds a gladiator, it should also pop up in the gladiators column

            }
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Player selectedItem = table.getSelectionModel().getSelectedItem();
                table.getItems().remove(selectedItem);
            }
        });

        HBox hBox = new HBox();
        hBox.setSpacing(5);

        hBox.getChildren().addAll(addPlayerId, addPlayerName, addPlayerGladiators, addPlayerBalance,
                addButton, deleteButton);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().addAll(label, table, hBox);

        ((Group) scene.getRoot()).getChildren().addAll(vBox);

        stage.setScene(scene);
        stage.show();
    }
    catch(RuntimeException e){
        System.out.println(e);
    }
}

    public static class Player  {

        private SimpleIntegerProperty playerId;
        private SimpleStringProperty playerName;
        private SimpleStringProperty playerGladiators;
        private SimpleIntegerProperty playerBalance;

        public Player(Integer id, String name, String gladiators, Integer balance) {
            this.playerId = new SimpleIntegerProperty(id);
            this.playerName = new SimpleStringProperty(name);
            this.playerGladiators = new SimpleStringProperty(gladiators);
            this.playerBalance = new SimpleIntegerProperty(balance);
        }

        public Integer getPlayerId() {
            return playerId.get();
        }

        public void setPlayerId(Integer id) {
            playerId.set(id);
        }

        public String getPlayerName() {
            return playerName.get();
        }

        public void setPlayerName(String name) {
            playerName.set(name);
        }

        public String getPlayerGladiators() {
            return playerGladiators.get();
        }

        public void setPlayerGladiators(String gladiators) {
            playerGladiators.set(gladiators);
        }

        public Integer getPlayerBalance() {
            return playerBalance.get();
        }

        public void setPlayerBalance(Integer balance) {
            playerBalance.set(balance);
        }
    }
}
