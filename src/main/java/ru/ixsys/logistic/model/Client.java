package ru.ixsys.logistic.model;

import javafx.beans.property.*;

public class Client {
    //Declare Client Table Columns
    private IntegerProperty client_id;
    private StringProperty organization_name;
    private StringProperty customer;

    //Constructor
    public Client() {
        this.client_id = new SimpleIntegerProperty();
        this.organization_name = new SimpleStringProperty();
        this.customer = new SimpleStringProperty();
    }

    public int getClient_id() {
        return client_id.get();
    }

    public IntegerProperty client_idProperty() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id.set(client_id);
    }

    public String getOrganization_name() {
        return organization_name.get();
    }

    public StringProperty organization_nameProperty() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name.set(organization_name);
    }

    public String getCustomer() {
        return customer.get();
    }

    public StringProperty customerProperty() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }
}
