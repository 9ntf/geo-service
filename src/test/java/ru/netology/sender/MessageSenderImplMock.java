package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderImplMock {

    @Test
    void test_messageSender_russian_text() {
        Map<String, String> headers = new HashMap<>();
        String message = "Отправлено сообщение: Добро пожаловать";

        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp("172.0.0.1")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));


        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        Assertions.assertEquals(message, messageSender.send(headers));
    }
}