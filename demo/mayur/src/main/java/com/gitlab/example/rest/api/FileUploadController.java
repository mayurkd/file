package com.gitlab.example.rest.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gitlab.example.service.GitHubFileUploadService;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.net.URISyntaxException;

@RestController
public class FileUploadController {

    @Autowired
    private GitHubFileUploadService gitHubFileUploadService;

    @PostMapping("/uploadFiles")
    public ResponseEntity<String> uploadFilesToGitHub() {
        try {
            gitHubFileUploadService.uploadFilesToGitHub();
            return new ResponseEntity<>("Files uploaded successfully to GitHub.", HttpStatus.OK);
        } catch (IOException | GitAPIException | URISyntaxException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload files to GitHub: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
