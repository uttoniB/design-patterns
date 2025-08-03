package org.design.patterns;

import org.design.patterns.creational.abstractfactory.Chair;
import org.design.patterns.creational.abstractfactory.FurnitureFactory;
import org.design.patterns.creational.abstractfactory.modern.ModernFurnitureFactory;
import org.design.patterns.creational.factory.Logistics;
import org.design.patterns.creational.factory.RoadLogistics;
import org.design.patterns.creational.prototype.Worker;
import org.design.patterns.creational.singleton.DateTimeConverter;
import org.design.patterns.structural.adapter.CircleHole;
import org.design.patterns.structural.adapter.Square;
import org.design.patterns.structural.adapter.SquareAdapter;
import org.design.patterns.structural.bridge.BridgeRunner;
import org.design.patterns.structural.composite.CompositeRunner;
import org.design.patterns.structural.decorator.DecoratorFacade;
import org.design.patterns.structural.flyweight.FlyweightFacade;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------- Factory Method! -------------");
        final Logistics logistics = new RoadLogistics();
        logistics.planDelivery();

        System.out.println("------------- Abstract Factory! -------------");
        final FurnitureFactory furnitureFactory = new ModernFurnitureFactory();
        final Chair chair = furnitureFactory.createChair();
        chair.hasLegs();
        chair.sitOn();

        System.out.println("------------- Prototype! -------------");
        final Worker worker = new Worker("Jheniffer", "HR", "Utips");
        final Worker newWorker = worker.cloneWorker(worker, "Peter");
        System.out.println(newWorker);

        System.out.println("------------- Singleton! -------------");
        final DateTimeConverter dateTimeConverter = DateTimeConverter.getInstance();
        System.out.println("Time now is: " + dateTimeConverter.convertLocalDateTimeToString(LocalDateTime.now()));

        System.out.println("------------- Adapter! -------------");
        final Square bigSquare = new Square(4f);
        final Square littleSquare = new Square(1f);

        final SquareAdapter bigSquareAdapter = new SquareAdapter(bigSquare);
        final SquareAdapter littleSquareAdapter = new SquareAdapter(littleSquare);

        final CircleHole circleHole = new CircleHole(2f);
        circleHole.fitsIn(bigSquareAdapter);
        circleHole.fitsIn(littleSquareAdapter);

        System.out.println("------------- Bridge! -------------");
        final BridgeRunner bridgeRunner = new BridgeRunner();
        bridgeRunner.runBridgeExample();

        System.out.println("------------- Composite! -------------");
        final CompositeRunner compositeRunner = new CompositeRunner();
        compositeRunner.runComposite();

        System.out.println("------------- Decorator & Facade! -------------");
        final DecoratorFacade decoratorFacade = new DecoratorFacade();
        final String message = "$300,00 purchase on amazon. Is that you?";
        decoratorFacade.notifyClient(message);

        System.out.println("------------- Flyweight! -------------");
        final FlyweightFacade flyweightFacade = new FlyweightFacade();
        flyweightFacade.drawTrees();
    }
}