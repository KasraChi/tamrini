package com.example.application.controller;

import com.vaadin.flow.component.button.Button;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {

    @GetMapping("/chart")
    public String chartPage() {
        Button showButton = new Button("show chart");
        return "chart.html"; // این اسم فایل تو resources باشه
    }
}
