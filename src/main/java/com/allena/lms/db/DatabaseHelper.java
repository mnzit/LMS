package com.allena.lms.db;

import java.sql.*;

public class DatabaseHelper {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DbConfig.URL, DbConfig.USERNAME, DbConfig.PASSWORD);
    }

    public PreparedStatement init(String sql) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }

    public int update() throws SQLException {
        return preparedStatement.executeUpdate();
    }

    public ResultSet execute() throws SQLException {
        return preparedStatement.executeQuery();
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            preparedStatement.close();
            connection.close();
        }
        connection = null;
        preparedStatement = null;
    }
}
