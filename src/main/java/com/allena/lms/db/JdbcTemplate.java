package com.allena.lms.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate<T> {

    DatabaseHelper db = new DatabaseHelper();

    public <T> List<T> getAll(String sql, RowMapper<T> mapper) throws Exception {
        db.connect();
        db.init(sql);
        ResultSet resultSet = db.execute();
        List<T> rows = new ArrayList<>();
        while (resultSet.next()) {
            rows.add(mapper.map(resultSet));
        }
        db.close();

        return rows;
    }

    public T getByObject(String sql, Object[] parameters, RowMapper<T> mapper) throws Exception {

        T result = null;

        db.connect();
        db.init(sql);
        addParameter(db.init(sql), parameters);
        ResultSet resultSet = db.execute();
        while (resultSet.next()) {
            result = mapper.map(resultSet);
        }
        db.close();

        return result;
    }

    public List<T> getAllByObject(String sql, Object[] parameters, RowMapper<T> mapper) throws Exception {

        db.connect();
        addParameter(db.init(sql), parameters);
        ResultSet resultSet = db.execute();
        List<T> rows = new ArrayList<>();
        while (resultSet.next()) {
            rows.add(mapper.map(resultSet));
        }
        db.close();

        return rows;
    }

    public int update(String sql, Object[] parameters) throws Exception {

        db.connect();
        addParameter(db.init(sql), parameters);
        int result = db.update();
        db.close();
        return result;
    }

    public void addParameter(PreparedStatement preparedStatement, Object[] parameters) throws Exception {
        int index = 1;
        for (Object parameter : parameters) {
            preparedStatement.setObject(index++, parameter);
        }
    }

}
