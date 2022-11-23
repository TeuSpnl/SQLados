package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Patient;

public class PatientDao extends Patient {

    public static void register(String name, Date birthDate, long CPF, int insuranceCode, long phone)
            throws SQLException {
        String sql = "INSERT INTO PAC (PAC_DTHR_REG,PAC_NOME,PAC_BIRTH,PAC_CPF,PAC_CNV_COD,PAC_TEL)" +
                "VALUES (current_timestamp,?,?,?,?,?)";

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement smt = con.prepareStatement(sql);

        smt.setString(1, name);
        smt.setDate(2, birthDate);
        smt.setLong(3, CPF);
        smt.setInt(4, insuranceCode);
        smt.setLong(5, phone);
        smt.executeUpdate(); // Executa Comando no SQL
        smt.close(); // Finaliza o PreparedStatement
        con.close(); // Finaliza a Conexão com o BD
    }

    public List<model.Patient> getAll() {
        List<model.Patient> patients = null;
        String sql = "SELECT * " +
                "FROM PAC";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            if (rs != null) {
                while (rs.next()) {
                    model.Patient p = new Patient();
                    p.setRecord(rs.getInt("PAC_REG"));
                    p.setRecordDate(rs.getDate("PAC_DTHR_REG"));
                    p.setName(rs.getString("PAC_NOME"));
                    p.setBirthDate(rs.getDate("PAC_BIRTH"));
                    p.setCPF(rs.getLong("PAC_CPF"));
                    p.setInsuranceCode(rs.getInt("PAC_CNV_COD"));
                    p.setPhone(rs.getLong("PAC_TEL"));
                    patients.add(p);
                }
            }

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e) {
            System.out.println("Error ao Buscar Todos os Pacientes!");
        }

        return patients;
    }

    public static model.Patient getPatient(int record) {
        model.Patient pac = new Patient();
        String sql = "SELECT * " +
                "FROM PAC " +
                "WHERE PAC_REG= ?";

        try {
            Connection con = new ConnectionFactory().getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs;

            smt.setInt(1, record);
            rs = smt.executeQuery(); // Executa Comando no SQL e rs recebe os valores

            pac.setRecord(rs.getInt("PAC_REG"));
            pac.setRecordDate(rs.getDate("PAC_DTHR_REG"));
            pac.setName(rs.getString("PAC_NOME"));
            pac.setBirthDate(rs.getDate("PAC_BIRTH"));
            pac.setCPF(rs.getLong("PAC_CPF"));
            pac.setInsuranceCode(rs.getInt("PAC_CNV_COD"));
            pac.setPhone(rs.getLong("PAC_TEL"));

            rs.close(); // Finaliza os dados da Query
            smt.close(); // Finaliza o PreparedStatement
            con.close(); // Finaliza a Conexão com o BD
        } catch (SQLException e) {
            System.out.println("Error ao Buscar o Paciente!");
        }

        return pac;
    }
}