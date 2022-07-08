package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.adpters;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.payonner.Payneer;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal.IPayPayments;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public class PayneerAdapter implements IPayPayments {

    private final Payneer payonner;

    public PayneerAdapter(Payneer payneer) {
        this.payonner = payneer;
        System.out.println("Adaptando o payoner ultilizando os metodos padroes do paypal");
    }

    @Override
    public Token authToken() {
        return new Token();
    }

    @Override
    public void paypalPayment() {
        this.payonner.sendPayment();
    }

    @Override
    public void paypalReceive() {
        this.payonner.receivePayment();
    }
}
