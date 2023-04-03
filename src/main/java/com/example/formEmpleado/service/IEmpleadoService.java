package com.example.formEmpleado.service;

import com.example.formEmpleado.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> mostrarEmpleados();
    public Empleado crearEmpleado(Empleado empleado);
    public Empleado modificarEmpleado(long id, Empleado empleado);
    /*public Empleado modificarEmpleado(Empleado empleado);*/
    public Empleado buscarEmpleadoPorId(long id);
    public void eliminarEmpleadoPorId(long id);
}
