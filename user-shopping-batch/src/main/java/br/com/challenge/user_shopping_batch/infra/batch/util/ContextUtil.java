package br.com.challenge.user_shopping_batch.infra.batch.util;

import br.com.challenge.user_shopping_batch.infra.batch.enums.JobParamNames;
import org.springframework.batch.core.scope.context.ChunkContext;

public class ContextUtil {

    public static void addJobParamWithString(ChunkContext context,
                                             JobParamNames jobParamNames,
                                             String value) {
        context.getStepContext()
                .getJobExecutionContext()
                .put(jobParamNames.getName(), value);
    }

    public static String getJobParamInContext(ChunkContext chunkContext, JobParamNames paramNames) {
        return chunkContext.getStepContext()
                .getJobExecutionContext()
                .get(paramNames.getName())
                .toString();
    }
}
