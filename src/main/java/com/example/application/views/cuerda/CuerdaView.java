package com.example.application.views.cuerda;

import com.example.application.Utils.Util;
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

    public CuerdaView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        TextField textField5 = new TextField();
        TextField textField6 = new TextField();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        ComboBox comboBox3 = new ComboBox();
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
        textField.setLabel("Nombre");
        textField.setWidth("380px");
        textField.setRequired(true);
        textField.setErrorMessage("Campo Obligatorio");
        textField2.setLabel("Codigo");
        textField2.setWidth("380px");
        textField2.setRequired(true);
        textField2.setErrorMessage("Campo Obligatorio");
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        textField3.setLabel("Precio");
        textField3.setWidth("380px");
        textField3.setRequired(true);
        textField3.setErrorMessage("Campo Obligatorio");
        textField4.setLabel("Stock");
        textField4.setWidth("380px");
        textField4.setRequired(true);
        textField4.setErrorMessage("Campo Obligatorio");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        textField5.setLabel("Marca");
        textField5.setWidth("380px");
        textField5.setRequired(true);
        textField5.setErrorMessage("Campo Obligatorio");
        textField6.setLabel("Color");
        textField6.setWidth("380px");
        textField6.setRequired(true);
        textField6.setErrorMessage("Campo Obligatorio");
        layoutRow4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");

        comboBox.setLabel("Gama");
        comboBox.setWidth("380px");
        comboBox.setHeight("70px");
        setComboBoxSampleData(comboBox);
        comboBox.setRequired(true);
        comboBox.setErrorMessage("Campo Obligatorio");

        comboBox2.setLabel("No Cuerdas");
        comboBox2.setWidth("380px");
        setComboBox2SampleData(comboBox2);
        comboBox2.setRequired(true);
        comboBox2.setErrorMessage("Campo Obligatorio");

        comboBox3.setLabel("Tipo");
        comboBox3.setWidth("380px");
        setComboBox3SampleData(comboBox3);
        comboBox3.setRequired(true);
        comboBox3.setErrorMessage("Campo Obligatorio");

        layoutRow5.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");

        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        guardar.addClickListener(event -> {

            if (!textField.isEmpty() && !textField2.isEmpty() && !textField3.isEmpty()
                    && !textField4.isEmpty() && !textField5.isEmpty() && !textField6.isEmpty()
                    && !comboBox.isEmpty() && !comboBox2.isEmpty() && !comboBox3.isEmpty()
            ){
            // Obtener los valores de los campos y guardar en la lista de productos

            String nombre = textField.getValue();
            String codigo = textField2.getValue();
            double precio = Float.parseFloat(textField3.getValue());
            Integer stock = Integer.valueOf(textField4.getValue());
            String marca = textField5.getValue();
            String color = textField6.getValue();

            SampleItem selectedItem = (SampleItem) comboBox.getValue();
            String gama = selectedItem != null ? selectedItem.label() : null;

            SampleItem selectedItem2 = (SampleItem) comboBox2.getValue();
            String cantidadCuerdas = selectedItem2 != null ? selectedItem2.label() : null;

            SampleItem selectedItem3 = (SampleItem) comboBox3.getValue();
            String tipo = selectedItem3 != null ? selectedItem3.label() : null;

            // Crear una nueva instancia de Producto

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
            cuerda.setCantidadCuerdas(Integer.parseInt(cantidadCuerdas));

            Util.listaProducto.add(cuerda);

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
        layoutRow.add(textField);
        layoutRow.add(textField2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(textField3);
        layoutRow2.add(textField4);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(textField5);
        layoutRow3.add(textField6);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(comboBox);
        layoutRow4.add(comboBox2);
        layoutColumn2.add(comboBox3);
        layoutColumn2.add(layoutRow5);
        layoutRow5.add(guardar);
        layoutRow5.add(btcancelar);
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String codigo) {

    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("alta", "Alta", null));
        sampleItems.add(new SampleItem("media", "Media", null));
        sampleItems.add(new SampleItem("baja", "Baja", Boolean.TRUE));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBox2SampleData(ComboBox comboBox2) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("4", "4", null));
        sampleItems.add(new SampleItem("6", "6", null));
        comboBox2.setItems(sampleItems);
        comboBox2.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBox3SampleData(ComboBox comboBox3) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("acustico", "Acustico", null));
        sampleItems.add(new SampleItem("electrico", "Electrico", null));
        comboBox3.setItems(sampleItems);
        comboBox3.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

}