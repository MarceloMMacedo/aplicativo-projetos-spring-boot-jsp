package br.com.desafio.projeto.util;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

class UtilDateTest {

    @Test
    void testConverterDataParaStringYyyyMmDd() {
        final Date date = createDate(2024, 3, 19);
        final String expectedString = "2024-03-19";
        final String result = UtilDate.converterDataParaStringYyyyMmDd(date);
        assertEquals(expectedString, result);
    }

    @Test
    void testConverterDataParaStringYyyyMmDd_NullDate() {
        final String result = UtilDate.converterDataParaStringYyyyMmDd(null);

        assertNull(result);
    }

    @Test
    void testConverterStringParaDataYyyyMmDd() throws ParseException {
        final String dateString = "2024-03-19";
        final Date expectedDate = createDate(2024, 3, 19);
        final Date result = UtilDate.converterStringParaDataYyyyMmDd(dateString);
        assertEquals(expectedDate, result);
    }

    @Test
    void testConverterStringParaDataYyyyMmDd_NullString() throws ParseException {
        final Date result = UtilDate.converterStringParaDataYyyyMmDd(null);

        assertNull(result);
    }

    @Test
    void testConverterDataParaStringDdMmYyyy() {
        final Date date = createDate(2024, 3, 19);
        final String expectedString = "19/03/2024";

        final String result = UtilDate.converterDataParaStringDdMmYyyy(date);

        assertEquals(expectedString, result);
    }

    @Test
    void testConverterDataParaStringDdMmYyyy_NullDate() {
        final String result = UtilDate.converterDataParaStringDdMmYyyy(null);
        assertNull(result);
    }

    private Date createDate(int year, int month, int day) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(year + "-" + month + "-" + day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
