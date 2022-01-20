package ru.er.json;

import java.util.*;

/**
 * 20.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */

public class JSONObject {

    public static final String[] CRUD = {"UPDATE", "CREATE", "DELETE", "SELECT", "FROM", "JOIN", "WHERE", "ORDER BY", "GROUP BY"};

    private Map<String, String[]> fields;

    public JSONObject() {
        this.fields = new HashMap<>();
    }

    public Map<String, String[]> getFields() {
        return this.fields;
    }

    public void setFields(Map<String, String[]> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ \n");
        Set<String> keys = fields.keySet();
        for (String key : keys) {
            sb.append(key).append(":").append(Arrays.toString(fields.get(key)));
        }
        sb.append('}');
        return sb.toString();
    }
}
