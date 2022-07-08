package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.transmissions;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.IPlatform;

public class RecordLive extends Live{

    public RecordLive(IPlatform iPlatform){
        super.platform = iPlatform;
    }

    public void record(){
        System.out.println("Gravando Live");
    }
}
