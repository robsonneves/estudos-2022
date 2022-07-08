package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.CarType;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Color;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Engine;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Transmission;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Car {

    private final CarType carType;
    private final int seats;
    private final Engine engine;
    private final Transmission transmission;
    private final Color color;

    public Car(CarType carType, int seats, Engine engine, Transmission transmission, Color color) {
        this.carType = carType;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
    }
}
