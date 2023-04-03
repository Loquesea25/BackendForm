package com.example.formEmpleado.repository;

import com.example.formEmpleado.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}
