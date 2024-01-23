package com.example.application.services;

import com.example.application.models.Cuerda;
import com.example.application.models.Percusion;
import com.example.application.models.Producto;
import com.example.application.models.Viento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private ProductoRepository productoRepository;
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    public List<Producto> listaproductos() {
        List<Producto> listaProductos = new ArrayList<>();
        try {
            listaProductos = productoRepository.findAll();
        } catch (Exception e) {
            System.out.println("No se pudo conectar con la base de datos");
        }
        return listaProductos;
    }

    public Producto obtenerPorCodigo (String codigo) {
        Producto producto = null;
        try {
            producto = productoRepository.findByCodigo(codigo);
        } catch (Exception e) {
            System.out.println("No se encontro un producto con ese codigo");
        }
        return producto;
    }

    public void agregarProducto(Producto producto) {
        try {
            productoRepository.save(producto);
        } catch (Exception e) {
            System.out.println("No se puede guardar el producto");
        }
    }

    public void borrarProducto(String codigo) {
        try {
            Producto producto = productoRepository.findByCodigo(codigo);
            productoRepository.delete(producto);
        } catch (Exception e) {
            System.out.println("No se puede encontrar el producto a borrar");
            System.out.println(e);
        }
    }

    public void editarProductoViento (String codigo, Viento viento) {

        try {

            Viento vientoEditar = (Viento) productoRepository.findByCodigo(codigo);
            vientoEditar.nombre = viento.nombre;
            vientoEditar.precio = viento.precio;
            vientoEditar.stock = viento.stock;
            vientoEditar.marca = viento.marca;
            vientoEditar.color = viento.color;
            vientoEditar.material = viento.material;
            vientoEditar.calidad = viento.calidad;

            productoRepository.save(vientoEditar);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se puede encontrar el producto a ser editado");
        }
    }

    public void editarProductoPercusion (String codigo, Percusion percusion) {

        try {

            Percusion percusionEditar = (Percusion) productoRepository.findByCodigo(codigo);
            percusionEditar.nombre = percusion.nombre;
            percusionEditar.precio = percusion.precio;
            percusionEditar.stock = percusion.stock;
            percusionEditar.marca = percusion.marca;
            percusionEditar.color = percusion.color;
            percusionEditar.material = percusion.material;
            percusionEditar.tipo = percusion.tipo;
            percusionEditar.calidad = percusion.calidad;

            productoRepository.save(percusionEditar);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se puede encontrar el producto a ser editado");
        }
    }

    public void editarProductoCuerda (String codigo, Cuerda cuerda) {

        try {

            Cuerda cuerdaEditar = (Cuerda) productoRepository.findByCodigo(codigo);
            cuerdaEditar.nombre = cuerda.nombre;
            cuerdaEditar.precio = cuerda.precio;
            cuerdaEditar.stock = cuerda.stock;
            cuerdaEditar.marca = cuerda.marca;
            cuerdaEditar.color = cuerda.color;
            cuerdaEditar.cantidadCuerdas = cuerda.cantidadCuerdas;
            cuerdaEditar.tipo = cuerda.tipo;
            cuerdaEditar.calidad = cuerda.calidad;

            productoRepository.save(cuerdaEditar);

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se puede encontrar el producto a ser editado");
        }
    }

}