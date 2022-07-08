package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms;

public class TwitchTV implements IPlatform {

    public TwitchTV(){
        configureRMTP();
        System.out.println("TwitchTV: Transmissao Iniciada");
    }

    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("TwitchTV: Conta autorizada");
    }

    @Override
    public void authToken() {
        System.out.println("TwitchTV: Autorizando aplicacao");
    }
}
