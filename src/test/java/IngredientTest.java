import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type,String name,float price) {
        this.type=type;
        this.name=name;
        this.price=price;
    }

    @Parameterized.Parameters
    public static Object[] getData() {
        return new Object[][] {
                {SAUCE,"Помидор",12},
                {FILLING,"Лук",15},
        };
    }

    Ingredient ingredient;
    @Before
    public void set() {
        ingredient=new Ingredient(type,name,price);
    }

    @Test
    public void checkGetPrice() {
        float testPrice=ingredient.getPrice();
        assertEquals(testPrice,price,0.1);
    }

    @Test
    public void checkGetName() {
        String testName=ingredient.getName();
        assertEquals(testName,name);
    }

    @Test
    public void checkGetType() {
        IngredientType testType=ingredient.getType();
        assertEquals(testType,type);
    }
}
