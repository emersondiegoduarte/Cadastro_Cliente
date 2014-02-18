package br.com.rinete.managed;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.rinete.bo.ClienteBO;
import br.com.rinete.dao.ClienteDAO;
import br.com.rinete.model.Cliente;
import br.com.rinete.model.Endereco;

@ManagedBean(name="clienteManaged")
@SessionScoped
public class ClienteManaged implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	private List<Cliente> clientes;
	
	private List<Cliente> aniversariantes;
	
	public ClienteManaged() {
		cliente =  new Cliente();
		cliente.setEndereco(new Endereco());
		clientes = new ArrayList<Cliente>();
		aniversariantes = new ArrayList<Cliente>();
	}
	
	
	@PreDestroy
	public void limpa(){
		cliente =  new Cliente();
		cliente.setEndereco(new Endereco());
		clientes = new ArrayList<Cliente>();
		aniversariantes = new ArrayList<Cliente>();
	}
	
	public void salvar(){
		try {
			new ClienteBO().salvar(cliente);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro com sucesso.",""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
		
	}
	
	public void listar(){
		clientes = new ClienteBO().listar();
	}
	
	public void editar() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.jsf"); 
		//return "/privado/usuario";
	}


	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;//new ClienteBO().listar();
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void novo() throws IOException{
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		//return "/privado/usuario";
		FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.jsf");
	}
	
	public void consulta() throws IOException{
		cliente = new Cliente();
		cliente.setEndereco(new Endereco());
		listar();
		//return "/privado/consulta";
		//clientes = new ClienteDAO().recuperaAniversariantesDoMes();
		FacesContext.getCurrentInstance().getExternalContext().redirect("consulta.jsf");
	}
	
	public void recuperaAniversariantes() throws IOException{
			aniversariantes = new ClienteDAO().recuperaAniversariantesDoMes();
		//FacesContext.getCurrentInstance().getExternalContext().redirect("consulta.jsf");
	}
	
	public void buscarPorNome(){
		if("".equals(this.cliente.getNomeCliente()))
			listar();
		else
			this.clientes = new ClienteBO().buscarPorCodigo(this.cliente.getNomeCliente());
	}
	
    public List<String> complete(String query) {  
    	List<String> cli = new ArrayList<String>();
		for (Cliente c : clientes) {
			if(query.contains(c.getNomeCliente()))
				cli.add(c.getNomeCliente());
			
		}
		return cli;
    }


	/**
	 * @return the aniversariantes
	 */
	public List<Cliente> getAniversariantes() {
		return aniversariantes;
	}


	/**
	 * @param aniversariantes the aniversariantes to set
	 */
	public void setAniversariantes(List<Cliente> aniversariantes) {
		this.aniversariantes = aniversariantes;
	}  



	
	
	
	
}
