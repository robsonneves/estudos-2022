package br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter;

import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.adpters.MercadoPagoAdapter;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.adpters.PayneerAdapter;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.mercadoPago.IMercadoPago;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.mercadoPago.MercadoPago;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.payonner.IPayneerPayments;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.payonner.Payneer;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal.IPayPayments;
import br.com.designpatternsjava.cursodesignpatternsjava.patterbuilder.adpter.paypal.PayPal;

public class MainAdpter {

    public static void main(String[] args) {

        IPayPayments payment = new PayPal();
        payment.paypalPayment();
        payment.paypalReceive();

        IPayPayments payment2 = new PayneerAdapter(new Payneer());
        payment2.paypalPayment();
        payment2.paypalReceive();

        IPayPayments payment3 = new MercadoPagoAdapter(new MercadoPago());
        payment3.paypalPayment();
        payment3.paypalReceive();


//        IPayPayments payment = new PayPal();
//        payment.paypalPayment();
//        payment.paypalReceive();

//        IPayneerPayments payment = new Payneer();
//
//        payment.sendPayment();
//        payment.receivePayment();

    }
}
