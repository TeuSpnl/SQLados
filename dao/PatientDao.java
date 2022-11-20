package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Patient;

public class PatientDao extends Patient {

  public void register(String record , String recordDate, String name, String birthDate, String CPF, String insuranceCode, String phone){
        String sql = "INSERT INTO PAC" +
                    "VALUES (?,?,?,?,?,?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, record);
                smt.setString(2, recordDate);
                smt.setString(3,  name);
                smt.setString(4, birthDate);
                smt.setString(5, CPF);
                smt.setString(6, insuranceCode);
                smt.setString(7, phone);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar o Usuario!");
        }
    }

    public List<model.Patient> getAll(){
        List<model.Patient> patients = null;
        String sql = "SELECT *" +
                    "FROM PAC";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if(rs!=null){
                while(rs.next()){
                    model.Patient p = new Patient();
                    p.setRecord(rs.getString("PAC_REG"));
                    p.setRecordDate(rs.getString("PAC_DTHR_REG"));
                    p.setName(rs.getString("PAC_NOME"));
                    p.setBirthDate(rs.getString("PAC_BIRTH"));
                    p.setCPF(rs.getString("PAC_CPF"));
                    p.setInsuranceCode(rs.getString("PAC_CNV_COD"));
                    p.setPhone(rs.getString("PAC_TEL"));
                    patients.add(p);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar Todos os Usuarios!");
        }

        return patients;
    }

}
