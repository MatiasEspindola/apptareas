/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sysbyte.apptareas.models.repository;

import com.sysbyte.apptareas.models.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author matia
 */
public interface ITareaRepo extends JpaRepository<Tarea, Integer>{
    
}
