package com.apirest2.crud.services;

import com.apirest2.crud.models.Autos;
import com.apirest2.crud.repositories.IAutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoServices {

    private IAutosRepository autoRepo;
    @Autowired

    public AutoServices(IAutosRepository autoRepo){
        this.autoRepo = autoRepo;
    }

    //Metodo para crear autos
    public void crearAuto(Autos autos){
        autoRepo.save(autos);
    }

    //Listar todos los metodos
    public List<Autos> listarAutos(){
        return autoRepo.findAll();
    }

    //Buscar auto por id - Optional, porque si no existe, nos enviara una excepcion
    public Optional<Autos> buscarPorId(Long id){
        return autoRepo.findById(id);
    }

    //Actualizar auto
    public void actualizarAuto (Autos auto){
        autoRepo.save(auto);
    }

    //Eliminar auto
    public void eliminarAuto (Long id){
        autoRepo.deleteById(id);
    }

    //Para buscar segun atribustos de la clase, estos son los que están en el repo
    public List<Autos> buscarPorModelo(String modelo){
        return autoRepo.findByModelo(modelo);
    }

}
