package com.example.javaexercises5.advanced.dao;

import java.sql.*;

public class UserDao extends AbstractDao {
    private static final String LOAD_ALL_QUERY = "SELECT * FROM users;";
    private static final String LOAD_BY_ID_QUERY = "SELECT * FROM users WHERE id=?;";
    private static final String CREATE_QUERY = "INSERT INTO users(username, created, group_id) VALUES(?,?,?);";
    private static final String UPDATE_QUERY = "UPDATE users SET username=?, created=?, group_id=? WHERE id=?;";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE id=?;";

    @Override
    protected Model newFromResultSet(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"),
                rs.getString("name"),
                new Timestamp(rs.getDate("created").getTime()).toLocalDateTime(),
                rs.getInt("group_id"));
    }

    @Override
    protected String getLoadAllQuery() {
        return LOAD_ALL_QUERY;
    }

    @Override
    protected String getLoadByIdQuery() {
        return LOAD_BY_ID_QUERY;
    }

    @Override
    protected PreparedStatement saveNewStatement(Connection con, Model user) throws SQLException {
        String[] generatedColumns = {"id"};
        PreparedStatement ps = con.prepareStatement(CREATE_QUERY, generatedColumns);
        ps.setString(1, ((User) user).getUsername());
        ps.setDate(2, Date.valueOf(((User) user).getCreated().toString()));
        ps.setInt(3, ((User) user).getGroupId());
        return ps;
    }

    @Override
    protected PreparedStatement updateExistingStatement(Connection con, Model user) throws SQLException {
        PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);
        ps.setString(1, ((User) user).getUsername());
        ps.setDate(2, Date.valueOf(((User) user).getCreated().toString()));
        ps.setInt(3, ((User) user).getGroupId());
        ps.setLong(4, user.getId());
        return ps;
    }

    @Override
    protected PreparedStatement deleteStatement(Connection con, Model user) throws SQLException {
        PreparedStatement ps = con.prepareStatement(DELETE_QUERY);
        ps.setLong(1, user.getId());
        return ps;
    }
}
