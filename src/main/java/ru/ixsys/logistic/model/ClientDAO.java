package ru.ixsys.freight.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.ixsys.freight.util.DBUtil;


import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {

    //*******************************
    //SELECT an Route
    //*******************************
    public static Route searchRoute (String routeId) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM routes WHERE route_id=" + routeId;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Route route = getRouteFromResultSet(rsEmp);

            //Return route object
            return route;
        } catch (SQLException e) {
            System.out.println("While searching an employee with " + routeId + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
    private static Route getRouteFromResultSet(ResultSet rs) throws SQLException
    {
        Route route = null;
        if (rs.next()) {
            route = new Route();
            route.setRoute_id(rs.getInt("ROUTE_ID"));
            route.setSending_address(rs.getString("SENDING_ADDRESS"));
            route.setDelivery_address(rs.getString("DELIVERY_ADDRESS"));
        }
        return route;
    }

    //*******************************
    //SELECT Employees
    //*******************************
    public static ObservableList<Route> searchRoutes () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM routes";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsRoutes = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Route> routeList = getRouteList(rsRoutes);

            //Return employee object
            return routeList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<Route> getRouteList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
         ObservableList<Route> routeList = FXCollections.observableArrayList();

        while (rs.next()) {
            Route route = new Route();
            route.setRoute_id(rs.getInt("ROUTE_ID"));
            route.setSending_address(rs.getString("SENDING_ADDRESS"));
            route.setDelivery_address(rs.getString("delivery_address"));
            //Add employee to the ObservableList
            routeList.add(route);
        }
        //return empList (ObservableList of Employees)
        return routeList;
    }

    //*************************************
    //UPDATE an route
    //*************************************
    public static void updateRoute (String routeId, String sending_address, String delivery_address) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt ="UPDATE routes SET sending_address = '" + sending_address + "', delivery_address = '" + delivery_address +"' WHERE route_id = " + routeId + ";";
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //DELETE an route
    //*************************************
    public static void deleteEmpWithId (String routeId) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "DELETE FROM routes WHERE route_id = " + routeId +";";
        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT an route
    //*************************************
    public static void insertRoute (String sending_address, String delivery_address) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt = "INSERT INTO freight.routes (route_id, sending_address, delivery_address) VALUES\n" +
                        "(0, '"+sending_address+"', '"+delivery_address+"');";
        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }
}
