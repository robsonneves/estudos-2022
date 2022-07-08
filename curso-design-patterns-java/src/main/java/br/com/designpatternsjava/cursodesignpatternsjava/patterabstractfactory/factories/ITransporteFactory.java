package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories;

import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.aircrafts.IAirplane;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.boat.IBoat;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.landVehicles.ILandVehicle;

public interface ITransporteFactory {
    ILandVehicle createTransporteVihicle();
    IAirplane createTransporteAircraft();
    IBoat createTransporteBoat();
}
