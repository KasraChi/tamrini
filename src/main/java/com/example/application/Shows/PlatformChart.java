package com.example.application.Shows;

import com.example.application.DTO.PlatformUsageProjection;
import com.example.application.model.Platform;
import com.example.application.service.PlatformService;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Route("PlatformChart")
public class PlatformChart extends VerticalLayout {

//    @Autowired
//    PlatformService platformService;

    private List<PlatformUsageProjection> loadChartByClassCode(String classCode) {
        return platformService.getUsagePerPlatform(classCode);
    }

    private final PlatformService platformService;

    @Autowired
    public PlatformChart(PlatformService platformService) {
        this.platformService = platformService;

//        platformService = new PlatformService();
        ComboBox<String> comboBox = new ComboBox("اسم کلاس را انتخاب کنید");
        List<String> list = platformService.getAllClassCodes();
        comboBox.setItems(list);
        comboBox.addValueChangeListener(event -> {
            loadChartByClassCode(event.getValue().toString());

            String selectedClassCode = event.getValue();
            UI.getCurrent().getPage().executeJs(
                    "document.querySelector('iframe').contentWindow.postMessage($0, '*');",
                    selectedClassCode
            );
        });
        add(comboBox);

        // ارسال classCode به iframe

        getElement().appendChild(
                new Html("<iframe src='/PlatformChart.html' style='width:400px;height:400px;border:none;'></iframe>").getElement()
        );
    }
    }


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

