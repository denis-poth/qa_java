import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.example.*;

@RunWith(Parameterized.class)
public class LionTest {

    private String sex;

    public LionTest(String sex) {
        this.sex = sex;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец"},
                {"Самка"}
        });
    }

    @Test
    public void testDoesHaveMane_ReturnsExpectedValue() throws Exception {
        boolean expectedMane = "Самец".equals(sex);
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedMane, lion.doesHaveMane());
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемое значение для наличия гривы");
    }

    @Test
    public void testGetKittens_ReturnsExpectedValue() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        int expectedKittens = sex.equals("Самка") ? 1 : 0;
        when(felineMock.getKittens()).thenReturn(expectedKittens);
        assertEquals(expectedKittens, lion.getKittens());
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемое количество детенышей");
    }

    @Test
    public void testGetFood_ReturnsExpectedValue() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
        System.out.println("Тест успешно выполнен: метод возвращает ожидаемый список еды");
    }
}
