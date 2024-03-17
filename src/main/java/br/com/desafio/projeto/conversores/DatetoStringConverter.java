package br.com.desafio.projeto.conversores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DatetoStringConverter implements AttributeConverter<String, Date> {

    @Override
    public Date convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }

        try {
            Date data = converterStringParaData(attribute);
            return data;
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data: " + e.getMessage());
        }

        return null;
    }

    @Override
    public String convertToEntityAttribute(Date dbData) {
        if (dbData == null) {
            return null;
        }
        return converterDataParaString(dbData);
    }

    public static String converterDataParaString(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(data);
    }

    public static Date converterStringParaData(String dataString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(dataString);
    }
}
