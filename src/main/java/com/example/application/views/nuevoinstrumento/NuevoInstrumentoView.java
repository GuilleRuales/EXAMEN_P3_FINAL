package com.example.application.views.nuevoinstrumento;


import com.example.application.views.MainLayout;
import com.example.application.models.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.html.Image;

@PageTitle("Nuevo Instrumento")
@Route(value = "nuevo-instrumento", layout = MainLayout.class)
@Uses(Icon.class)
public class NuevoInstrumentoView extends Composite<VerticalLayout> {
    private Image image = new Image();
    public NuevoInstrumentoView() {

        image.setSrc("https://static.vecteezy.com/system/resources/thumbnails/023/638/143/small_2x/composition-of-variouse-percussion-musical-instruments-watercolor-illustration-djembe-congo-drum-contrabass-hand-drawn-design-element-for-flyer-concert-events-brochure-poster-print-free-png.png");
        ComboBox cbTipoInstrumento = new ComboBox();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button btIr = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        cbTipoInstrumento.setLabel("Categoria");
        cbTipoInstrumento.setWidth("min-content");

        cbTipoInstrumento.addValueChangeListener(event -> {
            SampleItem selectedItem = (SampleItem) event.getValue();
            if (selectedItem != null) {
                switch (selectedItem.value) {
                    case 1:
                        image.setSrc("https://images.vexels.com/media/users/3/191166/isolated/preview/709d6eaf9554b9c7d19ccfdbad36eb00-dibujado-a-mano-instrumento-musical-indio-pipa.png");
                        break;
                    case 2:
                        image.setSrc("https://images.vexels.com/media/users/3/143278/isolated/preview/ce8474c27275ef3020aabbe162b99fe4-ilustracion-de-percusion-de-congas.png");
                        break;
                    case 3:
                        image.setSrc("https://images.vexels.com/media/users/3/220699/isolated/preview/c5a4f86883d8802241446ae6db1caafc-ilustracion-de-instrumento-de-saxofon-alto.png");
                        break;
                    default:
                        image.setSrc("https://static.vecteezy.com/system/resources/thumbnails/023/638/143/small_2x/composition-of-variouse-percussion-musical-instruments-watercolor-illustration-djembe-congo-drum-contrabass-hand-drawn-design-element-for-flyer-concert-events-brochure-poster-print-free-png.png");
                        break;
                }
            }
        });
        setComboBoxSampleData(cbTipoInstrumento);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");

        btIr.setText("Ir");
        btIr.setWidth("min-content");
        btIr.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btIr.addClickListener(e -> {

            SampleItem selectedItem = (SampleItem) cbTipoInstrumento.getValue();
            String categoria = selectedItem != null ? selectedItem.label() : "";

            Producto producto = new Producto();
            producto.setCategoria(categoria);

            System.out.println("Categoria: "+categoria);

            int tipo = ((SampleItem)cbTipoInstrumento.getValue()).value;

            if (tipo == 1) {
                UI.getCurrent().navigate("cuerda");
            } else if (tipo == 2) {
                UI.getCurrent().navigate("percusion");
            }else if (tipo == 3){
                UI.getCurrent().navigate("viento");
            }

        });

        VerticalLayout container = new VerticalLayout(cbTipoInstrumento, image);
        getContent().add(container);
        getContent().add(layoutRow);
        layoutRow.add(btIr);
    }

    record SampleItem(int value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem(1, "Cuerda", null));
        sampleItems.add(new SampleItem(2, "Percusion", null));
        sampleItems.add(new SampleItem(3, "Viento", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

}
