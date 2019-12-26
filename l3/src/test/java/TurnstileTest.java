import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.hamcrest.*;
import org.hamcrest.core.*;
import org.hamcrest.core.deprecated.*;

public class TurnstileTest {

    @Test
    public void addNewCard() {
    }

    @Test
    public void topOnCard() throws IOException {
        Turnstile t = new Turnstile();
        for (TravelCard t1: t.cards) {
            if(t1.getType() == Type.common && t1.getNumberOfTravels() != -100){
                int expected = t1.getNumberOfTravels() + 12;
                t.topOnCard(t1.getId(), 12);
                int real = t1.getNumberOfTravels();
                Assert.assertEquals(expected, real);
            }
        }
    }

    @Test
    public void transfer() throws IOException {
        Turnstile t = new Turnstile();
        int expected;
        int id = 2;
        int real;
        if(t.cards.get(id).getNumberOfTravels() != -100){
            if(t.cards.get(id).getNumberOfTravels() != 0)
                real = t.transfer(id);
            else
                real = t.transfer(id) + 1;
            if(t.cards.get(id).getNumberOfTravels() == -100)
                if(t.cards.get(id).checkValidity(new GregorianCalendar()))
                    expected = 1;
                else
                    expected = -1;
            else
                expected = t.cards.get(id).getNumberOfTravels();
            Assert.assertEquals(expected, real);
        }

    }
}