package ru.itpark.util;

import ru.itpark.exception.DataAccesException;
import ru.itpark.model.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLHelper {
    public static int executeUpdate(String url, String sql, RowMapper mapper) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            mapper.map(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccesException();
        }
        return -1;
    }

    public static List<Manager> executeQuery(String url, String sql, RowMapper mapper) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            mapper.map(preparedStatement);
            List<Manager> result = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result.add(new Manager(
                        resultSet.getInt("id"),
                        resultSet.getInt("boss_id"),
                        resultSet.getString("name"),
                        resultSet.getInt("salary"),
                        resultSet.getInt("plan"),
                        resultSet.getString("unit")
                ));
            }
            return result;
        } catch (SQLException e) {
            throw new DataAccesException();
        }
    }
}
