package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.OrderOfService;

public class OrderOfServiceDao extends OrderOfService {

  public static void register(int patientRecord, int referringDoctor, int department, String typeOfservice, String responsibleUser, int insurance){
        String sql = "INSERT INTO OS (OS_PAC_REG,OS_DTHR,OS_REQUISITANTE,OS_STR_COD,OS_TIPO_ATEND,OS_USR_RESP,OS_CNV_COD)" +
                    "VALUES (?,current_timestamp,?,?,?,?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setInt(1, patientRecord);
                smt.setInt(2, referringDoctor);
                smt.setInt(3, department);
                smt.setString(4, typeOfservice);
                smt.setString(5, responsibleUser);
                smt.setInt(6, insurance);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar a Ordem de Servico!");
        }
    }

    public List<model.OrderOfService> getAll(){
        List<model.OrderOfService> orders = null;
        String sql = "SELECT * " +
                    "FROM OS";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if(rs!=null){
                while(rs.next()){
                    model.OrderOfService o = new OrderOfService();
                    o.setNumber(rs.getInt("OS_NUMERO"));
                    o.setPatientRecord(rs.getInt("OS_PAC_REG"));
                    o.setDateAndHour(rs.getDate("OS_DTHR"));
                    o.setReferringDoctor(rs.getInt("OS_REQUISITANTE"));
                    o.setDepartment(rs.getInt("OS_STR_COD"));
                    o.setTypeOfservice(rs.getString("OS_TIPO_ATEND"));
                    o.setResponsibleUser(rs.getString("OS_USR_RESP"));
                    o.setInsurance(rs.getInt("OS_CNV_COD"));
                    orders.add(o);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar Todos as Ordens de Servico!");
        }

        return orders;
    }

    public static model.OrderOfService getOS(String number){
        model.OrderOfService os = new OrderOfService();
        String sql = "SELECT * " +
                    "FROM OS " +
                    "WHERE OS_NUMERO = ?";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;
            
            smt.setString(1, number.toUpperCase());
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

                os.setNumber(rs.getInt("OS_NUMERO"));
                os.setPatientRecord(rs.getInt("OS_PAC_REG"));
                os.setDateAndHour(rs.getDate("OS_DTHR"));
                os.setReferringDoctor(rs.getInt("OS_REQUISITANTE"));
                os.setDepartment(rs.getInt("OS_STR_COD"));
                os.setTypeOfservice(rs.getString("OS_TIPO_ATEND"));
                os.setResponsibleUser(rs.getString("OS_USR_RESP"));
                os.setInsurance(rs.getInt("OS_CNV_COD"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar a Ordem de Servico!");
        }

        return os;
    }

}
