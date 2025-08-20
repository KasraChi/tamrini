package com.example.application.Shows;


import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

                @Route("RegisteringChart")
public class RegisteringStatusChart extends VerticalLayout {

    public RegisteringStatusChart() {
//        VerticalLayout vl = new VerticalLayout();
//        vl.setWidthFull();
//        vl.setHeight(800 , Unit.PIXELS);
//        IFrame iFrame = new IFrame("/RegisteringStatusChart.html");
//        iFrame.setWidth(50, Unit.PERCENTAGE);
//        iFrame.setHeight(100, Unit.PERCENTAGE);
//        vl.add(iFrame);
//        vl.setAlignItems(Alignment.CENTER);
//        vl.setJustifyContentMode(JustifyContentMode.CENTER);
////        getElement().appendChild(
////                vl.getElement()
////        );
//        add(vl);
        setSizeFull();
        FlexLayout layout = new FlexLayout();
        layout.setSizeFull();
        layout.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        layout.setFlexDirection(FlexLayout.FlexDirection.ROW);
        IFrame iframe = new IFrame("/RegisteringStatusChart.html");
        IFrame iframe2 = new IFrame("/RegisteringStatusChart.html");
        IFrame iframe3 = new IFrame("/RegisteringStatusChart.html");
        IFrame iframe4 = new IFrame("/RegisteringStatusChart.html");
        iframe.setWidth("49%");
        iframe.setHeight("49%");
        iframe2.setWidth("49%");
        iframe2.setHeight("49%");
        iframe3.setWidth("49%");
        iframe3.setHeight("49%");
        iframe4.setWidth("49%");
        iframe4.setHeight("49%");
        layout.add(iframe);
        layout.add(iframe2);
        layout.add(iframe3);
        layout.add(iframe4);
        add(layout);
    }}



