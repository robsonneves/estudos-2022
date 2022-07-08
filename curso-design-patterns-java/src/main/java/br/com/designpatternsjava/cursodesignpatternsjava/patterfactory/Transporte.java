package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory;

import br.com.designpatternsjava.cursodesignpatternsjava.patterfactory.veiculos.IVeiculo;

public abstract class Transporte {

    public void startTransporte(){
        IVeiculo veiculo = createTransporte();
        veiculo.startRoute();
    }

    protected abstract IVeiculo createTransporte();
}
