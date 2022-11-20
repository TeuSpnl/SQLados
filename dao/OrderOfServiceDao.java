package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.OrderOfService;

public class OrderOfServiceDao extends OrderOfService {

  public void register(String Number, String patientRecord, String dateAndHour, String referringDoctor, String department, String typeOfservice, String responsibleUser, String insurance){
        String sql = "INSERT INTO OS" +
                    "VALUES (?,?,?,?,?,?,?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, Number);
                smt.setString(2, patientRecord);
                smt.setString(3,  dateAndHour);
                smt.setString(4, referringDoctor);
                smt.setString(5, department);
                smt.setString(6, typeOfservice);
                smt.setString(7, responsibleUser);
                smt.setString(8, insurance);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar a Ordem de Servico!");
        }
    }

    public List<model.OrderOfService> getAll(){
        List<model.OrderOfService> orders = null;
        String sql = "SELECT *" +
                    "FROM OS";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if(rs!=null){
                while(rs.next()){
                    model.OrderOfService o = new OrderOfService();
                    o.setNumber(rs.getString("OS_NUMERO"));
                    o.setPatientRecord(rs.getString("OS_PAC_REG"));
                    o.setDateAndHour(rs.getString("OS_DTHR"));
                    o.setReferringDoctor(rs.getString("OS_REQUISITANTE"));
                    o.setDepartment(rs.getString("OS_STR_COD"));
                    o.setTypeOfservice(rs.getString("OS_TIPO_ATEND"));
                    o.setResponsibleUser(rs.getString("OS_USR_RESP"));
                    o.setInsurance(rs.getString("OS_CNV_COD"));
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

    public model.OrderOfService getOS(String number){
        model.OrderOfService os = new OrderOfService();
        String sql = "SELECT *" +
                    "FROM OS" +
                    "WHERE OS_NUMERO = '?'";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;
            
            smt.setString(1, number.toUpperCase());
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

                os.setNumber(rs.getString("OS_NUMERO"));
                os.setPatientRecord(rs.getString("OS_PAC_REG"));
                os.setDateAndHour(rs.getString("OS_DTHR"));
                os.setReferringDoctor(rs.getString("OS_REQUISITANTE"));
                os.setDepartment(rs.getString("OS_STR_COD"));
                os.setTypeOfservice(rs.getString("OS_TIPO_ATEND"));
                os.setResponsibleUser(rs.getString("OS_USR_RESP"));
                os.setInsurance(rs.getString("OS_CNV_COD"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar a Ordem de Servico!");
        }

        return os;
    }
}
