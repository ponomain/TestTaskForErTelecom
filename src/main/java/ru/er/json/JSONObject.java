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

    private Map<String, Object[]> data;

    public JSONObject() {
        this.data = new LinkedHashMap<>();
    }

    public void setData(Map<String, Object[]> data) {
        this.data = data;
    }

    public Map<String, Object[]> getData() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{ \n");
        if (!data.isEmpty()) {
            Set<String> keysData = data.keySet();
            for (String key : keysData) {
                String value = Arrays.toString(data.get(key));
                sb.append("   ")
                        .append("\"")
                        .append(key)
                        .append("\"")
                        .append(" : ")
                        .append(value.replace("[", "[\"").replace("]", "\"]"))
                        .append("\n");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
