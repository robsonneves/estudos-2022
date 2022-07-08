package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos;

public class Carro implements IVeiculo {

    @Override
    public void startRoute() {
        getCarga();
        System.out.println("Iniciando o trajeto");
    }

    @Override
    public void getCarga() {
        System.out.println("Pegamos os passageiros, estamos prontos");
    }
}
