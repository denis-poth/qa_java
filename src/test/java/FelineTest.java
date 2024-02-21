import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.*;
import org.junit.Test;

public class FelineTest {

    @Test
    public void testGetFoodDelegatesToPredator() throws Exception {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> food = cat.getFood();

        assertEquals(3, food.size());
        assertArrayEquals(expectedFood.toArray(), food.toArray());

        System.out.println("Тест успешно выполнен: метод делегирует вызов хищнику и возвращает ожидаемый список еды");
    }

    @Test
    public void testEatMeatUnknownAnimalThrowsException() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenThrow(new Exception("Неизвестный вид животного"));
        Cat cat = new Cat(felineMock);
        try {
            cat.getFood();
            fail("Ожидалось выбрасывание исключения Exception");
        } catch (Exception e) {
            System.out.println("Тест успешно выполнен: исключение отработано");
        }
    }

    @Test
    public void testGetFamilyReturnsExpectedValue() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемое значение для семейства");
    }

    @Test
    public void testGetKittensReturnsExpectedValue() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens();
        assertEquals(1, kittensCount);
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемое количество детенышей");
    }

    @Test
    public void testGetKittensWithParameterReturnsExpectedValue() {
        Feline feline = new Feline();
        int expectedKittensCount = 5;
        int kittensCount = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, kittensCount);
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемое количество детенышей с учетом параметра");
    }
}
