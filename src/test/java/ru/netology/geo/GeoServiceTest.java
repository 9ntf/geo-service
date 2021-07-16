package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

public class GeoServiceTest {

    @Test
    void test_geoServiceImpl() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        String ip = "172.0.0.1";

        Assertions.assertEquals(location.getCountry(), geoService.byIp(ip).getCountry());
    }
}