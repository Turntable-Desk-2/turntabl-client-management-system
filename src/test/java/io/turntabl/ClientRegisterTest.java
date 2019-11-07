package io.turntabl;

import jdk.vm.ci.code.Register;
import org.junit.Test;


import java.util.Arrays;


import static org.junit.Assert.*;

public class ClientRegisterTest {

    @Test
    public void getClientsByName() {
        ClientRegister clientRegister = new ClientRegister(Arrays.asList(
                new Client(101, "Freda", "North Legon D67/54", "023-550-0344", "freda.yeb@gmail.com"),
                new Client(102, "Frederick", "West Legon D67/54", "027-551-2345", "fred.appiah@gmail.com")
        ));
        assertEquals(Arrays.asList(new Client( 101, "Freda", "North Legon D67/54", "023-550-0344", "freda.yeb@gmail.com")), clientRegister.getClientsByName("Freda"));

    }


}