package com.example.application.views.empty;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.theme.lumo.LumoUtility;

public final class MainLayout extends AppLayout {

    MainLayout() {
        setPrimarySection(Section.DRAWER); // بگو منوی اصلی از سمت چپ باشه
        addToDrawer(createHeader(),new Scroller(createSideNav()));


        // منو رو بذار تو Drawer
    }

    private Div createHeader() {

        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");
        toggle.getStyle().setColor("white");
        var itemLogo = VaadinIcon.CUBE.create();
        var itemName = new Span("poamoozi");


        var header = new Div(itemLogo, itemName);
        header.addClassName(LumoUtility.AlignItems.CENTER);
        return header;
    }

    private SideNav createSideNav() {

        SideNav sideNav = new SideNav("SideNav");
        SideNavItem sideNavView = new SideNavItem("test");
        sideNav.addItem(sideNavView);

//        setPrimarySection(Section.DRAWER);
//        addToDrawer(new H6("home"), new Scroller(sideNav));
        return sideNav;

    }


}
