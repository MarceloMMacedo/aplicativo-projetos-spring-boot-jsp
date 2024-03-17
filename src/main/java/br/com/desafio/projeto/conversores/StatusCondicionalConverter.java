package br.com.desafio.projeto.conversores;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.com.desafio.projeto.enums.StatusCondicionalEnum;

@Converter
public class StatusCondicionalConverter implements AttributeConverter<String, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(String attribute) {
        if (attribute == null) {
            return null;
        }
        return StatusCondicionalEnum.returnId(attribute);
    }

    @Override
    public String convertToEntityAttribute(Boolean dbData) {
        if (dbData == null) {
            return null;
        }
        return StatusCondicionalEnum.returnName(dbData);
    }

}
