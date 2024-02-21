import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Animal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private String animalKind;
    private List<String> expectedFood;

    public AnimalParameterizedTest(String animalKind, List<String> expectedFood) {
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
    public void testGetFoodReturnsCorrectFood() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood(animalKind);
        assertEquals(expectedFood, food);
        System.out.println("Тест прошел успешно: метод возвращает еду для " + animalKind.toLowerCase());
    }
}
