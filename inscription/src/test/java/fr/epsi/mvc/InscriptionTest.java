package fr.epsi.mvc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Alex on 22/04/2014.
 */
public class InscriptionTest {
    Inscription MyInscription;


    @Before
    public void testInitialization(){
        MyInscription = new Inscription();
        MyInscription.setConditionsGeneralesApprouvees(true);
        MyInscription.setEmail("test@test.fr");
        MyInscription.setLogin("test");
    }

    @Test(expected = Exception.class)
    public void testValidate() throws InscriptionInvalideException {

        MyInscription.validate();
    }

    @Test
    public void testEmail(){
        assertEquals("test@test.fr",MyInscription.getEmail());
    }

    @Test
    public void testDate()  {

       assertNotNull(MyInscription.getCreation());
    }
}
