package com.alexstudy.base;

import java.time.ZonedDateTime;

/**
 * @ClassName AbstractZoneTimeClient
 * @Description ${TODO}
 * @Author AlexTong
 * @Date 2018/12/25 14:58:43
 */
public interface AbstractZoneTimeClient extends TimeClient {
    public ZonedDateTime getZonedDateTime(String zoneString);
}
