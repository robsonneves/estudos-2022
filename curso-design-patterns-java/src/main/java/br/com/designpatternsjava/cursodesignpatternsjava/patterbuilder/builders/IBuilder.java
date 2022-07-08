package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.CarType;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Color;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Engine;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Transmission;

public interface IBuilder {

    void setCarType(CarType carType);
    void setSeats(int seats);
    void setTransmission(Transmission transmission);
    void setEngine(Engine engine);
    void setColor(Color color);
}
