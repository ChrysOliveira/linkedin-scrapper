package com.example.linkedin_scrapper.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class Utils {
    public static String retornaJson(String filePath) {
        String jsonContent = "";
        try {

            jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            log.error("Erro ao ler o arquivo: " + filePath, e);
        }
        return jsonContent;
    }
}
