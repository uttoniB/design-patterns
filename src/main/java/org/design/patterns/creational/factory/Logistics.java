package org.design.patterns.creational.factory;

public abstract class Logistics {
    public void planDelivery(){

        final Transport transport = createTransport();
        System.out.println("Planning delivery for transport " + transport);

        transport.deliver();
    }

    public abstract Transport createTransport();
}
