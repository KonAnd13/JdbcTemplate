package ru.itpark;
import ru.itpark.util.SQLHelper;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:db.sqlite";

        SQLHelper.executeQuery(
                url,
                "INSERT INTO managers (boss_id, name, salary, plan, unit)\n" +
                        "VALUES " +
                        "(?, ?, ?, ?, ?);",
                preparedStatement -> {
                    int index = 1;
                    preparedStatement.setInt(index++, 1);
                    preparedStatement.setString(index++, "Vasya");
                    preparedStatement.setInt(index++, 100);
                    preparedStatement.setInt(index++, 90);
                    preparedStatement.setString(index, "boys");
                });

        SQLHelper.executeQuery(
                url,
                "INSERT INTO managers (boss_id, name, salary, plan, unit)\n" +
                        "VALUES " +
                        "(?, ?, ?, ?, ?);",
                preparedStatement -> {
                    int index = 1;
                    preparedStatement.setInt(index++, 1);
                    preparedStatement.setString(index++, "Petya");
                    preparedStatement.setInt(index++, 70);
                    preparedStatement.setInt(index++, 80);
                    preparedStatement.setString(index, "boys");
                });
    }
}