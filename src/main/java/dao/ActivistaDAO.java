/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import datos.Activista;
import datos.Cliente;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author fabri
 */
public class ActivistaDAO {

    private final EntityManager entityManager;

    public ActivistaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;

    }

    public List<Activista> buscarEntreFechas(Date fechaInicio, Date fechaFinal) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Activista> criteriaQuery = criteriaBuilder.createQuery(Activista.class);
        Root<Activista> root = criteriaQuery.from(Activista.class);

        Predicate predicado = criteriaBuilder.between(root.get("fechaInicioLabores"), fechaInicio, fechaFinal);
        criteriaQuery.where(predicado);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
