/**
 * 
 */
package br.com.rinete.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



/**
 * @author diegodias
 *
 */
@Entity
@Table(name="CLIENTE")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1950935940372932538L;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name="COD_CLIENTE")
	private Integer codCliente;
	
	@Column(name="NOME_CLIENTE")
	private String nomeCliente;
	
	@Column(name="SOBRENOME_CLIENTE")
	private String sobrenomeCliente;
	
	@Column(name="DATA_NASCIMENTO")
	private Date dtNascimento;
	
	@Column(name="CPF_CLIENTE")
	private String cpf;
	
	@Column(name="RG_CLIENTE")
	private String rg;
	
	@Column(name="ESTADO_CIVIL")
	private Integer estadoCivil;
	
	@Column(name="NOME_CONJUGE")
	private String nomeConjuge;
	
	@Column(name="NOME_PAI")
	private String nomePai;
	
	@Column(name="NOME_MAE")
	private String nomeMae;
	
	@Column(name="ESTILO")
	private String estilo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="COD_CLIENTE")
	private Endereco endereco;
	
	@Column(name="TELEFONE_CLIENTE")
	private String telefone;
	
	@Column(name="CELULAR_CLIENTE")
	private String celular;
	
	@Column(name="EMAIL_CLIENTE")
	private String email;
	
	@Column(name="NATURALIDADE")
	private String naturalidade;


	/**
	 * @return the codCliente
	 */
	public Integer getCodCliente() {
		return codCliente;
	}

	/**
	 * @param codCliente the codCliente to set
	 */
	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the sobrenomeCliente
	 */
	public String getSobrenomeCliente() {
		return sobrenomeCliente;
	}

	/**
	 * @param sobrenomeCliente the sobrenomeCliente to set
	 */
	public void setSobrenomeCliente(String sobrenomeCliente) {
		this.sobrenomeCliente = sobrenomeCliente;
	}

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the estadoCivil
	 */
	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * @return the nomeConjuge
	 */
	public String getNomeConjuge() {
		return nomeConjuge;
	}

	/**
	 * @param nomeConjuge the nomeConjuge to set
	 */
	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	/**
	 * @return the nomePai
	 */
	public String getNomePai() {
		return nomePai;
	}

	/**
	 * @param nomePai the nomePai to set
	 */
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	/**
	 * @return the nomeMae
	 */
	public String getNomeMae() {
		return nomeMae;
	}

	/**
	 * @param nomeMae the nomeMae to set
	 */
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	/**
	 * @return the estilo
	 */
	public String getEstilo() {
		return estilo;
	}

	/**
	 * @param estilo the estilo to set
	 */
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	
	

	/**
	 * @return the naturalidade
	 */
	public String getNaturalidade() {
		return naturalidade;
	}

	/**
	 * @param naturalidade the naturalidade to set
	 */
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codCliente == null) ? 0 : codCliente.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codCliente == null) {
			if (other.codCliente != null)
				return false;
		} else if (!codCliente.equals(other.codCliente))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
	
	

}
