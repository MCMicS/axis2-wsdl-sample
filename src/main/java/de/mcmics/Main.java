package de.mcmics;

import de.mcmics.client.TempConvertStub;

import java.rmi.RemoteException;
import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws RemoteException {
        final TempConvertStub tempConvert = new TempConvertStub("https://www.w3schools.com/xml/tempconvert.asmx");
        final String fahrenheit = tempConvert.celsiusToFahrenheit("10");
        log.info("Result is: " + fahrenheit);
    }
}
