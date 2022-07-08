package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.adpters;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.mercadoPago.MercadoPago;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.payonner.Payneer;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal.IPayPayments;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal.PayPal;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.utils.Token;

public class MercadoPagoAdapter implements IPayPayments {

    private final MercadoPago mercadoPago;

    public MercadoPagoAdapter(MercadoPago mercadoPago) {
        this.mercadoPago = mercadoPago;
    }

    @Override
    public Token authToken() {
        return new Token();
    }

    @Override
    public void paypalPayment() {
        this.mercadoPago.enviandoPayment();
    }

    @Override
    public void paypalReceive() {
        this.mercadoPago.recebendoPayment();
    }
}
