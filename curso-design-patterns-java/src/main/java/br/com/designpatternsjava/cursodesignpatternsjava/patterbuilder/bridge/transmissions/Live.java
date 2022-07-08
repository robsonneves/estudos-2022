package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.transmissions;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.IPlatform;

public class Live implements ITransmission {

    protected IPlatform platform;

    public Live(){

    }

    public Live(IPlatform iPlatform){
        this.platform = iPlatform;
    }

    @Override
    public void broadcasting() {
        System.out.println("Iniciando transmissao !");
    }

    @Override
    public void result() {
        System.out.println("******* ON AIR ******");
    }
}
