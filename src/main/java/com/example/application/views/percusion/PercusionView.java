package com.example.application.views.percusion;

import com.example.application.Utils.Util;
import com.example.application.models.Viento;
import com.example.application.services.ProductoService;
import com.example.application.views.MainLayout;
import com.example.application.models.Percusion;
import com.example.application.views.cuerda.CuerdaView;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Percusion")
@Route(value = "percusion", layout = MainLayout.class)
@Uses(Icon.class)
public class PercusionView extends Composite<VerticalLayout> implements HasUrlParameter<String> {

    private ProductoService productoService;
    Boolean isNew = true;
    SampleItem sampleItem;
    List<SampleItem> sampleItems = new ArrayList<>();
    SampleItem sampleItem2;
    List<SampleItem> sampleItems2 = new ArrayList<>();

    Percusion percusionEditar;

    TextField nombre;
    TextField codigo;
    TextField precio;
    TextField stock;
    TextField marca;
    TextField color;
    TextField material;

    ComboBox cbtipo;
    ComboBox cbgama;

    public PercusionView(ProductoService productoService) {

        this.productoService = productoService;

        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        nombre = new TextField();
        codigo = new TextField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        precio = new TextField();
        stock = new TextField();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        marca = new TextField();
        color = new TextField();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        material = new TextField();
        cbtipo = new ComboBox();
        cbgama = new ComboBox();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        Button guardar = new Button();
        Button btcancelar = new Button();

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");

        nombre.setLabel("Nombre");
        nombre.setWidth("380px");
        nombre.setRequired(true);
        nombre.setErrorMessage("Campo Obligatorio");
        codigo.setLabel("Codigo");
        codigo.setWidth("380px");
        codigo.setRequired(true);
        codigo.setErrorMessage("Campo Obligatorio");
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        precio.setLabel("Precio");
        precio.setWidth("380px");
        precio.setRequired(true);
        precio.setErrorMessage("Campo Obligatorio");
        stock.setLabel("Stock");
        stock.setWidth("380px");
        stock.setRequired(true);
        stock.setErrorMessage("Campo Obligatorio");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        marca.setLabel("Marca");
        marca.setWidth("380px");
        marca.setRequired(true);
        marca.setErrorMessage("Campo Obligatorio");
        color.setLabel("Color");
        color.setWidth("380px");
        color.setRequired(true);
        color.setErrorMessage("Campo Obligatorio");
        layoutRow4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        material.setLabel("Material");
        material.setWidth("380px");
        material.setRequired(true);
        material.setErrorMessage("Campo Obligatorio");

        cbtipo.setLabel("Tipo");
        cbtipo.setWidth("380px");
        setComboBoxSampleData(cbtipo);
        cbtipo.setRequired(true);
        cbtipo.setErrorMessage("Campo Obligatorio");

        cbgama.setLabel("Gama");
        cbgama.setWidth("380px");
        setComboBox2SampleData(cbgama);
        cbgama.setRequired(true);
        cbgama.setErrorMessage("Campo Obligatorio");

        layoutRow5.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");

        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        guardar.addClickListener(event -> {

            if (!nombre.isEmpty() && !codigo.isEmpty() && !precio.isEmpty()
                    && !stock.isEmpty() && !marca.isEmpty() && !color.isEmpty()
                    && !material.isEmpty() && !cbtipo.isEmpty() && !cbgama.isEmpty()
            ){

                // Obtener los valores de los campos y guardar en la lista de productos
                if (isNew) {
                    String nombre = this.nombre.getValue();
                    String codigo = this.codigo.getValue();
                    double precio = Float.parseFloat(this.precio.getValue());
                    Integer stock = Integer.valueOf(this.stock.getValue());
                    String marca = this.marca.getValue();
                    String color = this.color.getValue();
                    String material = this.material.getValue();

                    SampleItem selectedItem = (SampleItem) cbtipo.getValue();
                    String tipo = selectedItem != null ? selectedItem.label() : null;

                    SampleItem selectedItem2 = (SampleItem) cbgama.getValue();
                    String gama = selectedItem2 != null ? selectedItem2.label() : null;

                    // Crear una nueva instancia de Producto

                    Percusion percusion = new Percusion();

                    // Validar que los campos no estén vacíos antes de guardar

                    percusion.setCategoria("Percusion");
                    percusion.setNombre(nombre);
                    percusion.setCodigo(codigo);
                    percusion.setPrecio(precio);
                    percusion.setStock(stock);
                    percusion.setMarca(marca);
                    percusion.setColor(color);
                    percusion.setMaterial(material);
                    percusion.setTipo(tipo);
                    percusion.setCalidad(gama);

                    productoService.agregarProducto(percusion);

                    // Navegar a la vista de productos después de guardar
                }else{
                    System.out.println("Estoy en edicion");
                    System.out.println(percusionEditar.nombre);
                    percusionEditar.nombre = nombre.getValue();
                    percusionEditar.precio = Float.parseFloat(this.precio.getValue());
                    percusionEditar.stock = Integer.parseInt(stock.getValue());
                    percusionEditar.marca = marca.getValue();
                    percusionEditar.color = color.getValue();
                    percusionEditar.material = material.getValue();

                    SampleItem selectedItem = (SampleItem) cbtipo.getValue();
                    String tipo = selectedItem != null ? selectedItem.label() : null;
                    percusionEditar.tipo = tipo;

                    SampleItem selectedItem2 = (SampleItem) cbgama.getValue();
                    String gama = selectedItem2 != null ? selectedItem2.label() : null;
                    percusionEditar.calidad = gama;

                    productoService.editarProductoPercusion(percusionEditar.codigo, percusionEditar);

                }
                getUI().ifPresent(ui -> ui.navigate("instrumento"));
            }else{
                Notification.show("Error: Debe proporcionar un código de producto");
            }


        });

        btcancelar.setText("Cancelar");
        btcancelar.setWidth("min-content");
        btcancelar.addClickListener(event -> {
            UI.getCurrent().navigate("instrumento");
        });


        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow);
        layoutRow.add(nombre);
        layoutRow.add(codigo);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(precio);
        layoutRow2.add(stock);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(marca);
        layoutRow3.add(color);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(material);
        layoutRow4.add(cbtipo);
        layoutColumn2.add(cbgama);
        layoutColumn2.add(layoutRow5);
        layoutRow5.add(guardar);
        layoutRow5.add(btcancelar);

    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String codigoEditar) {
        if (codigoEditar != null){
            isNew = false;
            percusionEditar = (Percusion) productoService.obtenerPorCodigo(codigoEditar);
            nombre.setValue(percusionEditar.nombre);
            codigo.setValue(percusionEditar.codigo);
            codigo.setEnabled(false);
            precio.setValue(String.valueOf(percusionEditar.precio));
            stock.setValue(String.valueOf(percusionEditar.stock));
            marca.setValue(percusionEditar.marca);
            color.setValue(percusionEditar.color);
            material.setValue(percusionEditar.material);
            sampleItem = sampleItems.stream()
                    .filter(x->x.label.equals(percusionEditar.getTipo()))
                    .findAny()
                    .orElseThrow();
            cbtipo.setValue(sampleItem);

            sampleItem2 = sampleItems2.stream()
                    .filter(x->x.label.equals(percusionEditar.getCalidad()))
                    .findAny()
                    .orElseThrow();
            cbgama.setValue(sampleItem2);

        }else{
            isNew=true;
            System.out.println("codigo nulo");
        }

    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {

        sampleItems.add(new SampleItem("acustico", "Acustico", null));
        sampleItems.add(new SampleItem("electrico", "Electrico", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBox2SampleData(ComboBox comboBox2) {

        sampleItems2.add(new SampleItem("alta", "Alta", null));
        sampleItems2.add(new SampleItem("media", "Media", null));
        sampleItems2.add(new SampleItem("baja", "Baja", Boolean.TRUE));
        comboBox2.setItems(sampleItems2);
        comboBox2.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }



}