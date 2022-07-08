package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars.Car;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.CarType;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Color;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Engine;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Transmission;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class CarBuilder implements IBuilder{

    private CarType carType;
    private int seats;
    private Transmission transmission;
    private Engine engine;
    private Color color;

    public Car getResult(){
        return new br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars.Car(
                carType,
                seats,
                engine,
                transmission,
                color);
    }
}
