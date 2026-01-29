package br.com.challenge.user_shopping_batch.infra.ftp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.integration.ftp.session.FtpRemoteFileTemplate;

@Configuration
public class FtpConfig {

    @Value("${fpt.host}")
    private String host;

    @Value("${fpt.user}")
    private String user;

    @Value("${fpt.pass}")
    private String pass;

    @Value("${fpt.port}")
    private Integer port;

    @Bean
    public DefaultFtpSessionFactory ftpSessionFactory() {
        DefaultFtpSessionFactory sessionFactory = new DefaultFtpSessionFactory();
        sessionFactory.setHost(host);
        sessionFactory.setPort(port);
        sessionFactory.setUsername(user);
        sessionFactory.setPassword(pass);
        // For active mode, you might need advanced config if the server requires it
        // sessionFactory.setClientMode(FTPClient.ACTIVE_LOCAL_DATA_CONNECTION_MODE);
        return sessionFactory;
    }

    @Bean
    public FtpRemoteFileTemplate ftpRemoteFileTemplate(DefaultFtpSessionFactory sessionFactory) {
        return new FtpRemoteFileTemplate(sessionFactory);
    }
}
