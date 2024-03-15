package br.com.projeto.aplicacao.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.projeto.aplicacao.enums.RiscoEnum;

@Converter
public class RiscoConverter implements AttributeConverter<String, Integer> {

    @Override
    public Integer convertToDatabaseColumn(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return RiscoEnum.returnId(arg0);
    }

    @Override
    public String convertToEntityAttribute(Integer arg0) {
        if (arg0 == null) {
            return null;
        }
        return RiscoEnum.returnName(arg0);
    }

}
