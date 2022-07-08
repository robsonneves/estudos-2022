package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars.SportCar;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.CarType;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Color;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Engine;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Transmission;
import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class SportCarBuilder  implements IBuilder{

    private CarType carType;
    private int seats;
    private Transmission transmission;
    private Engine engine;
    private Color color;

    public SportCar getResult(){
        return new SportCar(
                carType,
                seats,
                engine,
                transmission,
                color);
    }
}
