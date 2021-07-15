package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

public class LocalizationServiceTest {
    @Test
    void test_localizationServiceImpl() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String message = "Добро пожаловать";

        Assertions.assertEquals(message, localizationService.locale(Country.RUSSIA));
    }
}
