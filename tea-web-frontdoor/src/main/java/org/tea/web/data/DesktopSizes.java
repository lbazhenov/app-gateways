package org.tea.web.data;

public class DesktopSizes
{
  static final double HEIGHT_FACTOR = 0.25;
  static final double WIDTH_FACTOR = 0.25;
  static final double SPACE_FACTOR = 0.2;
  
  private int   topPanelHeight;
  private int   logoLeft, logoTop, logo2Left;
  
  public DesktopSizes (DesktopResourceBundle resourceBundle)
  {
    logoLeft = resourceBundle.css().allLeft();
    logoTop = resourceBundle.css().allTop();
    
    topPanelHeight = resourceBundle.logo().getHeight() + 2*resourceBundle.css().allTop();
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
    return topPanelHeight;
  }

  public int getLogoLeft()
  {
    return logoLeft;
  }

  public int getLogoTop()
  {
    return logoTop;
  }

  public int getLogo2Left()
  {
    return logo2Left;
  }

}
