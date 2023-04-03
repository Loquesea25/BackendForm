package com.example.formEmpleado.controller;

import com.example.formEmpleado.entity.Empleado;
import com.example.formEmpleado.excepciones.ResourceNotFoundException;
import com.example.formEmpleado.repository.IEmpleadoRepositorio;
import com.example.formEmpleado.service.EmpleadoServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/empleado")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceIMPL empleadoServiceIMPL;
    @Autowired
    private IEmpleadoRepositorio iEmpleadoRepositorio;

    @GetMapping
    @RequestMapping(value = "mostrarEmpleados", method = RequestMethod.GET)
    public ResponseEntity<?> mostrarEmpleados(){
        List<Empleado> listaEmpleados = this.empleadoServiceIMPL.mostrarEmpleados();
        return ResponseEntity.ok(listaEmpleados);
    }

    @PostMapping
    @RequestMapping(value = "crearEmpleado", method = RequestMethod.POST)
    public ResponseEntity<?> crearEmpleado(@RequestBody Empleado empleado){
        Empleado empleadoCreado = this.empleadoServiceIMPL.crearEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
    }

    @PutMapping
    @RequestMapping(value = "modificarEmpleado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Empleado> modificarEmpleado(@PathVariable long id, @RequestBody Empleado detallesEmpleado){
        Empleado empleado = iEmpleadoRepositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado no existepor el id" + id));
        empleado.setNombre(detallesEmpleado.getNombre());
        empleado.setApellido(detallesEmpleado.getApellido());
        empleado.setEdad(detallesEmpleado.getEdad());
        empleado.setEmail(detallesEmpleado.getEmail());

        Empleado empleadoActualizado = iEmpleadoRepositorio.save(empleado);
        return ResponseEntity.ok(empleado);
    }

    /*@PutMapping
    @RequestMapping(value = "modificarEmpleado", method = RequestMethod.PUT)
    public ResponseEntity<?> modificarEmpleado(@RequestBody Empleado empleado){
        Empleado empleadoModificado = this.empleadoServiceIMPL.modificarEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoModificado);
    }*/

    @GetMapping
    @RequestMapping(value = "buscarEmpleadoPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarEmpleadoPorId(@PathVariable long id){
        Empleado empleado = this.empleadoServiceIMPL.buscarEmpleadoPorId(id);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping
    @RequestMapping(value = "eliminarEmpleadoPorId/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarEmpleadoPorId(@PathVariable long id){
        this.empleadoServiceIMPL.eliminarEmpleadoPorId(id);
        return ResponseEntity.ok().build();
    }
}
