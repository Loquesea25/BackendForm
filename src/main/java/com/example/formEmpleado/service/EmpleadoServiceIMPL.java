package com.example.formEmpleado.service;

import com.example.formEmpleado.entity.Empleado;
import com.example.formEmpleado.repository.IEmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceIMPL implements IEmpleadoService{

    @Autowired
    private IEmpleadoRepositorio iEmpleadoRepositorio;
    @Override
    public List<Empleado> mostrarEmpleados() {
        return (List<Empleado>) this.iEmpleadoRepositorio.findAll();
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        empleado.setNombre(empleado.getNombre());
        return this.iEmpleadoRepositorio.save(empleado);
    }

    @Override
    public Empleado modificarEmpleado(long id, Empleado empleado) {
         this.iEmpleadoRepositorio.findById(id).get();
        return this.iEmpleadoRepositorio.save(new Empleado());
    }
    /*@Override
    public Empleado modificarEmpleado(Empleado empleado) {
        return this.iEmpleadoRepositorio.save(empleado);
    }*/

    @Override
    public Empleado buscarEmpleadoPorId(long id) {
        return this.iEmpleadoRepositorio.findById(id).get();
    }

    @Override
    public void eliminarEmpleadoPorId(long id) {
         this.iEmpleadoRepositorio.deleteById(id);
    }
}
