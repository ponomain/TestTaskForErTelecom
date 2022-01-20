package ru.er.json;

import ru.er.app.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * 20.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class JSONParser {

    private Map<String, String[]> data;

    public JSONParser() {
        this.data = new HashMap<>();
    }

    public void parse(JSONObject jsonObject) {
        StringBuilder sql = new StringBuilder();
        try (Scanner scanner = new Scanner(Objects.requireNonNull
                (Main.class.getClassLoader().getResourceAsStream("query.sql")))) {
            while (scanner.hasNextLine()) {
                choose(scanner.nextLine());
            }
        }
        jsonObject.setFields(data);
    }

    private void choose(String option) {
        String[] temp = option.split(" ");
        String newValue;
        switch (temp[0]) {
            case "SELECT":
                newValue = option.replace("SELECT", "").replace(" ", "");
                temp = newValue.split(",");
                this.data.put("SELECT", temp);
                break;
            case "FROM":
                newValue = option.replace("FROM", "").replace(" ", "");
                temp = newValue.split(",");
                this.data.put("FROM", temp);
                break;
        }
    }
}
