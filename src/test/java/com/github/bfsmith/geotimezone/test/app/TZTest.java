package com.github.bfsmith.geotimezone.test.app;

import com.github.bfsmith.geotimezone.TimeZoneLookup;
import com.github.bfsmith.geotimezone.TimeZoneResult;
import org.joda.time.DateTimeZone;

import java.util.Date;

public class TZTest {
  public static void main(String[] args) {
    long utcTime = 1424719299;
    // Human time (GMT): Mon, 23 Feb 2015 19:21:39 GMT
    // Human time (your time zone): 2/23/2015, 1:21:39 PM
    long dallasTime = convertToLocalTime(utcTime,  32.775833, -96.796667);
    long losAngelesTime = convertToLocalTime(utcTime,  34.0, -118.0);
    Date dallasDate = new Date(dallasTime);
    Date losAngelesDate = new Date(losAngelesTime);
    System.out.println("Dallas time: " + dallasDate + " - " + dallasTime);
    System.out.println("Los Angeles time: " + losAngelesDate + " - " + losAngelesTime);
  }

  public static long convertToLocalTime(long utcDate, double latitude, double longitude) {
    TimeZoneLookup timeZoneLookup = new TimeZoneLookup();
    TimeZoneResult timeZoneResult = timeZoneLookup.getTimeZone(latitude, longitude);
    DateTimeZone zone = DateTimeZone.forID(timeZoneResult.getResult());
    return zone.convertUTCToLocal(utcDate);
  }
}
