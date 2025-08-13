package com.example.application.views.empty;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import software.xdev.vaadin.chartjs.ChartContainer;

//@Route(value = "test")
public class Chart extends Composite<VerticalLayout> {
    public Chart() {
        ChartContainer chart = new ChartContainer();

        chart.showChart(
                "{\"data\":{\"labels\":[\"A\",\"B\"],\"datasets\":[{\"data\":[1,2],\"label\":\"X\"}]},\"type\":\"bar\"}");

        getContent().add(new H6("Hello"));
        VerticalLayout layout = new VerticalLayout();
        layout.add(chart);
        layout.setWidth(50, Unit.PERCENTAGE);
        layout.setHeight(50, Unit.PERCENTAGE);
        getContent().add(layout);

    }
}
