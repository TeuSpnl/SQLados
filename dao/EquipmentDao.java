package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Equipment;

public class EquipmentDao extends Equipment {

  public void register(String name, int departmentCode){
        String sql = "INSERT INTO EQP (EQP_DTHR_REGISTRO,EQP_NOME,EQP_STR_COD) " +
                    "VALUES (current_timestamp,?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1,  name);
                smt.setInt(2, departmentCode);
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
                    e.setNumber(rs.getInt("EQP_NUMERO"));
                    e.setRegisterDate(rs.getDate("EQP_DTHR_REGISTRO"));
                    e.setName(rs.getString("EQP_NOME"));
                    e.setDepartmentCode(rs.getInt("EQP_STR_COD"));
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

    public model.Equipment getEquipment(String code){
        model.Equipment eqp = new Equipment();
        String sql = "SELECT *" +
                    "FROM EQP" +
                    "WHERE EQP_NUMERO = '?'";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;
            
            smt.setString(1, code.toUpperCase());
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

                eqp.setNumber(rs.getInt("EQP_NUMERO"));
                eqp.setRegisterDate(rs.getDate("EQP_DTHR_REGISTRO"));
                eqp.setName(rs.getString("EQP_NOME"));
                eqp.setDepartmentCode(rs.getInt("EQP_STR_COD"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar o Equipamento!");
        }

        return eqp;
    }
}