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

    }

    @Test
    public void testValidate() {
        MyInscription.setConditionsGeneralesApprouvees(true);
        MyInscription.setEmail("test@test.fr");
        MyInscription.setLogin("test");
        
        boolean valide = true;
        try {
			MyInscription.validate();
		} catch (InscriptionInvalideException e) {
		valide=false;
		}
        
       assertEquals(true, valide);
    }

    @Test
    public void testEmail(){
    	MyInscription.setEmail("test@test.fr");
        assertEquals("test@test.fr",MyInscription.getEmail());
    }

    @Test
    public void testDate() throws InscriptionInvalideException  {
       MyInscription.setConditionsGeneralesApprouvees(true);
       MyInscription.setEmail("test@test.fr");
       MyInscription.setLogin("test");
       MyInscription.validate();
       assertNotNull(MyInscription.getCreation());
    }
    
    @Test
    public void testErreurValidateLogin() {
        MyInscription.setConditionsGeneralesApprouvees(true);
        MyInscription.setEmail("test@test.fr");
        MyInscription.setLogin("");
        
        boolean valide = true;
        try {
			MyInscription.validate();
		} catch (InscriptionInvalideException e) {
		valide=false;
		}
        
       assertEquals(false, valide);
    }
    @Test
    public void testErreurValidateMail() {
        MyInscription.setConditionsGeneralesApprouvees(true);
        MyInscription.setEmail("testtest.fr");
        MyInscription.setLogin("login");
        
        boolean valide = true;
        try {
			MyInscription.validate();
		} catch (InscriptionInvalideException e) {
		valide=false;
		}
        
       assertEquals(false, valide);
    }
    @Test
    public void testErreurValidateApprouve() {
        MyInscription.setConditionsGeneralesApprouvees(false);
        MyInscription.setEmail("test@test.fr");
        MyInscription.setLogin("login");
        
        boolean valide = true;
        try {
			MyInscription.validate();
		} catch (InscriptionInvalideException e) {
		valide=false;
		}
        
       assertEquals(false, valide);
    }
    
    @Test
    public void testLogin()
    {
    MyInscription.setLogin("login");
    assertEquals("login", MyInscription.getLogin());
    }
    
    @Test
    public void testApprouve()
    {
    MyInscription.setConditionsGeneralesApprouvees(true);
    
    assertEquals(true, MyInscription.isConditionsGeneralesApprouvees());
    }
    
    
}
