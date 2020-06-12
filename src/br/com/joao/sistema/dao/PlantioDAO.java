package br.com.joao.sistema.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.joao.sistema.bean.Plantio;
import br.com.joao.sistema.util.HibernateUtil;

/**
 *
 * @author jgil
 */
public class PlantioDAO extends GenericDAO {

    @SuppressWarnings("unchecked")
    public ArrayList<Plantio> buscarTodos() throws Exception {
        ArrayList<Plantio> listaRetorno = new ArrayList<Plantio>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Plantio.class);
        criteria.addOrder(Order.asc("idPlantio"));
        listaRetorno = (ArrayList<Plantio>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Plantio> buscarTodos(String login) throws Exception {
        ArrayList<Plantio> listaRetorno = new ArrayList<Plantio>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Plantio.class);
        criteria.add(Restrictions.ilike("login", login));
        criteria.addOrder(Order.asc("idPlantio"));
        listaRetorno = (ArrayList<Plantio>) criteria.list();
        sessao.close();
        return listaRetorno;
    }

    public Plantio buscarPorCodigo(int codigo) throws Exception {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Plantio plantio = (Plantio) sessao.get(Plantio.class, codigo);
        sessao.close();
        return plantio;
    }

    public ArrayList<Plantio> buscarNome(String nome) throws Exception {

        ArrayList<Plantio> listaRetorno = new ArrayList<Plantio>();
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = sessao.createCriteria(Plantio.class);
        criteria.add(Restrictions.ilike("nome", nome + "%"));
        criteria.addOrder(Order.asc("nome"));
        listaRetorno = (ArrayList<Plantio>) criteria.list();

        return listaRetorno;
    }
}
