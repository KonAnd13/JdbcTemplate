package ru.itpark.util;

import ru.itpark.exception.DataAccesException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLHelper {
    public static int executeUpdate(String url, String sql, PreparedStatementSetter setter) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            setter.set(preparedStatement);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataAccesException();
        }
    }


    public static <T> List<T> executeQuery(String url, String sql, PreparedStatementSetter setter, RowMapper<T> mapper) {
        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            setter.set(preparedStatement);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<T> result = new LinkedList<>();
                while (resultSet.next()) {
                    result.add(mapper.map(resultSet));
                }
                return result;
            }
        } catch (SQLException e) {
            throw new DataAccesException();
        }
    }
}
