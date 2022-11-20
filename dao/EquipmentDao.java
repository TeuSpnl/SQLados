package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Equipment;

public class EquipmentDao extends Equipment {

  public void register(String number, String registerDate, String name, String departmentCode){
        String sql = "INSERT INTO EQP" +
                    "VALUES (?,?,?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, number);
                smt.setString(2, registerDate);
                smt.setString(3,  name);
                smt.setString(4, departmentCode);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar o Equipamento!");
        }
    }

    public List<model.Equipment> getAll(){
        List<model.Equipment> equipments = null;
        String sql = "SELECT *" +
                    "FROM EQP";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if(rs!=null){
                while(rs.next()){
                    model.Equipment e = new Equipment();
                    e.setNumber(rs.getString("EQP_NUMERO"));
                    e.setRegisterDate(rs.getString("EQP_DTHR_REGISTRO"));
                    e.setName(rs.getString("EQP_NOME"));
                    e.setDepartmentCode(rs.getString("EQP_STR_COD"));
                    equipments.add(e);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar Todos os Equipamentos!");
        }

        return equipments;
    }
}