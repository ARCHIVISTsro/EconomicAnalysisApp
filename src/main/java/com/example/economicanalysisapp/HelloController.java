package com.example.economicanalysisapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.sql.*;

public class HelloController {
    String url = "jdbc:mysql://127.0.0.1:3306/Economy";
    String user = "root";
    String password = ""; // Замініть на ваш пароль

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        StringBuilder allRecords = new StringBuilder();

        try {
            // Завантаження драйвера MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Підключення до бази даних
            Connection conn = DriverManager.getConnection(url, user, password);
            // Виконання запиту
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nazov FROM stats");

            // Обробка результатів
            while (rs.next()) {
                allRecords.append(rs.getString("nazov")).append("\n");
            }

            // Закриття з'єднання
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            allRecords.append("Помилка при отриманні даних");
        }

        // Виведення даних у Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Записи з таблиці");
        alert.setHeaderText("Всі записи зі стовпця 'nazov'");
        alert.setContentText(allRecords.toString());

        alert.showAndWait();


//        welcomeText.setText("Welcome to JavaFX Application!");

    }
}