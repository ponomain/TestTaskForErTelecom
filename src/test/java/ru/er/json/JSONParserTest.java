package ru.er.json;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 22.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
class JSONParserTest {

    private static JSONObject object;
    private File file;

    @BeforeAll
    public static void setUp(){
        object = new JSONObject();
        Map<String, Object[]> data = new LinkedHashMap<>();
        data.put("CRUD", new String[]{"SELECT"});
        data.put("VALUES", new String[]{"customer_id"});
        data.put("FROM", new String[]{"orders_product"});
        data.put("RIGHT JOIN", new String[]{"customers on orders_product.customer_id = customers.id"});
        data.put("INNER JOIN", new String[]{"customers"});
        data.put("FULL JOIN", new String[]{"products"});
        data.put("LEFT JOIN", new String[]{"products on orders_product.product_id = products.id"});
        data.put("WHERE", new String[]{"customers.id<10"});
        data.put("GROUP BY", new String[]{"customer_id"});
        data.put("ORDER BY", new String[]{"product_id"});
        object.setData(data);
    }

    @Test
    void whenFileIsEmpty() throws FileNotFoundException {
        file = new File("src/test/resources/query_null.sql");
        Scanner scanner = new Scanner(file);
        assertFalse(scanner.hasNextLine());
    }

    @Test
    void whenParsingFromFile() throws FileNotFoundException {
        file = new File("src/test/resources/query_test.sql");
        JSONObject newObject = new JSONObject();
        JSONParser parser = new JSONParser(newObject, file);
        parser.parse();
        assertEquals(object.toString(), newObject.toString());
    }

}