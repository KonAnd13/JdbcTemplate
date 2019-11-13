package ru.itpark;
import ru.itpark.model.Manager;
import ru.itpark.util.SQLHelper;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:db.sqlite";

        SQLHelper.executeUpdate(
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

        SQLHelper.executeUpdate(
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

        List<Manager> managers = SQLHelper.executeQuery(
                url,
                "SELECT id, boss_id, name, salary, plan, unit FROM managers WHERE boss_id = ?;",
                ps -> ps.setInt(1, 1),
                rs -> new Manager(
                        rs.getInt("id"),
                        rs.getInt("boss_id"),
                        rs.getString("name"),
                        rs.getInt("salary"),
                        rs.getInt("plan"),
                        rs.getString("unit")
                )
        );
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }
}