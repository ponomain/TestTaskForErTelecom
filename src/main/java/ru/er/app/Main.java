package ru.er.app;

import ru.er.json.JSONObject;
import ru.er.json.JSONParser;

import java.util.Objects;
import java.util.Scanner;

/**
 * 18.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        parser.parse(json);
        System.out.println(json);
    }
}

