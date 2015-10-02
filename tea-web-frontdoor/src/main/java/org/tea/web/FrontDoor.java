package org.tea.web;

import org.tea.web.impl.TeaPresenterImpl;
import org.tea.web.impl.TeaViewDesktopImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class FrontDoor implements EntryPoint 
{
  public void onModuleLoad() 
  {
    TeaPresenter        teaPresenter = new TeaPresenterImpl();
    TeaViewDesktopImpl  teaDesktopView = new TeaViewDesktopImpl();
    
    teaPresenter.setView (teaDesktopView);
    

    RootLayoutPanel.get().add(teaDesktopView);
  }
}
