package com.example.application.models;

import java.util.Scanner;

public class Viento extends Producto{

    String material;

    public Viento() {
    }

    public Viento(String nombre, String codigo, String marca, String color, String material,
                  String calidad, double precio, int stock, String categoria, String material1) {
        super(nombre, codigo, marca, color, material, calidad, precio, stock, categoria);
        this.material = material1;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void ingresarDatos(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto: ");
        this.nombre = sc.next();
        System.out.println("Ingrese el codigo del producto: ");
        this.codigo = sc.next();
        System.out.println("Ingrese el precio del producto");
        this.precio = sc.nextDouble();
        System.out.println("Ingrese el stock del producto");
        this.stock = sc.nextInt();
        System.out.println("Ingrese la marca del producto");
        this.marca = sc.next();
        System.out.println("Ingrese el color del producto");
        this.color = sc.next();
        System.out.println("Ingrese la calidad del producto");
        this.calidad = sc.next();


    }

}