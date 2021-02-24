package com.laioffer.travelPlanner.dao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laioffer.travelPlanner.entity.Route;
import com.laioffer.travelPlanner.entity.Place;

@Repository
public class RouteDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addRoute(Route route) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Route> getRouteByUserEmail(String email) {
        List<Route> routes = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            routes = session.createCriteria(Route.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return routes;
    }

    public void deleteRouteById(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Route route = session.get(Route.class, id);
            session.delete(route);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}
