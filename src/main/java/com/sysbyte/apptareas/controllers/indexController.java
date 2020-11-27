/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysbyte.apptareas.controllers;

import com.sysbyte.apptareas.models.entities.Tarea;
import com.sysbyte.apptareas.models.services.ITareaService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author matia
 */
@Controller
public class indexController {

    @Autowired
    private ITareaService tareaService;

    private List<Tarea> tareasVencidas;

    @GetMapping({"/index", "/"})
    public String principal(Map m) {

        comprobarVencimiento();

        List<Tarea> tareas = tareaService.listar();

        m.put("tareas", tareas);

        m.put("tareasVencidas", tareasVencidas);

        return "index";
    }

    public void comprobarVencimiento() {

        tareasVencidas = new ArrayList<>();

        Date date = new Date();

        List<Tarea> listarTodo = tareaService.listar();

        int contador = 0;

        for (int i = 0; i < listarTodo.size(); i++) {
            if (listarTodo.get(i).getVencimiento().getTime() < date.getTime()) {
                tareasVencidas.add(listarTodo.get(i));
            }
        }

    }

}
