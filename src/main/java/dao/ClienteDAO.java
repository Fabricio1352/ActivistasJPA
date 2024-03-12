/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import datos.Cliente;
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
public class ClienteDAO {

    private final EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Cliente> buscarPorNombre(String letra) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);

        // Se define el predicado para la búsqueda por nombre
        Predicate predicado = criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(root.get("apMaterno")), letra.toLowerCase() + "%"),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("apMaterno")), "%" + letra.toLowerCase()),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("apPaterno")), letra.toLowerCase() + "%"),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("apPaterno")), "%" + letra.toLowerCase())
        );
        criteriaQuery.where(predicado);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
