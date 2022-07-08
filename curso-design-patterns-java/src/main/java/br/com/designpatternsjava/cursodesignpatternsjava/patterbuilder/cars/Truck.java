package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.CarType;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Color;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Engine;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Transmission;

public class Truck {

    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final Color color;

    public Truck(CarType carType, int seats, Engine engine, Transmission transmission, Color color) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
    }

    public  String result(){
        String truck = "Caminhao com motor " + engine.getPower() + "\n";
        truck += " com transmissao " + transmission;
        return truck;
    }
}
