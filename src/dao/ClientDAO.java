package dao;

/**
 * Created by diogodantas on 20/10/16.
 */

import model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAO {

    private PGSQLConnection connector;

    public ClientDAO(PGSQLConnection connector){
        this.connector = connector;
    }

    public ArrayList<Client> readAllClients(){

        ArrayList<Client> Clients = new ArrayList<>();

        try{
            String Query = "SELECT * FROM client";

            PreparedStatement statement = connector.getConnection().prepareStatement(Query);
            ResultSet resultQuery = statement.executeQuery();

            while(resultQuery.next()){
                Client aux = new Client();

                aux.setId(resultQuery.getInt("id"));
                aux.setName(resultQuery.getString("name"));
                aux.setDateOfBirth(resultQuery.getString("birth"));
                aux.setPhone(resultQuery.getString("phone"));
                aux.setAmountSpent(resultQuery.getDouble("amountSpent"));
                aux.setBalance(resultQuery.getDouble("balance"));

                Clients.add(aux);
            }

            return Clients;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }
}
