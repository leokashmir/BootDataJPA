package bootsample.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="tarefas")
public class Tarefa implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String nome;
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	private boolean finalizado;
	
	public Tarefa(){}
	
	public Tarefa(String nome, String descricao, Date dataCriacao, boolean finalizado) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.finalizado = finalizado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Tarefa [id =").append(id);
		sb.append(" Nome = ").append(nome);
		sb.append(" Descrição =").append(descricao);
		sb.append(" Data Criação = ").append(dataCriacao);
		sb.append(" Finalizado =").append(finalizado).append("]");
	
		return sb.toString();
		
	}	
	
}
