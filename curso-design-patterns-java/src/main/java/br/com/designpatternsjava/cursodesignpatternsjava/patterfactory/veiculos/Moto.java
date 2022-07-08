package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos;

public class Moto implements IVeiculo {
    @Override
    public void startRoute() {
        getCarga();
        System.out.println("Iniciando trajeto");
    }

    @Override
    public void getCarga() {
        System.out.println("Pegando a encomenda");
    }
}
