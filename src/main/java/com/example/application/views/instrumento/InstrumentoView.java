package com.example.application.views.instrumento;

import com.example.application.Utils.Util;
import com.example.application.services.ProductoService;
import com.example.application.views.MainLayout;
import com.example.application.views.cuerda.CuerdaView;
import com.example.application.views.nuevoinstrumento.NuevoInstrumentoView;
import com.example.application.views.percusion.PercusionView;
import com.example.application.views.viento.VientoView;
import com.example.application.models.Producto;
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
import com.vaadin.flow.router.RouteParameters;


import java.util.List;

@PageTitle("Instrumento")
@Route(value = "instrumento", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class InstrumentoView extends Composite<VerticalLayout> {

    private ProductoService productoService;
    public InstrumentoView(ProductoService productoService) {

        this.productoService = productoService;

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
        //grid.addColumn(Producto::getTipo).setHeader("Tipo").setSortable(true).setAutoWidth(true);

        grid.addColumn(
                new ComponentRenderer<>(producto -> {
                    // Botón para eliminar
                    Button botonBorrar = new Button();
                    botonBorrar.addThemeVariants(ButtonVariant.LUMO_ERROR);
                    botonBorrar.setIcon(new Icon(VaadinIcon.TRASH));
                    botonBorrar.addClickListener(e -> {
                        productoService.borrarProducto(producto.codigo);
                        grid.getDataProvider().refreshAll();
                    });
                    // Botón para editar
                    Button botonEditar = new Button();
                    botonEditar.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
                    botonEditar.addClickListener(e -> {
                        botonEditar.getUI().ifPresent(ui -> {
                            String tipoProducto = producto.getCategoria();
                            if ("Cuerda".equals(tipoProducto)) {
                                ui.navigate(CuerdaView.class, producto.codigo);
                            } else if ("Viento".equals(tipoProducto)) {
                                ui.navigate(VientoView.class, producto.codigo);
                            } else if ("Percusion".equals(tipoProducto)) {
                                ui.navigate(PercusionView.class, producto.codigo);;
                            }
                        });
                    });
                    botonEditar.setIcon(new Icon(VaadinIcon.EDIT));

                    /*
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

                    HorizontalLayout buttons = new HorizontalLayout(botonBorrar,botonEditar);
                    return buttons;
                })).setHeader("Manage").setAutoWidth(true);

        List<Producto> producto = productoService.listaproductos();
        grid.setItems(producto);
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        getContent().add(buttonPrimary,grid);
    }
}
