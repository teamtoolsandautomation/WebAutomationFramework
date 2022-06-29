package com.ttaa.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtil {

    public static Connection Open(String connectionstring){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            return DriverManager.getConnection(connectionstring);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Close(){

    }

    public static void ExecuteQuery(String query, Connection connection) {

        try {
            Statement stmt;
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
