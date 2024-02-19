import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.*;
import org.junit.Before;
import org.junit.Test;

public class FelineTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = mock(Feline.class);
    }

    @Test
    public void testGetFood_DelegatesToPredator() throws Exception {
        Cat cat = new Cat(felineMock);
        when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = cat.getFood();

        assertEquals(3, food.size());
        assertEquals("Животные", food.get(0));
        assertEquals("Птицы", food.get(1));
        assertEquals("Рыба", food.get(2));

        System.out.println("Тест успешно выполнен: метод делегирует вызов хищнику и возвращает ожидаемый список еды");
    }

    @Test
    public void testEatMeat_UnknownAnimal_ThrowsException() throws Exception {
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
    public void testGetFamily_ReturnsExpectedValue() {
        Feline feline = new Feline();
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testGetKittens_ReturnsExpectedValue() {
        Feline feline = new Feline();
        int kittensCount = feline.getKittens();
        assertEquals(1, kittensCount);
    }

    @Test
    public void testGetKittens_WithParameter_ReturnsExpectedValue() {
        Feline feline = new Feline();
        int expectedKittensCount = 5;
        int kittensCount = feline.getKittens(expectedKittensCount);
        assertEquals(expectedKittensCount, kittensCount);
    }
}
