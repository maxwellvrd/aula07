package implement;

import java.sql.SQLException;
import entidade.Aluno;
import persistencia.AlunoDAO;

public class AlunoDAOImp {

		private AlunoDAO dao = null;
		
		public AlunoDAOImp() {
			dao = new AlunoDAO();
		}
		
		public boolean salvar(Aluno a) {
			try {
				dao.save(a);
				return Boolean.TRUE;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Boolean.FALSE;
		}
}



