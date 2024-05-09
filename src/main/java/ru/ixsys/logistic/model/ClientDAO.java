package ru.ixsys.logistic.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.ixsys.logistic.util.DBUtil;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {

    //*******************************
    //SELECT an Client
    //*******************************
    public static Client searchClient (String clientId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM clients WHERE client_id=" + clientId;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsClient = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get client object
            Client client = getClientFromResultSet(rsClient);

            //Return route object
            return client;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + clientId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Client Object's attributes and return client object.
    private static Client getClientFromResultSet(ResultSet rs) throws SQLException
    {
        Client client = null;
        if (rs.next()) {
            client = new Client();
            client.setClient_id(rs.getInt("CLIENT_ID"));
            client.setOrganization_name(rs.getString("ORGANIZATION_NAME"));
            client.setCustomer(rs.getString("CUSTOMER"));
        }
        return client;
    }

    //*******************************
    //SELECT Clients
    //*******************************
    public static ObservableList<Client> searchClients () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM clients";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsClients = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Client> clientList = getClientList(rsClients);

            //Return employee object
            return clientList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from clients operation
    private static ObservableList<Client> getClientList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Client objects
         ObservableList<Client> clientList = FXCollections.observableArrayList();

        while (rs.next()) {
            Client client = new Client();
            client.setClient_id(rs.getInt("CLIENT_ID"));
            client.setOrganization_name(rs.getString("ORGANIZATION_NAME"));
            client.setCustomer(rs.getString("CUSTOMER"));
            //Add Client to the ObservableList
            clientList.add(client);
        }
        //return empList (ObservableList of Employees)
        return clientList;
    }

//    //*************************************
//    //UPDATE an route
//    //*************************************
//    public static void updateRoute (String routeId, String sending_address, String delivery_address) throws SQLException, ClassNotFoundException {
//        //Declare a UPDATE statement
//        String updateStmt ="UPDATE routes SET sending_address = '" + sending_address + "', delivery_address = '" + delivery_address +"' WHERE route_id = " + routeId + ";";
//        //Execute UPDATE operation
//        try {
//            DBUtil.dbExecuteUpdate(updateStmt);
//        } catch (SQLException e) {
//            System.out.print("Error occurred while UPDATE Operation: " + e);
//            throw e;
//        }
//    }
//
//    //*************************************
//    //DELETE an route
//    //*************************************
//    public static void deleteEmpWithId (String routeId) throws SQLException, ClassNotFoundException {
//        //Declare a DELETE statement
//        String updateStmt = "DELETE FROM routes WHERE route_id = " + routeId +";";
//        //Execute UPDATE operation
//        try {
//            DBUtil.dbExecuteUpdate(updateStmt);
//        } catch (SQLException e) {
//            System.out.print("Error occurred while DELETE Operation: " + e);
//            throw e;
//        }
//    }
//
    //*************************************
    //INSERT an client
    //*************************************
    public static void insertClient (String client_id, String organization_name, String customer) throws SQLException, ClassNotFoundException {

        String updateStmt = "INSERT INTO logistics.clients (client_id, organization_name, customer) VALUES\n" +
                        "('"+client_id+"', '"+organization_name+"', '"+customer+"');";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
