package com.utn.demo.repositories;

import com.utn.demo.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AutorRepository extends BaseRepository<Autor, Long>{

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro%")
    List<Autor> searchAutor(@Param("filtro") String filtro);

    @Query(value = "SELECT a FROM Autor a WHERE a.nombre LIKE %:filtro%")
    Page<Autor> searchAutor(@Param("filtro") String filtro, Pageable pageable);
}
