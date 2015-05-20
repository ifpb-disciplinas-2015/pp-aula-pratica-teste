
package br.edu.ifpb.praticas.aula.pratica.teste.conversor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime data) {
        return Timestamp.valueOf(data);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp data) {
        return data.toLocalDateTime();
    }

}
