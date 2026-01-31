package br.com.challenge.user_shopping_batch.infra.service;

import br.com.challenge.user_shopping_batch.infra.batch.dto.CompleteWorkflowContext;
import br.com.challenge.user_shopping_batch.infra.batch.enums.NameParameterContext;
import br.com.challenge.user_shopping_batch.infra.db.entity.UserEntity;
import br.com.challenge.user_shopping_batch.infra.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CompleteWorkflowService {

    private final Job completeWorkflow;
    private final JobLauncher jobLauncher;

    private final UserRepository userRepository;

    public void execute() throws Exception {
        log.info("Staring completo workflow process");

        log.info("Searching active clients");
        List<UserEntity> userList = userRepository.findByEnable(Boolean.TRUE);

        if (userList.isEmpty()) {
            log.info("No client active. Ending process");
            return;
        }

        for (UserEntity entity : userList) {
            CompleteWorkflowContext context = new CompleteWorkflowContext(entity);

            String paramRunId = NameParameterContext.RUN_ID.getName();
            String paramContext = NameParameterContext.COMPLETE_WORKFLOW.getName();

            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong(paramRunId, System.currentTimeMillis())
                    .addJobParameter(paramContext, context, CompleteWorkflowContext.class)
                    .toJobParameters();

            jobLauncher.run(completeWorkflow, jobParameters);
        }
    }
}
