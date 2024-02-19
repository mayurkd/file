package com.gitlab.example.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gitlab.example.dto.MyData;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;

@Service
public class JsonGenerationService {

    public void generateAndSaveJson() throws IOException {
        // Generate JSON data
    	MyData data = new MyData("John Doe", 30);
        // Populate data...

        // Convert object to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(data);
        // Save JSON to file
        File file = new File("C:/abc/reJson1.json"); // Local file path
        file.getParentFile().mkdirs();

        mapper.writeValue(file, data);
    }
}
