package com.example.application.services;

import com.example.application.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
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
        }
    }

    public void editarProducto(String codigo, Producto producto) {
        try {
            Producto productoEditar = productoRepository.findByCodigo(codigo);
            if (codigo != null) {
                productoEditar.setNombre(producto.getNombre());
                productoEditar.setPrecio(producto.getPrecio());
                productoEditar.setMarca(producto.getMarca());
                productoEditar.setStock(producto.getStock());
                productoEditar.setColor(producto.getColor());
                //productoEditar.setMaterial(producto.getMaterial());
            }
        } catch (Exception e) {
            System.out.println("No se puede encontrar el producto a ser editado");
        }
    }



}
