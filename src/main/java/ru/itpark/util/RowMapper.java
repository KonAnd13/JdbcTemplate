package ru.itpark.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@FunctionalInterface
public interface RowMapper {
    void map(PreparedStatement ps) throws SQLException;
}
