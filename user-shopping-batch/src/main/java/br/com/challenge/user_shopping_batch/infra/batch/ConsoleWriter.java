package br.com.challenge.user_shopping_batch.infra.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

@Slf4j
public class ConsoleWriter implements ItemWriter<String> {

    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        StringBuilder sb = new StringBuilder();
        chunk.getItems()
                .stream()
                .forEach(item -> sb.append(item + " - "));

        log.info("Writing line: ", sb);
    }
}
