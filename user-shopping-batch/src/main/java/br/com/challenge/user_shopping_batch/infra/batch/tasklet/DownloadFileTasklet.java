package br.com.challenge.user_shopping_batch.infra.batch.tasklet;

import br.com.challenge.user_shopping_batch.infra.batch.dto.CompleteWorkflowContext;
import br.com.challenge.user_shopping_batch.infra.batch.enums.NameParameterContext;
import br.com.challenge.user_shopping_batch.infra.ftp.service.FtpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DownloadFileTasklet implements Tasklet {

    private final FtpService ftpService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Starting download file from ftp ");

        CompleteWorkflowContext context = getContext(chunkContext);

        String filePath = ftpService.downloadInTemp(context.getClientFileFtpPath(), context.getClientFileName());
        context.setFileDownloadedPath(filePath);

        log.info("Finished download file from ftp with success ");
        return RepeatStatus.FINISHED;
    }

    private CompleteWorkflowContext getContext(ChunkContext chunkContext) {
        return (CompleteWorkflowContext) chunkContext.getStepContext()
                .getStepExecutionContext()
                .get(NameParameterContext.COMPLETE_WORKFLOW.getName());
    }
}