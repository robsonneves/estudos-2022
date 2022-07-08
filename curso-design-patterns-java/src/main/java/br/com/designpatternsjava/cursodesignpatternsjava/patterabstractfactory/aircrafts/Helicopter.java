package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.aircrafts;

public class Helicopter implements IAirplane {

    @Override
    public void startRoute() {
        wind();
        getCargo();
        System.out.println("Iniciando a decolagem");
    }

    @Override
    public void getCargo() {
        System.out.println("Passageiros ok, ligando helices");
    }

    @Override
    public void wind() {
        System.out.println("ventos 25km, sudeste, ventos ok");
    }
}
