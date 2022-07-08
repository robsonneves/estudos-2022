package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.landVehicles;

public class Moto implements ILandVehicle {

    @Override
    public void startRoute() {
        getCargo();
        System.out.println("Iniciando entrega");
    }

    @Override
    public void getCargo() {
        System.out.println("ja pegamos a encomenda");
    }
}
