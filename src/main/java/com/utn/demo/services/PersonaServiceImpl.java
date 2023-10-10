package com.utn.demo.services;

import com.utn.demo.entities.Persona;
import com.utn.demo.repositories.BaseRepository;
import com.utn.demo.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository) {
        super(baseRepository);
    }
    @Override
    public List<Persona> searchMetodoQuery(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchMetodoQuery(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchJPQLIndexado(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.search(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchJPQLIndexado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.search(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchJPQLnombrado(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.search2(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchJPQLnombrado(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.search2(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Persona> searchNativo(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.search1(filtro);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> searchNativo(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.search1(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Persona searchDNI(int dni) throws Exception {
        try {
            boolean existePersona = personaRepository.existsByDni(dni);
            if(existePersona) {
                Persona persona = personaRepository.findByDni(dni);
                return persona;
            }  else {
                throw new Exception("No se encontró la persona con el DNI indicado");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}