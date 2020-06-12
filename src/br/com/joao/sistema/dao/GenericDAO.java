package br.com.joao.sistema.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.joao.sistema.util.HibernateUtil;

/**
 *
 * @author pbido
 */
public abstract class GenericDAO {

    @SuppressWarnings("finally")
    public boolean salvar(Object object) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(object);
            transacao.commit();
        } catch (Exception e) {
            transacao.rollback();
            return false;
        } finally {
            sessao.close();
            return true;
        }
    }

    public void excluir(Object object) {
        Session sessao = null;
        Transaction transacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(object);
            transacao.commit();
        } catch (Exception e) {
            transacao.rollback();
        } finally {
            sessao.close();
        }
    }
}
