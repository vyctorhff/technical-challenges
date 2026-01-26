package br.com.challenge.user_shopping_batch.infra.batch;

import br.com.challenge.user_shopping_batch.infra.batch.dto.CsvShoppingRowDTO;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CsvRowProcessor implements ItemProcessor<String, CsvShoppingRowDTO> {

    public static final int CSV_NAME_INDEX = 0;
    public static final int CSV_DETAIL_INDEX = 1;
    public static final int CSV_AMOUNT_INDEX = 2;
    public static final int CSV_DATE_INDEX = 3;

    public static final String FILE_SEPARATOR = ";";
    public static final String CSV_DATE_FORMAT = "dd/MM/yyyy HH:mm";

    @Override
    public CsvShoppingRowDTO process(String item) throws Exception {
        String[] split = item.split(FILE_SEPARATOR);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(CSV_DATE_FORMAT);

        return new CsvShoppingRowDTO(
                split[CSV_NAME_INDEX],
                split[CSV_DETAIL_INDEX],
                BigDecimal.valueOf(Double.parseDouble(split[CSV_AMOUNT_INDEX])),
                LocalDateTime.parse(split[CSV_DATE_INDEX], formatter)
        );
    }
}
