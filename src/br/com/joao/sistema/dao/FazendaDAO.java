package br.com.joao.sistema.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.joao.sistema.bean.Fazenda;
import br.com.joao.sistema.util.HibernateUtil;

/**
 *
 * @author jgil
 */
public class FazendaDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Fazenda> buscarTodos() throws Exception {
        ArrayList<Fazenda> listaRetorno = new ArrayList<Fazenda>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Fazenda.class);
        criteria.addOrder(Order.asc("idFazenda"));
        listaRetorno = (ArrayList<Fazenda>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Fazenda> buscarTodos(String login) throws Exception {
        ArrayList<Fazenda> listaRetorno = new ArrayList<Fazenda>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Fazenda.class);
        criteria.add(Restrictions.ilike("login", login));
        criteria.addOrder(Order.asc("idFazenda"));
        listaRetorno = (ArrayList<Fazenda>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Fazenda buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Fazenda fazenda = (Fazenda) sessao.get(Fazenda.class, codigo);
        sessao.close();
        return fazenda;
    }

    public ArrayList<Fazenda> buscarNome(String nome) throws Exception {

        ArrayList<Fazenda> listaRetorno = new ArrayList<Fazenda>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Fazenda.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Fazenda>) criteria.list();

        return listaRetorno;
    }
}
