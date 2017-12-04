package entidade;

	import java.io.Serializable;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Integer matricula;
	private String nome;
	private String email;
	private Double nota01;
	private Double nota02;
	
	public Aluno() {
	
	}
	
	@Override
	
	public String toString() {
		return "Aluno:\n\tID" + id + "\n\tMatricula: " + matricula + "\n\tNome: " + nome + "\n\tEmail: " + email + "\n\tNota01: " + nota01 + "\n\tNota02: " + nota02; 
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getNota01(){
		return nota01;
	}
	
	public void setNota01(Double nota01) {
		this.nota01 = nota01;
	}
	
	public Double getNota02(){
		return nota02;
	}
	
	public void setNota02(Double nota02) {
		this.nota02 = nota02;
	}
	
	public Double getMedia() {
		return (this.nota01 + this.nota02) / 2;
	}
	
}


