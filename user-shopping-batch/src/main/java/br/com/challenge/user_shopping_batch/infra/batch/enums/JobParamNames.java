package br.com.challenge.user_shopping_batch.infra.batch.enums;

public enum JobParamNames {
    CLIENT_ID("client.id"),
    CLIENT_NAME("client.name"),
    CLIENT_PATH("client.config.path"),
    CLIENT_FILE_NAME("client.config.fileName"),
    CLIENT_FILE_DOWNLOAD_PATH("client.file.download.path"),
    PROCESSING_AMOUNT_TOTAL("process.amount.total"),
    PROCESSING_ROWS_TOTAL("process.rows.total"),
    RUN_ID("job.run-id");

    private String name;

    JobParamNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
