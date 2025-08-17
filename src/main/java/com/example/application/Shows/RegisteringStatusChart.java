package com.example.application.Shows;


import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("RegisteringChart")
public class RegisteringStatusChart extends Div {

    public RegisteringStatusChart() {

        getElement().appendChild(
                new Html("<iframe src='/RegisteringStatusChart.html' style='width:400px;height:400px;border:none;'></iframe>").getElement()
        );
    }}



