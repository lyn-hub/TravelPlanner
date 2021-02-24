package com.laioffer.travelPlanner.Service;
import java.util.List;

import com.laioffer.travelPlanner.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laioffer.travelPlanner.dao.RouteDao;

@Service
public class RouteService {
    @Autowired
    private RouteDao routeDao;

    public List<Route> getRouteByUserEmail(String email) {
        return routeDao.getRouteByUserEmail(email);
    }

    public void deleteRouteById (int id) {
        routeDao.deleteRouteById(id);
    }

    public void addRoute (Route route) {
        routeDao.addRoute(route);
    }

}
