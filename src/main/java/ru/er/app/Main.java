package ru.er.app;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;
import java.util.Scanner;

/**
 * 18.01.2022
 * TestTaskForErTelecom
 *
 * @author Nikolay Ponomarev
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(Main.class.getClassLoader().getResourceAsStream("application.properties"));
        try (Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties)) {
            StringBuilder sql = new StringBuilder();
            try (Scanner scanner = new Scanner(Objects.requireNonNull
                    (Main.class.getClassLoader().getResourceAsStream("sql/query.sql")))) {
                while (scanner.hasNextLine()) {
                    sql.append(scanner.nextLine());
                }
            }
            ResultSet resultSet;
            try (PreparedStatement statement = connection.prepareStatement(sql.toString())) {
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("title"));
                }
            }
        }
    }
}
