package br.senai.sp.quiosqueNorm.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;


public class Cliente {
	//Variaveis
	private Long id;
	private String nome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar dataNascimento;
	private Calendar DataCadastro;
	private String endereco;
	private String telecel;
	private String email;
	private String prodInteresse;
	private String genero;
	
	
	

	//Gets & Sets
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTelecel() {
		return telecel;
	}
	public void setTelecel(String telecel) {
		this.telecel = telecel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProdInteresse() {
		return prodInteresse;
	}
	public void setProdInteresse(String prodInteresse) {
		this.prodInteresse = prodInteresse;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Calendar getDataCadastro() {
		return DataCadastro;
	}
	
	public void setDataCadastro(Calendar dataCadastro) {
		DataCadastro = dataCadastro;
	}
	
	public int getIdade() {
		int dia = dataNascimento.get(Calendar.DAY_OF_MONTH);
		int mes = dataNascimento.get(Calendar.MONTH);
		int ano = dataNascimento.get(Calendar.YEAR);
		LocalDate dataNasc = LocalDate.of(ano, mes+1, dia);
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(dataNasc, dataAtual);
		return periodo.getYears();
		
	}
	
	
	
	

}