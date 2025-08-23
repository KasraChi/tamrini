package com.example.application.Shows;

import com.example.application.DTO.PlatformUsageProjection;
import com.example.application.service.PlatformService;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Route("PlatformChart")
public class PlatformChart extends VerticalLayout {

    private final PlatformService platformService;

    // iframe فقط یکبار ساخته میشه و همیشه تو صفحه هست
    private final Html iframeHolder = new Html("<iframe src='/PlatformChart.html' style='width:500px;height:500px;border:none;'></iframe>");

    public PlatformChart(PlatformService platformService) {
        this.platformService = platformService;

        ComboBox<String> classComboBox = new ComboBox<>("اسم کلاس را انتخاب کنید");
        classComboBox.setItems(platformService.getAllClassCodes());

        ComboBox<String> logComboBox = new ComboBox<>("نحوه ی گزارش گیری را انتخاب کنید");
        logComboBox.setItems("Chart", "Excel");

        Button showButton = new Button("نمایش");

        // Anchor برای لینک دانلود اکسل
        Anchor downloadAnchor = new Anchor();
        downloadAnchor.getElement().setAttribute("style", "display:none"); // مخفی به صورت پیشفرض
        add(classComboBox, logComboBox, showButton, downloadAnchor, iframeHolder);

        showButton.addClickListener(event -> {
            String selectedClass = classComboBox.getValue();
            String selectedLog = logComboBox.getValue();

            if (selectedClass == null || selectedLog == null) {
                Notification.show("لطفا همه گزینه‌ها را انتخاب کنید");
                return;
            }

            if ("Chart".equals(selectedLog)) {
                // نمایش چارت از طریق iframe
                UI.getCurrent().getPage().executeJs(
                        "document.querySelector('iframe').contentWindow.postMessage($0, '*');",
                        selectedClass
                );
                // لینک دانلود رو مخفی کن چون این حالت اکسل نیست
//                downloadAnchor.setHref((String) null);
                downloadAnchor.setVisible(false);

            } else if ("Excel".equals(selectedLog)) {
                // ساختن فایل اکسل و ایجاد لینک دانلود
                try {
                    StreamResource resource = createExcelResource(selectedClass);
                    downloadAnchor.setHref(resource);
                    downloadAnchor.getElement().setAttribute("download", "Report_" + selectedClass + ".xlsx");
                    downloadAnchor.setText("دانلود فایل اکسل");
                    downloadAnchor.setVisible(true);

                    // اتوماتیک کلیک روی لینک دانلود (دانلود شروع میشه)
                    downloadAnchor.getElement().callJsFunction("click");
                } catch (IOException e) {
                    Notification.show("خطا در ساخت فایل اکسل: " + e.getMessage());
                }
            }
        });
    }

    private StreamResource createExcelResource(String classCode) throws IOException {
        List<PlatformUsageProjection> data = platformService.getUsagePerPlatform(classCode);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("گزارشات");

        // هدر اکسل
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("نام پلتفرم");
        headerRow.createCell(1).setCellValue("تعداد استفاده");

        int rowNum = 1;
        for (PlatformUsageProjection usage : data) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(usage.getName());
            row.createCell(1).setCellValue(usage.getUsage());
        }

        // نوشتن در ByteArrayOutputStream به جای فایل سیستم
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();

        byte[] bytes = outputStream.toByteArray();

        return new StreamResource("Report_" + classCode + ".xlsx", () -> new ByteArrayInputStream(bytes));
    }
}






//
//@Route("PlatformChart")
//public class PlatformChart extends VerticalLayout {
//
//    private final PlatformService platformService;
//    private Html iframeHolder = null;
//
//    @Autowired
//    public PlatformChart(PlatformService platformService) {
//        this.platformService = platformService;
//
//        ComboBox<String> classComboBox = new ComboBox<>("اسم کلاس را انتخاب کنید");
//        classComboBox.setItems(platformService.getAllClassCodes());
//
//        ComboBox<String> logComboBox = new ComboBox<>("نحوه ی گزارش گیری را انتخاب کنید");
//        logComboBox.setItems("Chart", "Excel");
//        logComboBox.setValue("Chart"); // مقدار پیش‌فرض
//
//        Button showButton = new Button("نمایش");
//
//        showButton.addClickListener(event -> {
//            String selectedClass = classComboBox.getValue();
//            String selectedLog = logComboBox.getValue();
//
//            if (selectedClass == null || selectedLog == null) {
//                Notification.show("لطفا همه گزینه‌ها را انتخاب کنید");
//                return;
//            }
//
//            if ("Chart".equals(selectedLog)) {
//                if (iframeHolder == null) {
//                    iframeHolder = new Html("<iframe src='/PlatformChart.html' style='width:500px;height:500px;border:none;'></iframe>");
//                    getElement().appendChild(iframeHolder.getElement());
//                }
//                UI.getCurrent().getPage().executeJs(
//                        "document.querySelector('iframe').contentWindow.postMessage($0, '*');",
//                        selectedClass
//                );
//            } else if ("Excel".equals(selectedLog)) {
//                try {
//                    createExcel(selectedClass);
//                    Notification.show("فایل اکسل ساخته شد و روی سرور ذخیره شده است");
//                } catch (IOException e) {
//                    Notification.show("خطا در ساخت فایل اکسل: " + e.getMessage());
//                }
//            }
//        });
//
//        add(classComboBox, logComboBox, showButton);
//    }
//
//    public void createExcel(String classCode) throws IOException {
//        List<PlatformUsageProjection> data = platformService.getUsagePerPlatform(classCode);
//
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("گزارشات");
//
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("نام پلتفرم");
//        headerRow.createCell(1).setCellValue("تعداد استفاده");
//
//        int rowNum = 1;
//        for (PlatformUsageProjection usage : data) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(usage.getName());
//            row.createCell(1).setCellValue(usage.getUsage());
//        }
//
//        try (FileOutputStream fileOut = new FileOutputStream("Report_" + classCode + ".xlsx")) {
//            workbook.write(fileOut);
//        }
//        workbook.close();
//    }
//}


//@Route("PlatformChart")
//public class    PlatformChart extends VerticalLayout {
//
/// /    @Autowired
/// /    PlatformService platformService;
//
//    private List<PlatformUsageProjection> loadChartByClassCode(String classCode) {
//        return platformService.getUsagePerPlatform(classCode);
//    }
//
//    private final PlatformService platformService;
//
//    @Autowired
//    public PlatformChart(PlatformService platformService) {
//        this.platformService = platformService;
//
////        platformService = new PlatformService();
//        ComboBox<String> classComboBox = new ComboBox("اسم کلاس را انتخاب کنید");
//        List<String> list = platformService.getAllClassCodes();
//        classComboBox.setItems(list);
//        classComboBox.addValueChangeListener(event -> {
//            loadChartByClassCode(event.getValue().toString());
//
//            String selectedClassCode = event.getValue();
//            UI.getCurrent().getPage().executeJs(
//                    "document.querySelector('iframe').contentWindow.postMessage($0, '*');",
//                    selectedClassCode
//            );
//        });
//
//        ComboBox<String> logComboBox = new ComboBox("نحوه ی گزارش گیری را انتخاب کنید");
//        List<String> LogListItems = List.of("Chart", "Excel");
//        logComboBox.setItems(LogListItems);
//
//
//        Button showButton = new Button("نمایش");
//        showButton.addClickListener(event -> {
//            if ("Chart".equals(logComboBox.getValue())) {
//                getElement().appendChild(
//                        new Html("<iframe src='/PlatformChart.html' style='width:500px;height:500px;border:none;'></iframe>").getElement());
//            } else if ("Excel".equals(logComboBox.getValue())) {
//                try {
//                    createExcel(classComboBox.getValue());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//
//        add(classComboBox,logComboBox, showButton);
//
//        // ارسال classCode به iframe
//
////        getElement().appendChild(
////                new Html("<iframe src='/PlatformChart.html' style='width:500px;height:500px;border:none;'></iframe>").getElement()
////        );
//    }
//
//    public void createExcel(String classCode) throws IOException {
//        // 1. گرفتن داده‌ها
//        List<PlatformUsageProjection> data = platformService.getUsagePerPlatform(classCode);
//
//        // 2. ساختن ورک‌بوک و شیت
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("گزارشات");
//
//        // ساختن ردیف هدر
//        Row headerRow = sheet.createRow(0);
//        headerRow.createCell(0).setCellValue("نام پلتفرم");
//        headerRow.createCell(1).setCellValue("تعداد استفاده");
//
//        // پر کردن داده‌ها از ردیف 1 به بعد
//        int rowNum = 1;
//        for (PlatformUsageProjection usage : data) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(usage.getName());
//            row.createCell(1).setCellValue(usage.getUsage());
//        }
//
//        // 3. ذخیره کردن فایل اکسل
//        try (FileOutputStream fileOut = new FileOutputStream("Report_" + classCode + ".xlsx")) {
//            workbook.write(fileOut);
//        }
//
//        workbook.close();
//    }
//}

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

