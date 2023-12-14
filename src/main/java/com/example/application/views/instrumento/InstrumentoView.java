package com.example.application.views.instrumento;

import com.example.Utils.Util;
import com.example.application.views.MainLayout;
import com.example.models.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.UI;


import java.util.List;

@PageTitle("Instrumento")
@Route(value = "instrumento", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class InstrumentoView extends Composite<VerticalLayout> {

    public InstrumentoView() {
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Nuevo Instrumento");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary.addClickListener(e -> UI.getCurrent().navigate("nuevo-instrumento"));

        Grid<Producto> grid = new Grid<>(Producto.class, false);

        grid.addColumn(Producto::getCategoria).setHeader("Categoria").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getNombre).setHeader("Nombre").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getCodigo).setHeader("Codigo").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getPrecio).setHeader("Precio").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getStock).setHeader("Stock").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getMarca).setHeader("Marca").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getCalidad).setHeader("Gama").setSortable(true).setAutoWidth(true);
        grid.addColumn(Producto::getTipo).setHeader("Tipo").setSortable(true).setAutoWidth(true);

        grid.addColumn(
                new ComponentRenderer<>(producto -> {
                    // Botón para eliminar
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));
                    botonBorrar.addClickListener(e -> {
                        Util.listaProducto.remove(producto);
                        grid.getDataProvider().refreshAll();
                    });
                    /*
                    // Botón para editar
                    Button botonEditar = new Button();
                    botonEditar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                    botonEditar.setIcon(new Icon(VaadinIcon.EDIT));
                    botonEditar.addClickListener(e -> {
                        // Aquí el código para editar el producto
                        // Por ejemplo, abrir un formulario de edición
                    });

                    // Botón para ver
                    Button botonVer = new Button();
                    botonVer.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
                    botonVer.setIcon(new Icon(VaadinIcon.EYE));
                    botonVer.addClickListener(e -> {
                        // Aquí el código para ver el producto
                        // Por ejemplo, abrir un formulario de edición
                    });
                    */
                    // Añadir los botones a un layout horizontal

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Producto> producto = Util.listaProducto;
        grid.setItems(producto);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);
    }
}
