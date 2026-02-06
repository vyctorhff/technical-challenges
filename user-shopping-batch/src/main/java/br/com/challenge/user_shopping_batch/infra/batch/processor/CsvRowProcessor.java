package br.com.challenge.user_shopping_batch.infra.batch.processor;

import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowInput;
import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowOutput;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@StepScope
public class CsvRowProcessor implements ItemProcessor<CsvShoppingRowInput, CsvShoppingRowOutput> {

    private final static DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Value("#{jobParameters['process.file.id']}")
    private Long idFile;

    @Override
    public CsvShoppingRowOutput process(CsvShoppingRowInput item) throws Exception {
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(item.amount()));
        LocalDateTime date = LocalDateTime.parse(item.date(), FORMATTER);

        return new CsvShoppingRowOutput(
                idFile,
                item.name(),
                item.shoppingDetail(),
                amount,
                date
        );
    }
}
