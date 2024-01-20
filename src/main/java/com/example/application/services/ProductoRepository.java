package com.example.application.services;

import com.example.application.models.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository <Producto, String> {

    public Producto findByCodigo(String codigo);

}
