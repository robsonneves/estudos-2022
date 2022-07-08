package br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory;

import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.app.Application;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories.BoatTransporte;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories.ITransporteFactory;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories.NineNineTransporte;
import br.com.designpatternsjava.cursodesignpatternsjava.patterabstractfactory.factories.UberTransporte;

public class MainAbstractFactory {

    public static Application configureApplication(){

        Application app;
        ITransporteFactory factory;

        String company = "teste";

        if(company == "uber"){
            factory = new UberTransporte();
        } else if (company == "99") {
            factory = new NineNineTransporte();
        } else {
            factory = new BoatTransporte();
        }

        app = new Application(factory);
        return app;
    }


    public static void main(String[] args) {

        Application app = configureApplication();
        app.startRoute();
    }

}
