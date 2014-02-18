package br.com.rinete.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.rinete.model.Cliente;
import br.com.rinete.util.HibernateUtil;



public class ClienteDAO {
	
	private Session sessao;
	
	private Transaction transacao;
	
	public void salvar(Cliente cliente) throws HibernateException{
		try{
			SessionFactory session = HibernateUtil.getSessionfactory();
			this.sessao = session.openSession();
			this.transacao = sessao.beginTransaction();
			this.sessao.saveOrUpdate(cliente);
			this.transacao.commit(); 
		}catch (HibernateException e) {
			this.transacao.rollback();
		}finally {
			this.sessao.close();
		}
	}
	
	public void atualizar(Cliente cliente) throws HibernateException{
		try{
			this.sessao = HibernateUtil.getSessionfactory().getCurrentSession();
			this.transacao = sessao.beginTransaction();
			this.sessao.update(cliente);
			this.transacao.commit(); 
		}catch (HibernateException e) {
			this.transacao.rollback();
		}finally {
			this.sessao.close();
		}
	}
	
	public void excluir(Cliente cliente) throws HibernateException{
		try{
			this.sessao = HibernateUtil.getSessionfactory().openSession();
			this.transacao = sessao.beginTransaction();
			this.sessao.delete(cliente);
			this.transacao.commit(); 
		}catch (HibernateException e) {
			this.transacao.rollback();
		}finally {
			this.sessao.close();
		}
	}

	public List<Cliente> listar() {
		List<Cliente> clientes = null;
		Query consulta = null;
		try{
			this.sessao = HibernateUtil.getSessionfactory().openSession();
			consulta = sessao.createQuery("from Cliente c order by c.codCliente desc");
			clientes = consulta.list();
		}catch (HibernateException e) {
			this.transacao.rollback();
		}finally {
			this.sessao.close();
		}
		return clientes;
		
	}

	public List<Cliente> listar(String nomeCliente) {
		List<Cliente> clientes = null;
		Query consulta = null;
		try{
			this.sessao = HibernateUtil.getSessionfactory().openSession();
			consulta = sessao.createQuery("from Cliente c where  c.nomeCliente like ?");
			consulta.setString(0, "%"+nomeCliente+"%");
			clientes = consulta.list();
		}catch (HibernateException e) {
			this.transacao.rollback();
		}finally {
			this.sessao.close();
		}
		return clientes;
	}

	public List<Cliente> recuperaAniversariantesDoMes() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = null;
		Query consulta = null;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM");
		try{
			Date hoje = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(hoje);
			int dataInicio = c.get(Calendar.MONTH) + 1 ;
			this.sessao = HibernateUtil.getSessionfactory().openSession();
			consulta = sessao.createQuery("from Cliente c where month(c.dtNascimento) = " + dataInicio + "order by day(c.dtNascimento), c.nomeCliente");
			clientes = consulta.list();
		}catch (HibernateException e) {
			this.transacao.rollback();
		}finally {
			this.sessao.close();
		}
		return clientes;
	}



}
