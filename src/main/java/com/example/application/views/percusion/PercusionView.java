package com.example.application.views.percusion;

import com.example.Utils.Util;
import com.example.application.views.MainLayout;
import com.example.application.views.nuevoinstrumento.NuevoInstrumentoView;
import com.example.models.Percusion;
import com.example.models.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.material.Material;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Percusion")
@Route(value = "percusion", layout = MainLayout.class)
@Uses(Icon.class)
public class PercusionView extends Composite<VerticalLayout> {

    public PercusionView() {
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
        TextField textField7 = new TextField();
        ComboBox comboBox = new ComboBox();
        ComboBox comboBox2 = new ComboBox();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        Button guardar = new Button();
        Button buttonSecondary = new Button();
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
        textField2.setLabel("Codigo");
        textField2.setWidth("380px");
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        textField3.setLabel("Precio");
        textField3.setWidth("380px");
        textField4.setLabel("Stock");
        textField4.setWidth("380px");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        textField5.setLabel("Marca");
        textField5.setWidth("380px");
        textField6.setLabel("Color");
        textField6.setWidth("380px");
        layoutRow4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        textField7.setLabel("Material");
        textField7.setWidth("380px");
        comboBox.setLabel("Tipo");
        comboBox.setWidth("380px");
        setComboBoxSampleData(comboBox);
        comboBox2.setLabel("Gama");
        comboBox2.setWidth("380px");
        setComboBox2SampleData(comboBox2);
        layoutRow5.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");

        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        guardar.addClickListener(event -> {
            // Obtener los valores de los campos y guardar en la lista de productos

            String nombre = textField.getValue();
            String codigo = textField2.getValue();
            double precio = Float.parseFloat(textField3.getValue());
            Integer stock = Integer.valueOf(textField4.getValue());
            String marca = textField5.getValue();
            String color = textField6.getValue();
            String material = textField7.getValue();

            SampleItem selectedItem = (SampleItem) comboBox.getValue();
            String tipo = selectedItem != null ? selectedItem.label() : null;

            SampleItem selectedItem2 = (SampleItem) comboBox2.getValue();
            String gama = selectedItem2 != null ? selectedItem2.label() : null;

            // Crear una nueva instancia de Producto

            Percusion percusion = new Percusion();

            // Validar que los campos no estén vacíos antes de guardar
            percusion.setNombre(nombre);
            percusion.setCodigo(codigo);
            percusion.setPrecio(precio);
            percusion.setStock(stock);
            percusion.setMarca(marca);
            percusion.setColor(color);
            percusion.setMaterial(material);
            percusion.setTipo(tipo);
            percusion.setCalidad(gama);

            Util.listaProducto.add(percusion);

            // Navegar a la vista de productos después de guardar
            getUI().ifPresent(ui -> ui.navigate("instrumento"));
        });

        buttonSecondary.setText("Cancelar");
        buttonSecondary.setWidth("min-content");
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
        layoutRow4.add(textField7);
        layoutRow4.add(comboBox);
        layoutColumn2.add(comboBox2);
        layoutColumn2.add(layoutRow5);
        layoutRow5.add(guardar);
        layoutRow5.add(buttonSecondary);
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
        sampleItems.add(new SampleItem("acustico", "Acustico", null));
        sampleItems.add(new SampleItem("electrico", "Electrico", null));
        comboBox2.setItems(sampleItems);
        comboBox2.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

}