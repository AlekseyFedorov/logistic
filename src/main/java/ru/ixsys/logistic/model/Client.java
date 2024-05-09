package ru.ixsys.freight.model;

import javafx.beans.property.*;

public class Client {
    //Declare Route Table Columns
    private IntegerProperty route_id;
    private StringProperty sending_address;
    private StringProperty delivery_address;

    //Constructor
    public Client() {
        this.route_id = new SimpleIntegerProperty();
        this.sending_address = new SimpleStringProperty();
        this.delivery_address = new SimpleStringProperty();
    }

    public int getRoute_id() {
        return route_id.get();
    }

    public IntegerProperty route_idProperty() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id.set(route_id);
    }

    public String getSending_address() {
        return sending_address.get();
    }

    public StringProperty sending_addressProperty() {
        return sending_address;
    }

    public void setSending_address(String sending_address) {
        this.sending_address.set(sending_address);
    }

    public String getDelivery_address() {
        return delivery_address.get();
    }

    public StringProperty delivery_addressProperty() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address.set(delivery_address);
    }
}
