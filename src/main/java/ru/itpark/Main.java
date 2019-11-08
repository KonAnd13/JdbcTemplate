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
                ps -> {
                    int index = 1;
                    ps.setInt(index++, 1);
                    ps.setString(index++, "Vasya");
                    ps.setInt(index++, 100);
                    ps.setInt(index++, 90);
                    ps.setString(index, "boys");
                });

        SQLHelper.executeQuery(
                url,
                "INSERT INTO managers (boss_id, name, salary, plan, unit)\n" +
                        "VALUES " +
                        "(?, ?, ?, ?, ?);",
                ps -> {
                    int index = 1;
                    ps.setInt(index++, 1);
                    ps.setString(index++, "Petya");
                    ps.setInt(index++, 70);
                    ps.setInt(index++, 80);
                    ps.setString(index, "boys");
                });
    }
}