import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    String name="Тест";
    float price=32;
    Bun bun = new Bun(name, price);

    @Test
    public void checkGetName() {
        String nameTest = bun.getName();
        assertEquals(nameTest,name);
    }

    @Test
    public void checkGetPrice() {
        float priceTest = bun.getPrice();
        assertEquals(priceTest,price,0.1);
    }
}
