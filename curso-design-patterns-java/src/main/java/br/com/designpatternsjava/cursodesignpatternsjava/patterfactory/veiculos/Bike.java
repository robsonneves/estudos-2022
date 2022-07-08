package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos;

public class Bike implements IVeiculo {

    @Override
    public void startRoute() {
        getCarga();
        System.out.println("Iniciando transporte");
    }

    @Override
    public void getCarga() {
        System.out.println("Pegando sua comida");
    }
}
