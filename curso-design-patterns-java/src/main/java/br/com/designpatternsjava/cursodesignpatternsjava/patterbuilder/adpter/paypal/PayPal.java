package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public class PayPal implements IPayPayments{

    private Token token;

    @Override
    public Token authToken() {
        return new Token();
    }

    @Override
    public void paypalPayment() {
        this.token = authToken();
        System.out.println("Envoando pagamento com PayPal");
    }

    @Override
    public void paypalReceive() {
        System.out.println("Recebendo pagamento via PayPal");
    }
}
