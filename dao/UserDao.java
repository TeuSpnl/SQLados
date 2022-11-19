package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserDao extends User {

  public void register(String login, String password, String name, String sector, String birth, String CPF) throws SQLException {
        String sql = "INSERT INTO USR" +
                    "VALUES (?,?,?,?,?,?)";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, login);
                smt.setString(2, password);
                smt.setString(3,  name);
                smt.setString(4, sector);
                smt.setString(5, birth);
                smt.setString(6, CPF);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar o Usuario!");
        }
    }

}
