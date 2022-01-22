package ru.er.app;

import ru.er.json.JSONObject;
import ru.er.json.JSONParser;

import java.io.File;

/**
 * 18.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        File file = new File("src/main/resources/query.sql");
        JSONParser parser = new JSONParser(json, file);
        parser.parse();
        System.out.println(json);
    }
}

