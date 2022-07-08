package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory;

import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.Bike;
import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.IVeiculo;

public class BikeTransporte extends Transporte {
    @Override
    protected IVeiculo createTransporte() {
        return new Bike();
    }
}
