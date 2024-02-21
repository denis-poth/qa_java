import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import com.example.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;

    public LionParameterizedTest(String sex) {
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
    public void testDoesHaveManeReturnsExpectedValue() throws Exception {
        boolean expectedMane = "Самец".equals(sex);
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedMane, lion.doesHaveMane());
        System.out.println("Тест выполнен успешно: метод возвращает значения для самца и для самки");
    }

    @Test
    public void testGetKittensReturnsExpectedValue() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        int expectedKittens = sex.equals("Самка") ? 1 : 0;
        when(felineMock.getKittens()).thenReturn(expectedKittens);
        assertEquals(expectedKittens, lion.getKittens());
        System.out.println("Тест выполнен успешно: метод возвращает количество детенышей");
    }
}
