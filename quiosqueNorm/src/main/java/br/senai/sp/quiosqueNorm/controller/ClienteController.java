package br.senai.sp.quiosqueNorm.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.quiosqueNorm.dao.DaoCliente;
import br.senai.sp.quiosqueNorm.model.Cliente;




@Controller
public class ClienteController {
	
	@RequestMapping("cadCliente")
	public String form() {	
		return "cad_cliente";
	}
	
	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(Cliente cliente) {
		System.out.println(cliente.getDataNascimento());
		
		DaoCliente dao = new DaoCliente();
		dao.inserirCliente(cliente);
		return "redirect:cadCliente";
	}
	
	@RequestMapping("listaCliente")
	public String listar(Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("cliente", dao.listar());
		
		
		return "listacliente";
	}
	@RequestMapping("excluirCliente")
	public String excluir(long idCliente) {
		DaoCliente dao = new DaoCliente();
		dao.excluir(idCliente);
		return "redirect:listaCliente";
	}
	
	@RequestMapping("alterarCliente")
	public String alterar(long idCliente, Model model) {
		DaoCliente dao = new DaoCliente();
		model.addAttribute("cliente", dao.buscar(idCliente));
		
		
		
		return "forward:cadCliente";
	}
	
	@RequestMapping("contadorEstatisticas")
	public String contadores(Model model) { 
			List<Cliente> cliente = new DaoCliente().listar();
			
			int contM = 0, contF = 0, contJovem = 0, contAdulto = 0, contIdoso = 0;
			int domingo = 0, segunda = 0, terca = 0, quarta = 0 , quinta = 0, sexta = 0 , sabado = 0;
			int dia = 0, tarde = 0, noite = 0;
			int diaSem, horaSem;
			
		
			
			for(Cliente c : cliente) {
				if(c.getGenero().equals("masculino")) {
					contM++;
				}else {
					contF++;
				}
				if(c.getIdade() <= 18) {
					contJovem++;
				}else if(c.getIdade() <= 49) {
					contAdulto++;
				}else {
					contIdoso++;
				}
				diaSem = c.getDataCadastro().get(Calendar.DAY_OF_WEEK);
					if (diaSem == 1) {
						domingo++;
					}else if (diaSem == 2) {
						segunda++;
					}else if (diaSem == 3) {
						terca++;
					}else if (diaSem == 4) {
						quarta++;
					}else if (diaSem == 5) {
						quinta++;
					}else if (diaSem == 6) {
						sexta++;
					}else {
						sabado++;
					}
					horaSem = c.getDataCadastro().get(Calendar.HOUR_OF_DAY);
					if(horaSem < 12) {
						dia++;
					}else if(horaSem < 18){
						tarde++;
					}else {
						noite++;
					}
				
			}
		
			model.addAttribute("masculino", contM);
			model.addAttribute("feminino", contF);
			
			model.addAttribute("jovem", contJovem);
			model.addAttribute("adulto", contAdulto);
			model.addAttribute("idoso", contIdoso);
			
			model.addAttribute("domingo", domingo);
			model.addAttribute("segunda", segunda);
			model.addAttribute("terca", terca);
			model.addAttribute("quarta", quarta);
			model.addAttribute("quinta", quinta);
			model.addAttribute("sexta", sexta);
			model.addAttribute("sabado", sabado);
			
			model.addAttribute("dia", dia);
			model.addAttribute("tarde", tarde);
			model.addAttribute("noite", noite);
		
		return "contadorestatisticas";
	}
	
	
	

	

		
	


}