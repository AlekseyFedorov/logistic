package ru.ixsys.logistic.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.ixsys.logistic.model.Client;
import ru.ixsys.logistic.model.ClientDAO;

import java.sql.SQLException;
import java.util.concurrent.Executor;

public class ClientsController {

    @FXML
    private TextField clientIdText;

    @FXML
    private TextField organizationNameText;

    @FXML
    private TextField customerText;

    @FXML
    public Button getAllRoutesBtn;

    @FXML
    private TableView<Client> clientsTable;

    @FXML
    private TableColumn<Client, Integer> clientIdColumn;

    @FXML
    private TableColumn<Client, String>  clientOrganizationName;

    @FXML
    private TableColumn<Client, String>  clientCustomer;

    //For MultiThreading
    private Executor exec;

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.

    @FXML
    private void initialize () throws SQLException, ClassNotFoundException {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */

        //For multithreading: Create executor that uses daemon threads:
//        exec = Executors.newCachedThreadPool((runnable) -> {
//            Thread t = new Thread (runnable);
//            t.setDaemon(true);
//            return t;
//        });

        clientIdColumn.setCellValueFactory(cellData -> cellData.getValue().client_idProperty().asObject());
        clientOrganizationName.setCellValueFactory(cellData -> cellData.getValue().organization_nameProperty());
        clientCustomer.setCellValueFactory(cellData -> cellData.getValue().customerProperty());

        getAllClients(new ActionEvent());
    }

    //Search an client
    @FXML
    public void searchClient(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get client information
            Client client = ClientDAO.searchClient(clientIdText.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
//            resultArea.setText("Error occurred while getting employee information from DB.\n" + e);
            throw e;
        }

    }

    //Search all clients
    @FXML
    public void getAllClients(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Clients information
            ObservableList<Client> clientsData = ClientDAO.searchClients();
            //Populate Employees on TableView
            populateClients(clientsData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }

    //Populate Client
    @FXML
    private void populateClient (Client client) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Client> clientData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        clientData.add(client);
        //Set items to the employeeTable
        clientsTable.setItems(clientData);
    }


    //Populate Routes for TableView
    @FXML
    private void populateClients (ObservableList<Client> clientsData) throws ClassNotFoundException {
        //Set items to the RoutesTable
        clientsTable.setItems(clientsData);
    }

    //Populate Client for TableView
    @FXML
    private void populateAndShowClient(Client client) throws ClassNotFoundException {
        if (client != null) {
            populateClient(client);
//            setEmpInfoToTextArea(emp);
        } else {
//            resultArea.setText("This employee does not exist!\n");
            System.out.println("This client does not exist!\n");
        }
    }

    //Update client's
//    @FXML
//    public void updateRoute(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        try {
//            RouteDAO.updateRoute(routeIdText.getText(), routeSendingAddressText.getText(), routeDeliveryAddressText.getText());
//            System.out.println("Email has been updated for, employee id: " + routeIdText.getText() + "\n");
//            getAllRoutes(new ActionEvent());
//        } catch (SQLException e) {
//            System.out.println("Problem occurred while updating email: " + e);
//        }
//    }

    //Delete an route with a given employee Id from DB
//    @FXML
//    public void deleteRoute(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
//        try {
//            RouteDAO.deleteEmpWithId(routeIdText.getText());
//            System.out.println("Employee deleted! Employee id: " + routeIdText.getText() + "\n");
//            getAllRoutes(new ActionEvent());
//        } catch (SQLException e) {
//            System.out.println("Problem occurred while deleting employee " + e);
//            throw e;
//        }
//    }

    //Insert an client to the DB
    @FXML
    public void insertClient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            ClientDAO.insertClient(clientIdText.getText(), organizationNameText.getText(), customerText.getText());
            System.out.println("Route inserted! \n");
            getAllClients(new ActionEvent());
        } catch (SQLException e) {
//            resultArea.setText("Problem occurred while inserting employee " + e);
            System.out.println("Problem occurred while inserting employee " + e);
            throw e;
        }
    }
}
