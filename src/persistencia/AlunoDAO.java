package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

// método responsável por editar os dados do aluno no BD

	public void editRegistro(Aluno a) throws SQLException{
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("update aluno set nome = ?, email = ? where id = ?");
			
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getEmail());
			stmt.setDouble(3, a.getId());
			
			int flag = stmt.executeUpdate();
			
			if(flag == 0)
				throw new SQLException("Erro ao editar os dados do aluno");
		} finally {
			if (conn != null)
				conn.close();
			if (stmt != null)
				stmt.close();
			
		}
	}
	
	// método responsável por excluir o aluno no BD
	
	public void deleteRegistro(Long id) throws SQLException{
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("delete from aluno where id = ?");
			
			stmt.setDouble(1, id);
			int flag = stmt.executeUpdate();
			
			if(flag ==0)
				throw new SQLException("Erro ao excluir os dados do aluno");
		}finally {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
		}
	}
	
	private Aluno createAluno(ResultSet rs) throws SQLException {
				
		Aluno aluno = new Aluno();
		
		aluno.setId(rs.getLong(1));
		aluno.setMatricula(rs.getInt(2));
		aluno.setNome(rs.getString(3));
		aluno.setEmail(rs.getString(4));
		aluno.setNota01(rs.getDouble(5));
		aluno.setNota02(rs.getDouble(6));
		return aluno;
		
	
	}
	
	public Aluno getAlunoBymatricula(Integer matricula) throws SQLException{
		
		PreparedStatement stmt = null;
		Aluno aluno = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select * from aluno where matricula = ?");
			stmt.setInt(1,  matricula);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				aluno = createAluno(rs);
			}
		}finally {
			if(conn != null)
				conn.close();
			if(stmt != null)
				stmt.close();
			if(rs !=null)
				rs.close();
		}
		
		return aluno;
	}
}
	
