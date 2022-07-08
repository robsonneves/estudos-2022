package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders.CarBuilder;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders.SportCarBuilder;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.builders.TruckBuilder;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars.Car;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars.SportCar;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.cars.Truck;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.director.Director;

public class MainBuilder {

    public static void main(String[] args) {

        Director director = Director.builder().build();
        CarBuilder builder = CarBuilder.builder().build();
        director.contructSedanCar(builder);

        Car car = builder.getResult();

        System.out.println(car.getCarType() + " produzido com sucesso !");

        TruckBuilder truckBuilder = TruckBuilder.builder().build();
        director.contructSportCar(truckBuilder);

        Truck truck = truckBuilder.getResult();
        //System.out.println(truck + " produzido com sucesso !");

        SportCarBuilder sportCarBuilder = SportCarBuilder.builder().build();
        director.contructSportCar(sportCarBuilder);

        SportCar sportCar = sportCarBuilder.getResult();
        System.out.println(sportCar.result() + " produzido com sucesso !");
    }
}
