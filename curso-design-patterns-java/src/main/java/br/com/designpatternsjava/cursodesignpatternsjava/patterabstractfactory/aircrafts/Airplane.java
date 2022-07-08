package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.aircrafts;

public class Airplane implements IAirplane {

    @Override
    public void startRoute() {
        wind();
        getCargo();
        System.out.println("Iniciando decolagem");
    }

    @Override
    public void getCargo() {
        System.out.println("Passageiros a bordo, Voo autorizado");
    }

    @Override
    public void wind() {
        System.out.println("Ventos a 25km, ventos ok!");
    }
}
