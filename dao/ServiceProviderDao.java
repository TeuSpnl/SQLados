package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ServiceProvider;

public class ServiceProviderDao extends ServiceProvider {

  public void register(String code, String name, String CPF, String council, String type, String UF){
        String sql = "INSERT INTO PSV" +
                    "VALUES (?,?,?,?,?,?)";

        try{
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);

                smt.setString(1, code);
                smt.setString(2, name);
                smt.setString(3,  CPF);
                smt.setString(4, council);
                smt.setString(5, type);
                smt.setString(6, UF);
            smt.executeUpdate(); // Executa Comando no SQL
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Registrar o Prestador de Servico!");
        }
    }

    public List<model.ServiceProvider> getAll(){
        List<model.ServiceProvider> services = null;
        String sql = "SELECT *" +
                    "FROM PSV";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if(rs!=null){
                while(rs.next()){
                    model.ServiceProvider s = new ServiceProvider();
                    s.setCode(rs.getString("PSV_COD"));
                    s.setName(rs.getString("PSV_NOME"));
                    s.setCPF(rs.getString("PSV_CPF"));
                    s.setCouncil(rs.getString("PSV_CONSELHO"));
                    s.setType(rs.getString("PSV_TIPO"));
                    s.setUF(rs.getString("PSV_UF"));
                    services.add(s);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar Todos os Prestadores de Servico!");
        }

        return services;
    }

    public model.ServiceProvider getPSV(String code){
        model.ServiceProvider psv = new ServiceProvider();
        String sql = "SELECT *" +
                    "FROM PSV" +
                    "WHERE PSV_COD= '?'";

        try{
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;
            
            smt.setString(1, code.toUpperCase());
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

                psv.setCode(rs.getString("PSV_COD"));
                psv.setName(rs.getString("PSV_NOME"));
                psv.setCPF(rs.getString("PSV_CPF"));
                psv.setCouncil(rs.getString("PSV_CONSELHO"));
                psv.setType(rs.getString("PSV_TIPO"));
                psv.setUF(rs.getString("PSV_UF"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e){
            System.out.println("Error ao Buscar o Prestador de Servico!");
        }

        return psv;
    }

}
