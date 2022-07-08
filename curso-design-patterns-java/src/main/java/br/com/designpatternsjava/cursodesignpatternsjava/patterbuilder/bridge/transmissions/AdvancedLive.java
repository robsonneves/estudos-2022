package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.transmissions;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.IPlatform;

public class AdvancedLive extends Live{

    public AdvancedLive(IPlatform iPlatform){
        super.platform = iPlatform;
    }

    public void subtitles(){
        System.out.println("Legendas ativadas na transmissao");
    }

    public void comments(){
        System.out.println("Comentarios liberados na live");
    }
}
