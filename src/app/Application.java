package app;

import entidade.Aluno;
import implement.AlunoDAOImp;

public class Application {

		public static void main(String[] args) {
			
			Aluno aluno = new Aluno();
				
				aluno.setMatricula(2153);
				aluno.setNome("Samara");
				aluno.setEmail("Samara@gmail.com");
				aluno.setNota01(6.);
				aluno.setNota02(7.);
				
				// chamada de objeto anonimo do AlunoDAOImp
				if (new AlunoDAOImp().salvar(aluno))
					System.out.println("Dados gravados com sucesso");
				else
					System.out.println("Falha na gravação");
				
		}
}
