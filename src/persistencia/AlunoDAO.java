package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidade.Aluno;

public class AlunoDAO extends ConnectionDAO {

	private Connection conn;
	public AlunoDAO(){
		try {
			conn = getConnection();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao abrir a conexão: " + e.getMessage());
		}
	}
	
	// Método responsável por salvar o aluno no banco de dados
	
	public void save(Aluno a) throws SQLException{
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into aluno values (null, ?, ?, ?, ?, ?)");
			stmt.setInt(1, a.getMatricula());
			stmt.setString(2, a.getNome());
			stmt.setString(3, a.getEmail());
			stmt.setDouble(4, a.getNota01());
			stmt.setDouble(5, a.getNota02());
			
			int flag = stmt.executeUpdate();
			if(flag == 0)
				throw new SQLException("Erro ao gravar no banco");
		} finally {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
		}
	}
}
