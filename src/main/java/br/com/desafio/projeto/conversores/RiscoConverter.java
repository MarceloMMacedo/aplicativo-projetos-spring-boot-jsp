package br.com.desafio.projeto.conversores;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.desafio.projeto.enums.RiscoEnum;

@Converter
public class RiscoConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return RiscoEnum.returnId(arg0);
    }

    @Override
    public String convertToEntityAttribute(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return RiscoEnum.returnName(arg0);
    }

}
