package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.User;

public class UserDao extends User {

    public static void register(String login, String password, String name, int sector, Date birth, Long CPF)
            throws SQLException {
        String sql = "INSERT INTO USR " +
                "VALUES (?,?,?,?,?,?);";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement smt = con.prepareStatement(sql);

        smt.setString(1, login.toUpperCase());
        smt.setString(2, password.toUpperCase());
        smt.setString(3, name.toUpperCase());
        smt.setInt(4, sector);
        smt.setDate(5, birth);
        smt.setLong(6, CPF);
        smt.executeUpdate(); // Executa Comando no SQL
        smt.close(); // Finaliza o PreparedStatement
        con.close(); // Finaliza a Conexão com o BD
    }

    public static List<model.User> getAll() {
        List<model.User> users = null;
        String sql = "SELECT * " +
                "FROM USR";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if (rs != null) {
                while (rs.next()) {
                    model.User u = new User();
                    u.setLogin(rs.getString("USR_LOGIN"));
                    u.setPassword(rs.getString("USR_SENHA"));
                    u.setName(rs.getString("USR_NOME"));
                    u.setDepartment(rs.getInt("USR_STR_COD"));
                    u.setBirthDate(rs.getDate("USR_BIRTH"));
                    u.setCPF(rs.getLong("USR_CPF"));
                    users.add(u);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e) {
            System.out.println("Error ao Buscar Todos os Usuarios!");
        }

        return users;
    }

    public static model.User getUser(String login) {
        model.User user = new User();
        String sql = "SELECT * " +
                " FROM USR " +
                "WHERE USR_LOGIN = ?";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            smt.setString(1, login.toUpperCase());
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores
            rs.next();
            user.setLogin(rs.getString("USR_LOGIN"));
            user.setPassword(rs.getString("USR_SENHA"));
            user.setName(rs.getString("USR_NOME"));
            user.setDepartment(rs.getInt("USR_STR_COD"));
            user.setBirthDate(rs.getDate("USR_BIRTH"));
            user.setCPF(rs.getLong("USR_CPF"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD

        } catch (SQLException e) {
            System.out.println("Error ao Buscar o Usuario!");
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static boolean loginUser(String login, String password) {
        model.User u = getUser(login.toUpperCase());
        if (u.getPassword().toUpperCase().equals(password.toUpperCase())) {
            return true;
        }
        return false;
    }

}
