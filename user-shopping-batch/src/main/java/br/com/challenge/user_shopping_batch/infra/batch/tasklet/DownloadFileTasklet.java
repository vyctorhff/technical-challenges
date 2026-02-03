package br.com.challenge.user_shopping_batch.infra.batch.tasklet;

import br.com.challenge.user_shopping_batch.infra.batch.enums.JobParamNames;
import br.com.challenge.user_shopping_batch.infra.ftp.service.FtpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import static br.com.challenge.user_shopping_batch.infra.batch.util.ContextUtil.addJobParamWithString;
import static br.com.challenge.user_shopping_batch.infra.batch.util.ContextUtil.getJobParamInContext;

@Component
@Slf4j
@RequiredArgsConstructor
public class DownloadFileTasklet implements Tasklet {

    private final FtpService ftpService;

    // TODO: test inject job param using @Value

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("Starting download file from ftp ");

        String clientFilePath = getJobParamInContext(chunkContext, JobParamNames.CLIENT_PATH);
        String clientFileName = getJobParamInContext(chunkContext, JobParamNames.CLIENT_FILE_NAME);

        String filePath = ftpService.downloadInTemp(clientFilePath, clientFileName);
        addJobParamWithString(chunkContext, JobParamNames.CLIENT_FILE_DOWNLOAD_PATH, filePath);

        log.info("Finished download file from ftp with success ");
        return RepeatStatus.FINISHED;
    }
}