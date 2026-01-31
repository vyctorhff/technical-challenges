package br.com.challenge.user_shopping_batch.infra.batch.dto;

import br.com.challenge.user_shopping_batch.infra.db.entity.UserEntity;

public class CompleteWorkflowContext {

    private UserEntity userEntity;

    private String fileDownloadPath;

    public CompleteWorkflowContext(UserEntity entity) {
        this.userEntity = entity;
    }

    public String getClientFileFtpPath() {
        return userEntity.config().pathFtp();
    }

    public String getClientFileName() {
        return userEntity.config().fileName();
    }

    public void setFileDownloadedPath(String filePath) {
        this.fileDownloadPath = filePath;
    }
}
