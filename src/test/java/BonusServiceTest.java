import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class BonusServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"})
    public void bonusServiceParametrized(String userConditions, String amountConditions,
                                                            boolean isRegistered, long amount, long expected) {
        System.out.println("Тестовые условия: регистрация клиента = " + userConditions +
                "; Доп условия: " + amountConditions);
        BonusService service = new BonusService();
        long actual = service.calculate(amount, isRegistered);
        Assertions.assertEquals(expected, actual);
    }

}
