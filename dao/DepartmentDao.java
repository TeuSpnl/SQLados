package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Department;

public class DepartmentDao extends Department {

    public static void register(String name, String responsible) throws SQLException {
        String sql = "INSERT INTO STR (STR_NOME, STR_RESP) " +
                "VALUES (?,?)";

            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

            smt.setString(1, name);
            smt.setString(2, responsible);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
    }

    public List<model.Department> Department() {
        List<model.Department> departaments = null;
        String sql = "SELECT * " +
                "FROM STR";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if (rs != null) {
                while (rs.next()) {
                    model.Department d = new Department();
                    d.setCode(rs.getInt("STR_CODE"));
                    d.setName(rs.getString("STR_NOME"));
                    d.setResponsible(rs.getString("STR_RESP"));
                    departaments.add(d);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e) {
            System.out.println("Error ao Buscar Todos os Equipamentos!");
        }

        return departaments;
    }

    public static model.Department getDepartment(int code) {
        model.Department str = new Department();
        String sql = "SELECT * " +
                "FROM STR " +
                "WHERE STR_COD = ?";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            smt.setInt(1, code);
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores
            rs.next();

            str.setCode(rs.getInt("STR_COD"));
            str.setName(rs.getString("STR_NOME"));
            str.setResponsible(rs.getString("STR_RESP"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e) {
            System.out.println("Error ao Buscar o Setor!");
            System.out.println(e.getMessage());
        }

        return str;
    }
}