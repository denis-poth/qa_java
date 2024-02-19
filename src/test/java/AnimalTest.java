import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    private String animalKind;
    private List<String> expectedFood;

    public AnimalTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения") },
                { "Хищник", List.of("Животные", "Птицы", "Рыба") }
        });
    }

    @Test
    public void testGetFood_ReturnsCorrectFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedFood, food);
        System.out.println("Тест прошел успешно: метод возвращает еду для " + animalKind.toLowerCase());
    }

    @Test
    public void testGetFood_UnknownAnimal_ThrowsException() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный вид");
            fail("Метод не выбросил исключение");
        } catch (Exception e) {
            System.out.println("Тест прошел успешно: исключение отработано");
        }
    }

    @Test
    public void testGetFamily_ReturnsExpectedString() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
        System.out.println("Тест прошел успешно: метод возвращает список существующих семейств");
    }
}
