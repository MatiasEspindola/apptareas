/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysbyte.apptareas.models.services;

import com.sysbyte.apptareas.models.entities.Tarea;
import java.util.List;

/**
 *
 * @author matia
 */
public interface ITareaService {
    
    public List<Tarea> listar();
    
    public Tarea buscarTareaPorId(int id);
    
    public void guardarTarea(Tarea tarea);
    
}
