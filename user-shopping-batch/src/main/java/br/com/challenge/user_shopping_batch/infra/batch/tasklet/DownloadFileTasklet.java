package br.com.challenge.user_shopping_batch.infra.batch.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DownloadFileTasklet implements Tasklet {

    public static final String PARAM_FILE_PATH_NAME = "filePath";

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Starting download file from ftp ");

        log.info("Finished download file from ftp with success ");
        return RepeatStatus.FINISHED;
    }

    private String getFilePath(ChunkContext chunkContext) {
        return chunkContext.getStepContext().getStepExecutionContext()
                .get(PARAM_FILE_PATH_NAME)
                .toString();
    }
}