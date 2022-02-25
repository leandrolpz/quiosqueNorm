package br.senai.sp.quiosqueNorm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import br.senai.sp.quiosqueNorm.model.Cliente;


public class DaoCliente {
	private Connection conexao;
	
	public DaoCliente() {
		conexao = ConnectionFactory.conectar();
	}
	public void inserirCliente(Cliente cliente) {
		String sql = "insert into tb_cliente(nome, data_nascimento, endereco, telcel, email, prod_interesse, genero)"
				+ "values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setString(3, cliente.getEndereco());
			stmt.setString(4, cliente.getTelecel());
			stmt.setString(5, cliente.getEmail());
			stmt.setString(6, cliente.getProdInteresse());
			stmt.setString(7, cliente.getGenero());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	public List<Cliente> listar(){
		String sql = "select * from tb_cliente order by nome asc";
		PreparedStatement stmt;
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelecel(rs.getString("telcel"));
				c.setEmail(rs.getString("email"));
				c.setProdInteresse(rs.getString("prod_interesse"));
				c.setGenero(rs.getString("genero"));
				//cria calendar com data atual
				Calendar nascimento = Calendar.getInstance();
				Calendar cadastro = Calendar.getInstance();
				//extrair o java.sql.Date do db
				Date nascDt = rs.getDate("data_nascimento");
				Date cdt = rs.getDate("data_cadastro");
				Timestamp horaCad = rs.getTimestamp("data_cadastro"); 
				//passa o long do java.sql.Date para  o Calendar
				nascimento.setTimeInMillis(nascDt.getTime());
				cadastro.setTimeInMillis(cdt.getTime());
				cadastro.setTimeInMillis(horaCad.getTime());
				//"setar o nascimento do cliente
				c.setDataNascimento(nascimento);
				c.setDataCadastro(cadastro);
				
				
				
				lista.add(c);
				
			}
			
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void excluir(long idCliente) {
		String sql = "delete from tb_cliente where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public void ataualizar(Cliente cliente) {
		String sql = "updade tb_cliente set nome = ?,  data_nascimento = ?, endereco = ?, telcel = ?, email = ?, prod_interesse = ?, tamanho_pedido = ?, genero = ? "
				+ "where id = ?";
			
				PreparedStatement stmt;
				try {
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, cliente.getNome());
					stmt.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
					stmt.setString(3, cliente.getEndereco());
					stmt.setString(4, cliente.getTelecel());
					stmt.setString(5, cliente.getEmail());
					stmt.setString(6, cliente.getProdInteresse());
					
					stmt.setString(7, cliente.getGenero());
					stmt.setLong(8, cliente.getId());
					stmt.execute();
					stmt.close();
					conexao.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
		}
	}
	public Cliente buscar(long idCliente){
		String sql = "select *  from tb_cliente where id = ?";
		PreparedStatement stmt;
		Cliente c = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelecel(rs.getString("telcel"));
				c.setEmail(rs.getString("email"));
				c.setProdInteresse(rs.getString("prod_interesse"));
				c.setGenero(rs.getString("genero"));
				//cria calendar com data atual
				Calendar nascimento = Calendar.getInstance();
				Calendar cadastro = Calendar.getInstance();
				
				//extrair o java.sql.Date do db
				Date nascDt = rs.getDate("data_nascimento");
				Date cdt = rs.getDate("data_cadastro");
				Timestamp horaCad = rs.getTimestamp("data_cadastro");
				//passa o long do java.sql.Date para  o Calendar
				nascimento.setTimeInMillis(nascDt.getTime());
				cadastro.setTimeInMillis(cdt.getTime());
				horaCad.setTime(horaCad.getTime());
				//"setar o nascimento do cliente
				c.setDataNascimento(nascimento);
				
				
				
				
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return c;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}