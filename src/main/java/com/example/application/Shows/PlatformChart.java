package com.example.application.Shows;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;


@Route("PlatformChart")
public class PlatformChart extends Div {

    public PlatformChart() {

            getElement().appendChild(
                    new Html("<iframe src='/PlatformChart.html' style='width:400px;height:400px;border:none;'></iframe>").getElement()
            );
        }}


//        // داده بک‌اند
//        List<YearData> data = List.of(
//                new YearData(2010, 10),
//                new YearData(2011, 20),
//                new YearData(2012, 15),
//                new YearData(2013, 25)
//        );
//
//        // ساخت iframe برای نمایش HTML
//        IFrame iframe = new IFrame("META-INF/resources/Chart.html");
//        iframe.setWidth("600px");
//        iframe.setHeight("400px");
//        add(iframe);
//
//        // ارسال دیتا به فایل JS بعد از لود شدن صفحه
//        try {
//            String jsonData = new ObjectMapper().writeValueAsString(data);
//            UI.getCurrent().getPage().executeJs("window.renderChart($0)", jsonData);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

