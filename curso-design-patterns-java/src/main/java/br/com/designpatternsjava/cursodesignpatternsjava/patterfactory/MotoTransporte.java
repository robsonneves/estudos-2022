package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory;

import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.IVeiculo;
import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.Moto;

public class MotoTransporte extends Transporte {


    @Override
    protected IVeiculo createTransporte() {
        return new Moto();
    }
}
