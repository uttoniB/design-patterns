package org.design.patterns.creational.factory;

public class SeaLogistics extends Logistics{
    @Override
    public void planDelivery() {
        super.planDelivery();
    }

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
