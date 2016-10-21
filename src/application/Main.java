package application;

import dao.ClientDAO;
import dao.PGSQLConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Client;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        PGSQLConnection connector = new PGSQLConnection();
        connector.establishConnection();

        ClientDAO clientDAO = new ClientDAO(connector);
        ArrayList<Client> result = new ArrayList<Client>();
        result = clientDAO.readAllClients();


        for(Client t : result){
            System.out.println(t);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
