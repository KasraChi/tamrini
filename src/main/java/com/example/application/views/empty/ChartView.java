package com.example.application.views.empty;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("charts")
public class ChartView extends VerticalLayout {


        public ChartView() {
            setSizeFull();

            // ساخت canvas برای چارت
            Html canvas = new Html("<canvas id='myChart' width='400' height='200'></canvas>");
            add(canvas);

            // لود Chart.js و ساخت چارت بعد از لود شدن DOM
            getElement().executeJs("""
            setTimeout(() => {
                const script = document.createElement('script');
                script.src = 'https://cdn.jsdelivr.net/npm/chart.js';
                script.onload = () => {
                    const ctx = document.getElementById('myChart').getContext('2d');
                    new Chart(ctx, {
                        type: 'bar',
                        data: {
                            labels: ['Red', 'Blue', 'Yellow', 'Green'],
                            datasets: [{
                                label: 'Votes',
                                data: [12, 19, 3, 5],
                                backgroundColor: ['red', 'blue', 'yellow', 'green']
                            }]
                        }
                    });
                };
                document.head.appendChild(script);
            }, 0);
        """);
        }
    }
