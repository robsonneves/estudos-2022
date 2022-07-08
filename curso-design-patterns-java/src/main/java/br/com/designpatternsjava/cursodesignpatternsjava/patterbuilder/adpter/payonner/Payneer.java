package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.payonner;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public class Payneer implements IPayneerPayments {

    @Override
    public Token authToken() {
        return new Token();
    }

    @Override
    public void sendPayment() {
        System.out.println("Enviando pagamento via Payoneer");
    }

    @Override
    public void receivePayment() {
        System.out.println("Recebendo pagamento via Payoneer");
    }
}
