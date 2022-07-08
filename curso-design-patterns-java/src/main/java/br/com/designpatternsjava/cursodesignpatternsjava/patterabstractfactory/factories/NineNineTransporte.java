package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories;

import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.aircrafts.Helicopter;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.aircrafts.IAirplane;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.boat.Boat;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.boat.IBoat;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.landVehicles.ILandVehicle;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.landVehicles.Moto;

public class NineNineTransporte implements ITransporteFactory {

    @Override
    public ILandVehicle createTransporteVihicle() {
        return new Moto();
    }

    @Override
    public IAirplane createTransporteAircraft() {
        return new Helicopter();
    }

    @Override
    public IBoat createTransporteBoat() {
        return new Boat();
    }
}
