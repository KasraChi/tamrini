package com.example.application.views.empty;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;


    @Route("chart")
    public class ShowingChart extends Div {

        public ShowingChart() {
            getElement().appendChild(
                    new Html("<canvas id='acquisitions'></canvas>").getElement()
            );
            getElement().appendChild(
                    new Html("<script src='https://cdn.jsdelivr.net/npm/chart.js'></script>").getElement()
            );
            getElement().appendChild(
                    new Html("<script src='/chart.js'></script>").getElement()
            );
        }
    }

