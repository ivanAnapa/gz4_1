package ru.netology.bonus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class BonusServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = {"/data1.csv"})
    public void shouldCalculateWhenSmallAmountAndRegistered(boolean isRegistered, long amount, long expected) {
        BonusService service = new BonusService();
        long actual = service.calculate(amount, isRegistered);
        Assertions.assertEquals(expected, actual);
    }

}
