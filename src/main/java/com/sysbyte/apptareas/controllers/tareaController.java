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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author matia
 */
@Controller
@SessionAttributes("tarea")
public class tareaController {

    @Autowired
    private ITareaService tareaService;

    private List<Tarea> tareasVencidas;

    @GetMapping("/tarea")
    public String agregarTarea(Map m) {

        comprobarVencimiento();

        m.put("tareasVencidas", tareasVencidas);

        Tarea tarea = new Tarea();

        m.put("tarea", tarea);

        return "tarea";
    }

    @GetMapping("/tarea/{id}")
    public String modificarTarea(@PathVariable int id, Map m) {

        comprobarVencimiento();

        m.put("tareasVencidas", tareasVencidas);

        Tarea tarea = tareaService.buscarTareaPorId(id);

        m.put("tarea", tarea);

        return "tarea";
    }

    @PostMapping("/tarea")
    public String guardarTarea(@Valid Tarea tarea, Map m) {
        tareaService.guardarTarea(tarea);

        return "redirect:/";
    }

     public void comprobarVencimiento() {

        tareasVencidas = new ArrayList<>();

        Date date = new Date();

        List<Tarea> listarTodo = tareaService.listar();

        for (int i = 0; i < listarTodo.size(); i++) {
            if (listarTodo.get(i).getVencimiento().getTime() < date.getTime()) {
                tareasVencidas.add(listarTodo.get(i));
            }
        }

    }

}
