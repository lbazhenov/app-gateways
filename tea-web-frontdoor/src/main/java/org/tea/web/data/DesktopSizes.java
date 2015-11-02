package org.tea.web.data;

public class DesktopSizes
{
  static final double HEIGHT_FACTOR = 0.25;
  static final double WIDTH_FACTOR = 0.25;
  static final double SPACE_FACTOR = 0.2;
  
  private DesktopResourceBundle resourceBundle;
  
  public DesktopSizes (DesktopResourceBundle resourceBundle)
  {
    this.resourceBundle = resourceBundle;
  }
  
  public int getLogoCanvasWidth ()
  {
    return resourceBundle.logo().getWidth() + resourceBundle.css().topPanelSpacing();
  }

  public static int calcHeightByFontSize (int fontSize)
  {
    return (int) Math.floor(((double)fontSize)/(1.0-2.0*HEIGHT_FACTOR));
  }
  
  public static int calcWidthByFontSize (int fontSize, int length)
  {
    return (int) Math.floor(((double)fontSize*length + SPACE_FACTOR*fontSize*(length-1))/(1.0-2.0*WIDTH_FACTOR));
  }

  public int getTopPanelHeight()
  {
    return Math.max(resourceBundle.logo().getHeight(),resourceBundle.topBanner().getHeight()) + 
             resourceBundle.css().allTop() + resourceBundle.css().afterTopPanelHeight();
  }

}
