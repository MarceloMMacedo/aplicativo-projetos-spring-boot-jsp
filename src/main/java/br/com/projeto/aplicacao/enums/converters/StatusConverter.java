package br.com.projeto.aplicacao.enums.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.projeto.aplicacao.enums.StatusEnum;

@Converter
public class StatusConverter implements AttributeConverter<String, Integer> {

    @Override
    public Integer convertToDatabaseColumn(String arg0) {
        if (arg0 == null) {
            return null;
        }
        return StatusEnum.returnId(arg0);
    }

    @Override
    public String convertToEntityAttribute(Integer arg0) {
        if (arg0 == null) {
            return null;
        }
        return StatusEnum.returnName(arg0);
    }

}
