package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.director;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders.IBuilder;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.CarType;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Color;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Engine;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.components.Transmission;
import lombok.Builder;

@Builder
public class Director {

    public void contructSedanCar(IBuilder builder){
        Engine engine = Engine.builder().power(16).build();
        builder.setCarType(CarType.SEDAN);
        builder.setSeats(5);
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setEngine(engine);
        builder.setColor(Color.AZUL);
    }
    public void contructTruck(IBuilder builder){
        Engine engine = Engine.builder().power(13000).build();
        builder.setCarType(CarType.TRUCK);
        builder.setSeats(2);
        builder.setTransmission(Transmission.MANUAL);
        builder.setEngine(engine);
        builder.setColor(Color.PRETO);
    }
    public void contructSportCar(IBuilder builder){
        Engine engine = Engine.builder().power(1400).build();
        builder.setCarType(CarType.SPORTCAR);
        builder.setSeats(2);
        builder.setTransmission(Transmission.AUTOMATIC_SEQUENTIAL);
        builder.setEngine(engine);
        builder.setColor(Color.AMARELO);
    }
}
