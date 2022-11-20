package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Insurance;

public class InsuranceDao extends Insurance {

  public void register(String code, String name){
        String sql = "INSERT INTO CNV" +
                    "VALUES (?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, code);
                smt.setString(2, name);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar o Equipamento!");
        }
    }

    public List<model.Insurance> getAll(){
        List<model.Insurance> insurances = null;
        String sql = "SELECT *" +
                    "FROM CNV";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if(rs!=null){
                while(rs.next()){
                    model.Insurance i = new Insurance();
                    i.setCode(rs.getString("CNV_COD"));
                    i.setName(rs.getString("CNV_NOME"));
                    insurances.add(i);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar Todos os Convenios!");
        }

        return insurances;
    }
}