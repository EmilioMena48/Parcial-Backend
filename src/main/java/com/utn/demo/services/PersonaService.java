package com.utn.demo.services;

import com.utn.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long>{
    List<Persona> searchMetodoQuery(String filtro) throws Exception;

    Page<Persona> searchMetodoQuery(String filtro, Pageable pageable) throws Exception;
    List<Persona> searchJPQLIndexado(String filtro) throws Exception;

    Page<Persona> searchJPQLIndexado(String filtro, Pageable pageable) throws Exception;

    List<Persona> searchJPQLnombrado(String filtro) throws Exception;

    Page<Persona> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;


    List<Persona> searchNativo(String filtro) throws Exception;

    Page<Persona> searchNativo(String filtro, Pageable pageable) throws Exception;

    Persona searchDNI(int dni) throws Exception;

}
