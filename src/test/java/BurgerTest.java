import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void checkSetBuns() {
        Burger burger=new Burger();
        burger.setBuns(bun);
        assertEquals(burger.bun,bun);
    }

    @Test
    public void checkAddIngredient() {
        Burger burger=new Burger();
        burger.addIngredient(ingredient);
        assertEquals(burger.ingredients.get(0),ingredient);
    }
    @Test
    public void checkRemoveIngredient() {
        Burger burger=new Burger();
        Ingredient ingredient1=new Ingredient(SAUCE,"кетчуп",100);
        int countBefore=burger.ingredients.size();
        burger.addIngredient(ingredient1);

        burger.removeIngredient(0);
        int countAfter=burger.ingredients.size();

        assertEquals(countBefore,countAfter);
    }

    @Test
    public void checkMoveIngredient() {
        Burger burger=new Burger();
        Ingredient ingredient1=new Ingredient(SAUCE,"кетчуп",100);
        Ingredient ingredient2=new Ingredient(FILLING,"помидор",200);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        int index = burger.ingredients.indexOf(ingredient1);
        int newIndex=1;
        burger.moveIngredient(index,newIndex);
        int indexAfter = burger.ingredients.indexOf(ingredient1);
        assertEquals(newIndex,indexAfter);
    }

    @Test
    public void checkGetPrice() {
        Burger burger=new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(2));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(2));
        assertEquals(6, burger.getPrice(),0.1);
    }

    @Test
    public void checkGetReceipt() {
        Burger burger=new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("Тестовое название");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Тестовый ингридиент");
        Mockito.when(bun.getPrice()).thenReturn(Float.valueOf(2));
        Mockito.when(ingredient.getPrice()).thenReturn(Float.valueOf(2));
        String testReceipt= "(==== Тестовое название ====)\r\n= sauce Тестовый ингридиент =\r\n(==== Тестовое название ====)\r\n\r\nPrice: 6,000000\r\n";

        Assert.assertEquals(testReceipt, burger.getReceipt());
    }
}
