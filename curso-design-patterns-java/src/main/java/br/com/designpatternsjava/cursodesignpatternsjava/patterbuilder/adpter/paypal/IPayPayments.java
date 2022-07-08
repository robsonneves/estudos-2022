package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public interface IPayPayments {

    Token authToken();
    void paypalPayment();
    void paypalReceive();

}
