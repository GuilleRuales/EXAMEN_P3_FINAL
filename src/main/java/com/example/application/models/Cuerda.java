package com.example.application.models;


import java.util.Scanner;

public class Cuerda extends Producto {


    public String cantidadCuerdas;
    public String tipo;


    public Cuerda() {
    }

    public Cuerda(String nombre, String codigo, String marca, String color, String material,
                  String calidad, double precio, int stock, String categoria, String cantidadCuerdas, String tipo) {
        super(nombre, codigo, marca, color, material, calidad, precio, stock, categoria);
        this.cantidadCuerdas = cantidadCuerdas;
        this.tipo = tipo;
    }

    public String getCantidadCuerdas() {
        return cantidadCuerdas;
    }

    public void setCantidadCuerdas(String cantidadCuerdas) {
        this.cantidadCuerdas = cantidadCuerdas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        System.out.println("Ingrese la cantidad de cuerdas del producto");
        this.cantidadCuerdas= sc.next();
        System.out.println("Ingrese el tipo del producto (Acustico o Electrico)");
        this.tipo = sc.next();
    }
}