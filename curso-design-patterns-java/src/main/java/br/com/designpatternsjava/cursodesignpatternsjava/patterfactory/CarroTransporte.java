package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory;

import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.Carro;
import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.IVeiculo;

public class CarroTransporte extends Transporte {

    @Override
    protected IVeiculo createTransporte() {
        return new Carro();
    }
}
