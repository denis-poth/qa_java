import com.example.Cat;
import com.example.Predator;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatTest {

    @Test
    public void testGetSound_ReturnsMeow() {
        Predator predatorMock = mock(Predator.class);
        Cat cat = new Cat(predatorMock);
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемый звук кошки");
    }

    @Test
    public void testGetFood_DelegatesToPredator() throws Exception {
        Predator predatorMock = mock(Predator.class);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(predatorMock);
        List<String> food = cat.getFood();

        assertEquals(expectedFood, food);
        System.out.println("Тест успешно выполнен: метод делегирует вызов хищнику и возвращает ожидаемый список еды");
    }
}