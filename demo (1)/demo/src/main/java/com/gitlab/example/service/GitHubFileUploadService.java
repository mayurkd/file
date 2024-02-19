package com.gitlab.example.service;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class GitHubFileUploadService {

    @Value("${github.username}")
    private String username;

    @Value("${github.password}")
    private String password;

    @Value("${github.repository}")
    private String repositoryUrl; // Ensure this is correctly configured in your application.properties or application.yml
    
    @Value("${upload.directory}")
    private String uploadDirectory; // Directory path for repository operations

    public void uploadFilesToGitHub() throws IOException, GitAPIException, URISyntaxException {
        try (Git git = Git.open(new File(uploadDirectory))) {
            git.add().addFilepattern(".").call(); // Add all files in the directory to the index
            git.commit().setMessage("Add files").call(); // Commit the changes
            git.checkout()
            .setCreateBranch(true)
            .setName("Agastya")
            .call();
            git.remoteAdd().setName("origin").setUri(new URIish(repositoryUrl)).call();
            // Add remote origin
            git.push()
               .setCredentialsProvider(new UsernamePasswordCredentialsProvider(username, password))
               .call(); // Push changes to GitHub
            System.out.println(git);
        }
    }
}
