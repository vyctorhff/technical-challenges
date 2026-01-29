package br.com.challenge.user_shopping_batch.infra.ftp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.integration.ftp.session.FtpRemoteFileTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class FtpService {

    private final FtpRemoteFileTemplate ftpTemplate;

    public List<String> list(String path) {
        FTPFile[] files = ftpTemplate.list(path);

        return Arrays.stream(files)
                .map(FTPFile::getName)
                .toList();
    }

    public OutputStream downlaod(String path) {
        OutputStream out = new ByteArrayOutputStream();

        ftpTemplate.get(path, stream -> {
            stream.transferTo(out);
        });

        return out;
    }

    public String downloadInTemp(String path, String fileName) throws IOException {
        File tempFile = File.createTempFile(fileName, ".temp");
        ftpTemplate.get(path, stream -> {
            try (FileOutputStream fout = new FileOutputStream(tempFile)) {
                stream.transferTo(fout);
            }
        });
        return tempFile.getAbsolutePath();
    }
}
