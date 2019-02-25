package com.alexstudy.base;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @ClassName HandleInvalidTimeZoneClient
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/25 14:59:18
 */
public interface HandleInvalidTimeZoneClient extends TimeClient {
    default public ZonedDateTime getZonedDateTime(String zoneString) {
        try {
            return ZonedDateTime.of(getLocalDateTime(), ZoneId.of(zoneString));
        } catch (DateTimeException e) {
            System.err.println("Invalid zone ID: " + zoneString +
                    "; using the default time zone instead.");
            return ZonedDateTime.of(getLocalDateTime(),ZoneId.systemDefault());
        }
    }
}
