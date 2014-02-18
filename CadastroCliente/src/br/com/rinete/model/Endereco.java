package br.com.rinete.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;



@Entity
@Table(name="ENDERECO")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7292441308897330981L;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Id
	@GeneratedValue(generator = "fk_endereco_cod_cliente")
	@org.hibernate.annotations.GenericGenerator(name="fk_endereco_cod_cliente",strategy="foreign",parameters=
	@Parameter(name="property", value = "cliente"))
	@Column(name="COD_CLIENTE")
	private Integer endereco;
	
	@OneToOne(mappedBy="endereco")
	private Cliente cliente;
	
	private String rua;
	
	private Integer numero;
	
	private String bairro;
	
	private String cidade;
	
	@Column(name="estado")
	private String uf;
	
	private String cep;
	
	private String complemento;

	/**
	 * @return the endereco
	 */
	public Integer getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
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

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}
