import static org.junit.Assert.*;
import org.junit.Test;
import com.example.Animal;

public class AnimalTest {

    @Test
    public void testGetFoodUnknownAnimalThrowsException() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный вид");
            fail("Метод не выбросил исключение");
        } catch (Exception e) {
            System.out.println("Тест прошел успешно: исключение отработано");
        }
    }

    @Test
    public void testGetFamilyReturnsExpectedString() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
        System.out.println("Тест прошел успешно: метод возвращает список существующих семейств");
    }
}
