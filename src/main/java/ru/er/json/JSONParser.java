package ru.er.json;

import ru.er.app.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 20.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class JSONParser {

    private Map<String, Object[]> data;
    private final File file;
    private final JSONObject object;

    public JSONParser(JSONObject object, File file) {
        this.object = object;
        this.file = file;
    }

    public void parse() {
        this.data = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(this.file)) {
            while (scanner.hasNextLine()) {
                choose(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.object.setData(data);
    }

    private void choose(String option) {
        String[] temp = option.split(" ");
        String newValue;
        String select = "SELECT";
        String from = "FROM";
        String where = "WHERE";
        if (select.equals(temp[0])) {
            newValue = option.replace(select, "").replace(" ", "");
            temp = newValue.split(",");
            this.data.put("CRUD", new String[]{select});
            this.data.put("VALUES", temp);
        } else if (from.equals(temp[0])) {
            newValue = option.replace(from, "").replace(" ", "");
            temp = newValue.split(",");
            this.data.put(from, temp);
        } else if (where.equals(temp[0])) {
            newValue = option.replace(where, "").replace(" ", "");
            temp = newValue.split(",");
            this.data.put(where, temp);
        } else if ("INNER".equals(temp[0])) {
            String innerJoin = "INNER JOIN";
            newValue = option.replace(innerJoin, "").trim();
            temp = newValue.split(",");
            this.data.put(innerJoin, temp);
        } else if ("RIGHT".equals(temp[0])) {
            String rightJoin = "RIGHT JOIN";
            newValue = option.replace(rightJoin, "").trim();
            temp = newValue.split(",");
            this.data.put(rightJoin, temp);
        } else if ("LEFT".equals(temp[0])) {
            String leftJoin = "LEFT JOIN";
            newValue = option.replace(leftJoin, "").trim();
            temp = newValue.split(",");
            this.data.put(leftJoin, temp);
        } else if ("FULL".equals(temp[0])) {
            String fullJoin = "FULL JOIN";
            newValue = option.replace(fullJoin, "").trim();
            temp = newValue.split(",");
            this.data.put(fullJoin, temp);
        } else if ("GROUP".equals(temp[0])) {
            String groupBy = "GROUP BY";
            newValue = option.replace(groupBy, "").trim();
            temp = newValue.split(",");
            this.data.put(groupBy, temp);
        } else if ("ORDER".equals(temp[0])) {
            String orderBy = "ORDER BY";
            newValue = option.replace(orderBy, "").trim();
            temp = newValue.split(",");
            this.data.put(orderBy, temp);
        }
    }
}
