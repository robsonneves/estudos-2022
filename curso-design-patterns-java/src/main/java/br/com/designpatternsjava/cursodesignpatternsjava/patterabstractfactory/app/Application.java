package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.app;

import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.aircrafts.IAirplane;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.boat.IBoat;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories.ITransporteFactory;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.landVehicles.ILandVehicle;

public class Application {

    private ILandVehicle vehicle;
    private IAirplane airplane;
    private IBoat iBoat;

    public Application(ITransporteFactory factory){
        vehicle = factory.createTransporteVihicle();
        airplane = factory.createTransporteAircraft();
        iBoat = factory.createTransporteBoat();
    }

    public void startRoute(){
        vehicle.startRoute();
        airplane.startRoute();
        iBoat.startRoute();
    }
}
