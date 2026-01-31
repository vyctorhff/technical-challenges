package br.com.challenge.user_shopping_batch.infra.batch.processor;

import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowInput;
import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowOutput;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CsvRowProcessor implements ItemProcessor<CsvShoppingRowInput, CsvShoppingRowOutput> {

    @Override
    public CsvShoppingRowOutput process(CsvShoppingRowInput item) throws Exception {
        return new CsvShoppingRowOutput(
                item.name(),
                item.shoppingDetail(),
                item.amount(),
                item.date()
        );
    }
}
