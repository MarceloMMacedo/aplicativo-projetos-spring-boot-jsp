package br.com.desafio.projeto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate {
    public static String converterDataParaStringYyyyMmDd(Date data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(data);
    }

    public static Date converterStringParaDataYyyyMmDd(String dataString) throws ParseException {
        if (dataString == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dataString);
    }

    public static String converterDataParaStringDdMmYyyy(Date data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(data);
    }
}
