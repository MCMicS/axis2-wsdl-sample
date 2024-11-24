package de.mcmics;

import de.mcmics.client.TempConvertStub;
import org.apache.axis2.AxisFault;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.logging.Logger;

/**
 * Test for Issue AXIS2-6073
 */
class AxisHttpsTest {
    private static final Logger log = Logger.getLogger(AxisHttpsTest.class.getName());

    @Test
    void testHttp() throws RemoteException {
        final TempConvertStub tempConvert = new TempConvertStub("http://www.w3schools.com/xml/tempconvert.asmx");
        Assertions.assertThrows(AxisFault.class, () -> tempConvert.celsiusToFahrenheit("10"));
    }

    @Test
    void testHttps() throws RemoteException {
        final TempConvertStub tempConvert = new TempConvertStub("https://www.w3schools.com/xml/tempconvert.asmx");
        final String fahrenheit = tempConvert.celsiusToFahrenheit("10");
        Assertions.assertEquals("50", fahrenheit);
    }

    @Test
    void testHttpsWithPort() throws RemoteException {
        final TempConvertStub tempConvert = new TempConvertStub("https://www.w3schools.com:443/xml/tempconvert.asmx");
        final String fahrenheit = tempConvert.celsiusToFahrenheit("10");
        Assertions.assertEquals("50", fahrenheit);
    }
}
