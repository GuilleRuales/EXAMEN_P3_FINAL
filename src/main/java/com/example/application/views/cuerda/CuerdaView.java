package com.example.application.views.cuerda;

import com.example.application.Utils.Util;
import com.example.application.services.ProductoService;
import com.example.application.views.MainLayout;
import com.example.application.models.Cuerda;
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

@PageTitle("Cuerda")
@Route(value = "cuerda", layout = MainLayout.class)
@Uses(Icon.class)
public class CuerdaView extends Composite<VerticalLayout> implements HasUrlParameter<String> {

    private ProductoService productoService;
    Boolean isNew = true;
    SampleItem sampleItem;
    List<SampleItem> sampleItems = new ArrayList<>();
    SampleItem sampleItem2;
    List<SampleItem> sampleItems2 = new ArrayList<>();
    SampleItem sampleItem3;
    List<SampleItem> sampleItems3 = new ArrayList<>();

    Cuerda cuerdaEditar;
    TextField nombre;
    TextField codigo;
    TextField precio;
    TextField stock;
    TextField marca;
    TextField color;
    ComboBox cbGama;
    ComboBox cbCuerdas;
    ComboBox cbTipo;


    public CuerdaView(ProductoService productoService) {

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
        cbGama = new ComboBox();
        cbCuerdas = new ComboBox();
        cbTipo = new ComboBox();
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

        cbGama.setLabel("Gama");
        cbGama.setWidth("380px");
        cbGama.setHeight("70px");
        setComboBoxSampleData(cbGama);
        cbGama.setRequired(true);
        cbGama.setErrorMessage("Campo Obligatorio");

        cbCuerdas.setLabel("No Cuerdas");
        cbCuerdas.setWidth("380px");
        setComboBox2SampleData(cbCuerdas);
        cbCuerdas.setRequired(true);
        cbCuerdas.setErrorMessage("Campo Obligatorio");

        cbTipo.setLabel("Tipo");
        cbTipo.setWidth("380px");
        setComboBox3SampleData(cbTipo);
        cbTipo.setRequired(true);
        cbTipo.setErrorMessage("Campo Obligatorio");

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
                    && !cbGama.isEmpty() && !cbCuerdas.isEmpty() && !cbTipo.isEmpty())
            {

                if (isNew) {

                    // Obtener los valores de los campos y guardar en la lista de productos

                    String nombre = this.nombre.getValue();
                    String codigo = this.codigo.getValue();
                    double precio = Float.parseFloat(this.precio.getValue());
                    Integer stock = Integer.valueOf(this.stock.getValue());
                    String marca = this.marca.getValue();
                    String color = this.color.getValue();

                    SampleItem selectedItem = (SampleItem) cbGama.getValue();
                    String gama = selectedItem != null ? selectedItem.label() : null;

                    SampleItem selectedItem2 = (SampleItem) cbCuerdas.getValue();
                    String cantidadCuerdas = selectedItem2 != null ? selectedItem2.label() : null;

                    SampleItem selectedItem3 = (SampleItem) cbTipo.getValue();
                    String tipo = selectedItem3 != null ? selectedItem3.label() : null;

                    // Crear una nueva instancia de Cuerda

                    Cuerda cuerda = new Cuerda();

                    // Validar que los campos no estén vacíos antes de guardar

                    cuerda.setCategoria("Cuerda");
                    cuerda.setNombre(nombre);
                    cuerda.setCodigo(codigo);
                    cuerda.setPrecio(precio);
                    cuerda.setStock(stock);
                    cuerda.setMarca(marca);
                    cuerda.setColor(color);
                    cuerda.setCalidad(gama);
                    cuerda.setTipo(tipo);
                    cuerda.setCantidadCuerdas(cantidadCuerdas);

                    productoService.agregarProducto(cuerda);

                }else{

                    System.out.println("Estoy en edicion");
                    System.out.println(cuerdaEditar.nombre);
                    cuerdaEditar.nombre = nombre.getValue();
                    cuerdaEditar.precio = Float.parseFloat(this.precio.getValue());
                    cuerdaEditar.stock = Integer.parseInt(stock.getValue());
                    cuerdaEditar.marca = marca.getValue();
                    cuerdaEditar.color = color.getValue();

                    SampleItem selectedItem = (SampleItem) cbGama.getValue();
                    String gama = selectedItem != null ? selectedItem.label() : null;
                    cuerdaEditar.calidad = gama;

                    SampleItem selectedItem2 = (SampleItem) cbCuerdas.getValue();
                    String cantidadCuerdas = selectedItem2 != null ? selectedItem2.label() : null;
                    cuerdaEditar.cantidadCuerdas = cantidadCuerdas;

                    SampleItem selectedItem3 = (SampleItem) cbTipo.getValue();
                    String tipo = selectedItem3 != null ? selectedItem3.label() : null;
                    cuerdaEditar.tipo = tipo;

                    productoService.editarProductoCuerda(cuerdaEditar.codigo,cuerdaEditar);

                }

                // Navegar a la vista de productos después de guardar
                getUI().ifPresent(ui -> ui.navigate("instrumento"));

            }else{

                Notification.show("Debe llenar todos los campos");

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
        layoutRow4.add(cbGama);
        layoutRow4.add(cbCuerdas);
        layoutColumn2.add(cbTipo);
        layoutColumn2.add(layoutRow5);
        layoutRow5.add(guardar);
        layoutRow5.add(btcancelar);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String codigoEditar) {
        if (codigoEditar != null){

            isNew = false;
            cuerdaEditar = (Cuerda) productoService.obtenerPorCodigo(codigoEditar);
            nombre.setValue(cuerdaEditar.nombre);
            codigo.setValue(cuerdaEditar.codigo);
            codigo.setEnabled(false);
            precio.setValue(String.valueOf(cuerdaEditar.getPrecio()));
            stock.setValue(String.valueOf(cuerdaEditar.stock));
            marca.setValue(cuerdaEditar.marca);
            color.setValue(cuerdaEditar.color);


            sampleItem = sampleItems.stream()
                    .filter(x->x.label.equals(cuerdaEditar.getCalidad()))
                    .findAny()
                    .orElseThrow();
            cbGama.setValue(sampleItem);

            sampleItem2 = sampleItems2.stream()
                    .filter(x->x.label.equals(cuerdaEditar.getCantidadCuerdas()))
                    .findAny()
                    .orElseThrow();
            cbCuerdas.setValue(sampleItem2);

            sampleItem3 = sampleItems3.stream()
                    .filter(x->x.label.equals(cuerdaEditar.getTipo()))
                    .findAny()
                    .orElseThrow();
            cbTipo.setValue(sampleItem3);

            //cbTipo.setValue(cuerdaEditar.tipo);

        }else{
            isNew = true;
            System.out.println("codigo nulo");
        }

    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {

        sampleItems.add(new SampleItem("alta", "Alta", null));
        sampleItems.add(new SampleItem("media", "Media", null));
        sampleItems.add(new SampleItem("baja", "Baja", Boolean.TRUE));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBox2SampleData(ComboBox comboBox2) {

        sampleItems2.add(new SampleItem("4", "4", null));
        sampleItems2.add(new SampleItem("6", "6", null));
        comboBox2.setItems(sampleItems2);
        comboBox2.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBox3SampleData(ComboBox comboBox3) {

        sampleItems3.add(new SampleItem("acustico", "Acustico", null));
        sampleItems3.add(new SampleItem("electrico", "Electrico", null));
        comboBox3.setItems(sampleItems3);
        comboBox3.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

}
