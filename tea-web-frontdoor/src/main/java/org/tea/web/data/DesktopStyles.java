package org.tea.web.data;

import com.google.gwt.resources.client.CssResource;

public interface DesktopStyles extends CssResource
{
  int allLeft();
  int allTop();
  int allRight();
  int allBottom();
  
  int afterLogoHeight();
  int menuPanelHeight();
  int menuItemWidth();
  int menuItemSpacing();
  int afterMenuHeight();
  int contentMargin();
  int elementsVSpacing();
  int elementsHSpacing();
  int applyFontSize();
  
  String background();
  String menuPanel();
  String tabSelected();
  String tabUnselected();
  
  String backgroundWelcome();
  String backgroundServices();
  String backgroundPrograms();
  String backgroundApply();
  String content();
  
  String applyTextTitle();
  String applyText();
  String applyTextBox();
}
