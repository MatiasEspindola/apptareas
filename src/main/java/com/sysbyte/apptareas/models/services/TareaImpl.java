/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysbyte.apptareas.models.services;

import com.sysbyte.apptareas.models.entities.Tarea;
import com.sysbyte.apptareas.models.repository.ITareaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author matia
 */

@Service
public class TareaImpl implements ITareaService{

    @Autowired
    private ITareaRepo repo;
    
    @Override
    public List<Tarea> listar() {
        return repo.findAll();
    }

    @Override
    public Tarea buscarTareaPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        repo.save(tarea);
    }
    
    
    
}
