package br.com.designpatternsjava.cursodesignpatternsjava.patterfactory;

public class MainPatterFactory {

    private static Transporte transporte;

    public static void main(String[] args) {

        configure(args[0]);
        if(transporte != null){
            runTransporte();
        }
    }

    private static void runTransporte(){
        transporte.startTransporte();
    }

    private static void configure(String type) {
        switch (type){
            case "Uber":
                transporte = new CarroTransporte();
                break;
            case "log":
                transporte = new MotoTransporte();
            case "its":
                transporte = new BikeTransporte();
            default:
                System.out.println("Selecione o tipo de entrega");
        }
    }
}
