//package com.example.application.views.empty;
//
//
//import com.vaadin.flow.component.charts.model.ChartConfiguration;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//
//import javax.xml.crypto.Data;
//
//    public class MyChartView extends VerticalLayout {
//        public MyChartView() {
//            ChartJs chart = new ChartJs();
//
//            ChartConfiguration config = new ChartConfiguration();
//            config.setType("bar");
//
//            Data data = new Data();
//            data.setLabels("Red", "Blue", "Yellow", "Green", "Purple", "Orange");
//
//            Dataset dataset = new Dataset();
//            dataset.setLabel("Votes");
//            dataset.setData(12, 19, 3, 5, 2, 3);
//            dataset.setBackgroundColor("rgba(255, 99, 132, 0.2)");
//            dataset.setBorderColor("rgba(255, 99, 132, 1)");
//            dataset.setBorderWidth(1);
//
//            data.addDataset(dataset);
//            config.setData(data);
//
//            chart.setChartConfiguration(config);
//            add(chart);
//        }
//    }
//
//
//
//
//
//
//
//
