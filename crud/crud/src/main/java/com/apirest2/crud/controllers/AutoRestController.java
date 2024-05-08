package com.apirest2.crud.controllers;

import com.apirest2.crud.models.Autos;
import com.apirest2.crud.services.AutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autos")
public class AutoRestController {
    private AutoServices autoServices;

    @Autowired
    public AutoRestController(AutoServices autoServices) {
        this.autoServices = autoServices;
    }

    // escribir hasta el final porque dará error
    @PostMapping(value="/crear",headers = "Accept=application/json")
    public void crearAuto(@RequestBody Autos autos){
        autoServices.crearAuto(autos);
    }

    @GetMapping(value = "/listar", headers = "Accept=application/json")
    public List<Autos> listarAutos(){
        return autoServices.listarAutos();
    }

    @GetMapping(value = "/listarPorId/{id}" , headers = "Accept=application/json")
    public Optional<Autos> buscarPorId(@PathVariable Long id){
        return autoServices.buscarPorId(id);
    }

    @PutMapping(value = "/actualizar" , headers = "Accept=application/json")
    public void actualizarAutos(@RequestBody Autos auto){
        autoServices.actualizarAuto(auto);
    }

    @DeleteMapping(value="/eliminar/{id}", headers = "Accept=application/json")
    public void eliminarauto(@PathVariable Long id){
        autoServices.eliminarAuto(id);
    }

    @GetMapping(value ="/listarModel/{model}", headers = "Accept=application/json")
    public List<Autos> listarPorModelo(@PathVariable String model){
        return autoServices.buscarPorModelo(model);
    }

}
