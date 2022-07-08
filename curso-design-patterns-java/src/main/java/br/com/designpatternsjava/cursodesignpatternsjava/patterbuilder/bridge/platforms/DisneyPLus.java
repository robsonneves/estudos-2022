package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.bridge.platforms;

public class DisneyPLus implements IPlatform {

    public DisneyPLus(){
        configureRMTP();
        System.out.println("DisneyPLus: Transmissao Iniciada");
    }

    @Override
    public void configureRMTP() {
        authToken();
        System.out.println("DisneyPLus: Conta autorizada");
    }

    @Override
    public void authToken() {
        System.out.println("DisneyPLus: Autorizando aplicacao");
    }
}
