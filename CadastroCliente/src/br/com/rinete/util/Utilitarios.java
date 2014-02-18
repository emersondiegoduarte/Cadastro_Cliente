package br.com.rinete.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.rinete.dao.ClienteDAO;
import br.com.rinete.model.Cliente;

public class Utilitarios {
	
	public static boolean aniversario(Date dtNascimento){
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = formato.format(dtNascimento);
			dtNascimento = formato.parse(dataFormatada);
			Date hoje = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(hoje);
			Calendar nascimento = Calendar.getInstance();
			nascimento.setTime(dtNascimento);
			int dia = c.get(Calendar.DAY_OF_MONTH) ;
			int mes = c.get(Calendar.MONTH) + 1;
			int diaNascimento = nascimento.get(Calendar.DAY_OF_MONTH) ;
			int mesNascimento = nascimento.get(Calendar.MONTH) + 1;
			System.out.println(dia);
			System.out.println(mes);
			System.out.println(diaNascimento);
			System.out.println(mesNascimento);
			if(dia ==  diaNascimento && mes == mesNascimento){
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static void main(String[] args) throws ParseException {
//		Calendar c = Calendar.getInstance();
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//		Date dt = formato.parse("04/11/2012");
//		c.add(Calendar.DAY_OF_MONTH, 0);
//		System.out.println(Utilitarios.aniversario(dt));
		List<Cliente> cliente = new ClienteDAO().recuperaAniversariantesDoMes();
		System.out.println(cliente);
	}

}
