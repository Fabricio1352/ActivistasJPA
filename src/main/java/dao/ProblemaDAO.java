/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import datos.Problema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author fabri
 */
public class ProblemaDAO {

    private final EntityManager entityManager;

    public ProblemaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public List<Problema> buscarPorNombre(String nombre) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Problema> criteriaQuery = criteriaBuilder.createQuery(Problema.class);
        Root<Problema> root = criteriaQuery.from(Problema.class);

        Predicate predicado = criteriaBuilder.like(criteriaBuilder.lower(root.get("descripcion")), "%" + nombre.toLowerCase() + "%");
        criteriaQuery.where(predicado);
        return entityManager.createQuery(criteriaQuery).getResultList();

    }

    //Método para buscar una lista de Problemas cuyo nombre que contengan la palabra ‘Contaminación’. 
}
