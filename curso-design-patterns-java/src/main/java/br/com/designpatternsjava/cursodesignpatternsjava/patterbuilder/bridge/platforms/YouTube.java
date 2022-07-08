package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms;

public class YouTube implements IPlatform {

    public YouTube(){
        configureRMTP();
        System.out.println("YouTube: Transmissao Iniciada");
    }

    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("YouTube: Conta autorizada");
    }

    @Override
    public void authToken() {
        System.out.println("YouTube: Autorizando aplicacao");
    }
}
