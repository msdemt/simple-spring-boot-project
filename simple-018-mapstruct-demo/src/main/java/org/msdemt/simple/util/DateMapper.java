package org.msdemt.simple.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateMapper {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public String asString(Date date) {
        return date != null ? new SimpleDateFormat(DATE_FORMAT).format(date) : null;
    }

    public Date asDate(String date) throws ParseException {
        try {
            return date != null ? new SimpleDateFormat(DATE_FORMAT).parse(date) : null;
        } catch (ParseException e) {
            throw e;
        }
    }
}
