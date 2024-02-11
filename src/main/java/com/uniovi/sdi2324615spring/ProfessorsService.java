package com.uniovi.sdi2324615spring;

import com.uniovi.sdi2324615spring.Professor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorsService {
    private List<Professor> professors;

    public ProfessorsService() {
        professors = new ArrayList<>();
        // Agregar profesores por defecto
        professors.add(new Professor("12345678A", "Juan", "Pérez", "Profesor Titular"));
        professors.add(new Professor("98765432B", "María", "Gómez", "Catedrático"));
        // Agregar más profesores si es necesario
    }

    public List<Professor> getAllProfessors() {
        return professors;
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void deleteProfessor(String dni) {
        professors.removeIf(professor -> professor.getDni().equals(dni));
    }
}

