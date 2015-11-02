package org.tea.web.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import org.tea.web.TeaPresenter;
import org.tea.web.TeaView;
import org.tea.web.TourApplication;
import org.tea.web.data.DesktopResourceBundle;
import org.tea.web.data.DesktopSizes;
import org.tea.web.util.FadeAnimation;

public class TeaViewDesktopImpl extends Composite implements TeaView
{
  static final String DATE_FORMAT = "MM/dd/yyyy";
  
  @UiTemplate("TeaViewDesktopImpl.ui.xml")
  interface TeaViewDesktopImplUiBinder extends UiBinder<Widget, TeaViewDesktopImpl> {}
  static TeaViewDesktopImplUiBinder uiBinder = GWT.create(TeaViewDesktopImplUiBinder.class);
  
  TeaPresenter presenter = null;
  
  @UiField(provided=true)
  DesktopResourceBundle resourceBundle = DesktopResourceBundle.IMPL;  
  @UiField(provided=true)
  DesktopSizes          sizes = DesktopResourceBundle.SIZES;
  
  @UiField 
  DeckLayoutPanel       contentPanel;
  
  Map<Widget,Integer>   tabMap = new HashMap<>();
  @UiField Label        welcomeTab;
  @UiField Label        servicesTab;
  @UiField Label        programsTab;
  @UiField Label        applyTab;
  @UiField DateBox      dobPicker;
  Widget                currentTab;
  
  @UiField DateBox      startPicker;
  
  @UiField HorizontalPanel isMorningPanel;
  FadeAnimation         isMorningPanelAnimation;
  @UiField CheckBox     isFullDay;
  @UiField CheckBox     isHalfDay;
  
  @UiField PushButton   tourApplicationSubmit;
   
  public TeaViewDesktopImpl()
  {
    Widget    teaPanel = uiBinder.createAndBindUi(this);
    
    tabMap.put(welcomeTab, 0);
    tabMap.put(servicesTab, 1);
    tabMap.put(programsTab, 2);
    tabMap.put(applyTab, 3);
    
    // Select welcome content
    currentTab = welcomeTab;
    contentPanel.showWidget(0);
    
    contentPanel.animate(500);
    
    resourceBundle.css().ensureInjected();
    
    dobPicker.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(DATE_FORMAT)));
    dobPicker.getTextBox().setMaxLength(DATE_FORMAT.length()); 
    dobPicker.getTextBox().setVisibleLength(DATE_FORMAT.length()+1); 
    
    dobPicker.getDatePicker().setVisibleYearCount(7);
    dobPicker.getDatePicker().setYearAndMonthDropdownVisible(true);
    dobPicker.getDatePicker().setYearArrowsVisible(true);
    
    startPicker.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat(DATE_FORMAT)));
    startPicker.getTextBox().setMaxLength(DATE_FORMAT.length()); 
    startPicker.getTextBox().setVisibleLength(DATE_FORMAT.length()+1); 
    
    startPicker.getDatePicker().setVisibleYearCount(7);
    startPicker.getDatePicker().setYearAndMonthDropdownVisible(true);
    startPicker.getDatePicker().setYearArrowsVisible(true);
    
    isMorningPanelAnimation = new FadeAnimation(isMorningPanel, true);
    
    initWidget(teaPanel);  
  }
  
  @Override
  public void setPresenter(TeaPresenter presenter)
  {
    this.presenter = presenter;
  }
  
  public TourApplication createTourApplication()
  {
    return null;
  }  
  
  /*
   * Event handlers 
   */
  
  @UiHandler({"welcomeTab", "servicesTab", "programsTab", "applyTab"})
  void onMouseOver(MouseOverEvent event) 
  {
    Widget  selectedTab = null;
    
    try
    {
      selectedTab = (Widget) event.getSource();
    }
    catch (Exception exp)
    {
      // Wrong UI object is selected, hence ignore it
    }

    if (selectedTab != null && selectedTab != currentTab)
    {
      Integer   tabIndex = tabMap.get(selectedTab);
      
      if (tabIndex != null)
      {
        currentTab.setStyleName(resourceBundle.css().tabUnselected());
        selectedTab.setStyleName(resourceBundle.css().tabSelected());
        
        currentTab = selectedTab;
        contentPanel.showWidget(tabIndex);
        
        contentPanel.animate(1000);
      }
    }
  }
  
  @UiHandler({"isFullDay", "isHalfDay"})
  void onValueChange(ValueChangeEvent<Boolean> event)
  {
    CheckBox  changedCheckBox = null;
     
    try
    {
      changedCheckBox = (CheckBox) event.getSource();
    }
    catch (Exception exp)
    {
      // Wrong UI object is selected, hence ignore it
    }
    
    if (changedCheckBox != null)  
    {
      boolean   isSetVisible = isHalfDay.getValue();
      boolean   isCurrentVisible = isMorningPanel.isVisible();
      
      if (isSetVisible != isCurrentVisible)
      {
        if (isSetVisible)
        {
          isMorningPanelAnimation.fade(500, 0.0, 1.0);          
        }
        else
        {
          isMorningPanelAnimation.fade(500, 1.0, 0.0);
        }
      }
    }
  }
  
  @UiHandler ({"tourApplicationSubmit"})
  void onClick(ClickEvent event) 
  {
    try
    {
      if (event.getSource() == tourApplicationSubmit)
      {
        presenter.applicationSubmitted(createTourApplication());
      }
    }
    catch (Exception exp)
    {
      // Wrong UI object is selected, hence ignore it
    }
  }
}
