package br.com.challenge.user_shopping_batch.infra.batch.enums;

public enum NameParameterContext {
    COMPLETE_WORKFLOW("completeWorkflowContext"),
    RUN_ID("runId");

    private String name;

    NameParameterContext(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
