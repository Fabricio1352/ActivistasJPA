/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package chavez.alma.activistasjpa;

import dao.ActivistaDAO;
import dao.ClienteDAO;
import dao.ProblemaDAO;
import datos.Activista;
import datos.Cliente;
import datos.Direccion;
import datos.Problema;
import java.util.Date;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Laboratorios
 */
public class ActivistasJPA {

    public static void main(String[] args) {

        EntityManagerFactory mf = Persistence.createEntityManagerFactory("activistasPU");
        EntityManager em = mf.createEntityManager();
        em.getTransaction().begin();

        ClienteDAO clienteDao = new ClienteDAO(em);
        ActivistaDAO activistaDao = new ActivistaDAO(em);
        ProblemaDAO problemaDao = new ProblemaDAO(em);

        //Método para buscar una lista de Clientes que su apellido inicie o termine con la letra A. 
        System.out.println(clienteDao.buscarPorNombre("a"));

        //Método para buscar una lista de Problemas cuyo nombre que contengan la palabra ‘Contaminación’.
        System.out.println(problemaDao.buscarPorNombre("contaminacion"));

        //Método para buscar una lista de Activistas que hayan entrado entre enero del año 2024 y marzo del 2024.
        System.out.println(activistaDao.buscarEntreFechas(new Date(124, 0, 1), new Date(124, 2, 31)));

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        CREAR ACTIVISTA
//        Activista activista = new Activista("Ramiro", "Perez", "López", "77777777", new GregorianCalendar(2020, 1, 15));
//        em.persist(activista);w
//
//        em.getTransaction().commit();
//        Problema problema = new Problema();
//        Problema problema2 = new Problema();
//        em.persist(problema);
//        em.persist(problema2);
//
//        Set<Problema> problemas = new HashSet<>();
//        problemas.add(problema);
//        problemas.add(problema2);
//
//        activista.setActivistasProblemas(problemas);
//        em.persist(activista);
//        
//        System.out.println(activista.toString());
//        em.getTransaction().commit();

        /* BUSCAR Y ACTUALIZAR
        Activista a = em.find(Activista.class, 5L);
        if(a != null){
           a.setApMaterno("Dominguez");
           a.setTelefono("6444778895");
           em.persist(a);
        }else{
            System.out.println("Activista no encontrado");
        }
        em.getTransaction().commit();
         */
 /* ELIMINAR ACTIVISTA
        Activista a = em.find(Activista.class, 3L);
        if(a != null){
            em.remove(a);
            System.out.println("Activista eliminado:)");
        }else{
            System.out.println("Activista no encontrado");
        }
        em.getTransaction().commit();
         */
 /*
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Activista.class));
        Query query = em.createQuery(criteria);
        List<Activista> activistas = query.getResultList();
        for (Activista activista : activistas) {
            System.out.println(activista.toString());
        }
        em.getTransaction().commit();
         */
//        Cliente c = new Cliente();
//        c.setNombres("Lourdes");
//        c.setApPaterno("Torres");
//        c.setApMaterno("Núñez");
//        Direccion d = new Direccion("Wallaby", "Villa Alegría", 85000L, 962L, c);
//        List<Direccion> ds = new ArrayList(); 
//        ds.add(d);
//        c.setDirecciones(ds);
//        em.persist(c);
//        em.getTransaction().commit();
    }
}
