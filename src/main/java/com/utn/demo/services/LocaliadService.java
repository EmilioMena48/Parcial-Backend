package com.utn.demo.services;

import com.utn.demo.entities.Autor;
import com.utn.demo.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocaliadService extends BaseService<Localidad, Long> {
    List<Localidad> searchJPQLnombrado(String filtro) throws Exception;
    Page<Localidad> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception;
}
