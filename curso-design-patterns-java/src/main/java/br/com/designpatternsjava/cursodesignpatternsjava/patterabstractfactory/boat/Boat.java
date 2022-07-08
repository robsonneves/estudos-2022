package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.boat;

public class Boat implements IBoat {

    @Override
    public void startRoute() {
        getCargo();
        sea();
        System.out.println("Iniciando navegacao");
    }

    @Override
    public void getCargo() {
        System.out.println("Pegamos a encomenda");
    }

    @Override
    public void sea() {
        System.out.println("Condicoes do mar ok");
    }
}
