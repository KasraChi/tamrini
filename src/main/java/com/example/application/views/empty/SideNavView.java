package com.example.application.views.empty;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.component.icon.VaadinIcon; // Optional, for icons
import com.vaadin.flow.router.Route;

@Route(value = "nav",layout = MainLayout.class)
public class SideNavView extends AppLayout {

//    SideNavView() {
//
//
//        SideNav sideNav = new SideNav("SideNav");
//        SideNavItem sideNavView = new SideNavItem("test");
//        sideNav.addItem(sideNavView);
//
//        setPrimarySection(Section.DRAWER);
//        addToDrawer(new H6("home"), new Scroller(sideNav));
//
//
//    }

}
