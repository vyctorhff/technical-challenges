package br.com.challenge.user_shopping_batch.infra.batch.tasklet;

import br.com.challenge.user_shopping_batch.infra.batch.enums.JobParamNames;
import br.com.challenge.user_shopping_batch.infra.batch.util.ContextUtil;
import br.com.challenge.user_shopping_batch.infra.db.entity.FileEntity;
import br.com.challenge.user_shopping_batch.infra.db.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
@StepScope
public class InsertFileTasklet implements Tasklet {

    private final FileRepository fileRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("starting inserting for current file");

        String userId = ContextUtil.getJobParam(chunkContext, JobParamNames.CLIENT_ID);
        String userName = ContextUtil.getJobParam(chunkContext, JobParamNames.CLIENT_NAME);

        FileEntity entity = FileEntity.create(Long.parseLong(userId));
        Long fileId = fileRepository.save(entity).id();

        ContextUtil.addJobParamWithString(chunkContext, JobParamNames.PROCESSING_ID_FILE, fileId.toString());

        log.info("finish inserting record [user: {}]", userName);
        return RepeatStatus.FINISHED;
    }
}
