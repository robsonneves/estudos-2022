package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.mercadoPago;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public class MercadoPago implements IMercadoPago{

    @Override
    public Token authToken() {
        return new Token();
    }

    @Override
    public void enviandoPayment() {
        System.out.println("Enviando com mercado pago");
    }

    @Override
    public void recebendoPayment() {
        System.out.println("Recebendo com mercado pago");
    }
}
