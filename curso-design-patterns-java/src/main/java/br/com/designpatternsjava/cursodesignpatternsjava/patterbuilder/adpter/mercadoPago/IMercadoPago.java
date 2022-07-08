package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.mercadoPago;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public interface IMercadoPago {

    Token authToken();
    void enviandoPayment();
    void recebendoPayment();
}
