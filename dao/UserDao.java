// package dao;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// import model.User;

// public class UserDao extends User {
//   public void register(){
//         String sql = "INSERT INTO USR" +
//                     "VALUES (?,?,?,?,?,?)";

//         try{
//             Connection con = new ConnectionFactory().getConnection();
//             PreparedStatement smt = con.prepareStatement(sql);
//             String login = "";

// //                 smt.setString(1, login);
// //                 smt.setString(2, /*Get Senha*/);
// //                 smt.setString(3, /*Get Nome*/);
// //                 smt.setString(4, /*Get Setor*/);
// //                 smt.setString(5, /*Get Aniversario*/);
// //                 smt.setString(6, /*Get CPF*/);
// //             smt.executeUpdate(); // Executa Comando no SQL
// //             smt.close(); // Finaliza o PreparedStatement
// //             con.close(); // Finaliza a Conexão com o BD
// //         } catch (SQLException e){
// //             System.out.println("Error ao Registrar o Usuario!");
// //         }
// //     }


// //   public

// // }
