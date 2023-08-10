package dao;

import db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
public static PreparedStatement getPreparedStatement(String query,Object ...args) throws SQLException,ClassNotFoundException {
    Connection connection = DbConnection.getInstance().getConnection();
    PreparedStatement statement=connection.prepareStatement(query);
    for (int i=0;i<args.length;i++){
        statement.setObject(i+1,args[i]);
    }
    return statement;
}
public static boolean executeUpdate(String query,Object...args) throws SQLException, ClassNotFoundException {
    return getPreparedStatement(query,args).executeUpdate()>0;

}
public static ResultSet executeQuery(String query,Object...args) throws SQLException, ClassNotFoundException {
    return getPreparedStatement(query,args).executeQuery();
}
}
