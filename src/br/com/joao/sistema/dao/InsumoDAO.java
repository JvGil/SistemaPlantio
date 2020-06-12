package br.com.joao.sistema.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.joao.sistema.bean.Insumo;
import br.com.joao.sistema.util.HibernateUtil;

/**
 *
 * @author jgil
 */
public class InsumoDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Insumo> buscarTodos() throws Exception {
        ArrayList<Insumo> listaRetorno = new ArrayList<Insumo>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Insumo.class);
        criteria.addOrder(Order.asc("idInsumo"));
        listaRetorno = (ArrayList<Insumo>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Insumo> buscarTodos(String login) throws Exception {
        ArrayList<Insumo> listaRetorno = new ArrayList<Insumo>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Insumo.class);
        criteria.add(Restrictions.ilike("login", login));
        criteria.addOrder(Order.asc("idInsumo"));
        listaRetorno = (ArrayList<Insumo>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Insumo buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Insumo insumo = (Insumo) sessao.get(Insumo.class, codigo);
        sessao.close();
        return insumo;
    }

    public ArrayList<Insumo> buscarNome(String nome) throws Exception {

        ArrayList<Insumo> listaRetorno = new ArrayList<Insumo>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Insumo.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Insumo>) criteria.list();

        return listaRetorno;
    }
}
