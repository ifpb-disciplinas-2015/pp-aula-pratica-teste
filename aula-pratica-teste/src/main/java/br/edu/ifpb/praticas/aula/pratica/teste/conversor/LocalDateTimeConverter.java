
package br.edu.ifpb.praticas.aula.pratica.teste.conversor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
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
