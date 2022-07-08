package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.Facebook;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.IPlatform;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.TwitchTV;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms.YouTube;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.transmissions.AdvancedLive;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.transmissions.Live;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.transmissions.RecordLive;

public class MainBridge {

    public static void main(String[] args) {

        startLive(new YouTube());
        startLive(new TwitchTV());
        startLive(new Facebook());
    }

    public  static  void startLive(IPlatform iPlatform){

        System.out.println(" ... aguarde");
        Live live = new Live(iPlatform);
        live.broadcasting();
        live.result();

        // transmissao avancada
        AdvancedLive advancedLive = new AdvancedLive(iPlatform);
        advancedLive.broadcasting();
        advancedLive.comments();
        advancedLive.subtitles();
        advancedLive.result();

        // record live
        RecordLive recordLive = new RecordLive(iPlatform);
        recordLive.record();
    }
}
