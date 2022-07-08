package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.payonner;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public interface IPayneerPayments {

    Token authToken();
    void sendPayment();
    void receivePayment();
}
