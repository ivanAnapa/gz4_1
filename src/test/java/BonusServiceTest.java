import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BonusServiceTest {

    @Test
    public void shouldCalculateWhenSmallAmountAndRegistered() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateWhenRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateWhenSmallAmountAndUnregistered() {
        BonusService bonusService = new BonusService();

        long amount = 1_000_20;
        boolean isRegistered = false;
        long expected = 10;

        long actual = bonusService.calculate(amount, isRegistered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateWhenOverLimitAndUnregistered() {
        BonusService bonusService = new BonusService();

        long amount = 190_000_15;
        boolean isRegistered = false;
        long expected = 500;

        long actual = bonusService.calculate(amount, isRegistered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateWhenMinAmountAndUnregistered() {
        BonusService bonusService = new BonusService();

        long amount = 1;
        boolean isRegistered = false;
        long expected = 0;

        long actual = bonusService.calculate(amount, isRegistered);

        Assertions.assertEquals(expected, actual);
    }

}
