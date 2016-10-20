/**
 *
 * @created   Diogo Dantas, Alves Marcos e Higor Anjos
 * @date      20-10-2016
 *
 * @info      descprition
 *
 * */

package dao;

/*
    Imports
*/

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static java.sql.DriverManager.*;

public class PGSQLConnection {

    private Connection connection;
    private String hostname;
    private short port;
    private String database;
    private String username;
    private String password;
    private String url;


    public PGSQLConnection(){

        try {

            Class.forName("org.postgresql.Driver");

            this.hostname = "localhost";
            this.port = 5432;
            this.database = "javabd";
            this.username = "root";
            this.password = "123456";

            this.url = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;

        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

    public boolean establishConnection() {

        try {
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.connection = DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean closeConnection(){
        try {
            System.out.println("Connection closed");
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

        return  true;
    }








}
