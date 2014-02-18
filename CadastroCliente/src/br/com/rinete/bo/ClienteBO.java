package br.com.rinete.bo;

import java.util.List;

import br.com.rinete.dao.ClienteDAO;
import br.com.rinete.model.Cliente;

public class ClienteBO {

	public void salvar(Cliente cliente) throws Exception {
		cliente.getEndereco().setCliente(cliente);
		new ClienteDAO().salvar(cliente);
		
	}
	
	public void atualizar(Cliente cliente){
		new ClienteDAO().atualizar(cliente);
	}
	
	public void excluir(Cliente cliente){
		new ClienteDAO().excluir(cliente);
	}

	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return new ClienteDAO().listar();	
	}

	public List<Cliente> buscarPorCodigo(String nomeCliente) {
		// TODO Auto-generated method stub
		return new ClienteDAO().listar(nomeCliente);
	}
	
	public List<Cliente> recuperaAniversariantesDoMes(){
		return new ClienteDAO().recuperaAniversariantesDoMes();
	}

}
