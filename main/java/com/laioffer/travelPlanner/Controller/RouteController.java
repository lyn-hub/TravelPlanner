package com.laioffer.travelPlanner.Controller;

import com.laioffer.travelPlanner.Service.RouteService;
import com.laioffer.travelPlanner.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RouteController {
    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/getAllRoutes", method = RequestMethod.GET)
    public ModelAndView getAllRoutes(@RequestParam("email") String email) {
        List<Route> routes = routeService.getRouteByUserEmail(email);
        return new ModelAndView("routeList", "routes", routes);
    }

    @RequestMapping(value = "/delete/{routeId}")
    public void deleteRoute (@PathVariable(value = "routeId") int routeId) {
        routeService.deleteRouteById(routeId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRoute (@ModelAttribute Route route, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        routeService.addRoute(route);
        return "redirect://getAllRoutes";
    }
}
