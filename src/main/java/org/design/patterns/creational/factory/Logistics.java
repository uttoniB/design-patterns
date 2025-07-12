package org.design.patterns.creational.factory;

public abstract class Logistics {
    public void planDelivery(){

        //Would have to create a transport here, but we can use createTransport for that
        final Transport transport = createTransport();
        System.out.println("Planning delivery for transport " + transport);

        transport.deliver();
    }

    public abstract Transport createTransport();
}
