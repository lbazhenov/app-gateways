package org.tea.web.util;

import com.google.gwt.user.client.ui.UIObject;
import com.google.gwt.animation.client.Animation;

public class FadeAnimation extends Animation
{
  UIObject  uiObject;
  double    startOpacity;
  double    targetOpacity;
  double    opacityChange;
  boolean   changeVisibility;
  
  public FadeAnimation (UIObject uiObject)
  {
    this.uiObject = uiObject;
    this.changeVisibility = false;    
  }
  
  public FadeAnimation (UIObject uiObject, boolean changeVisibility) 
  {
    this.uiObject = uiObject;
    this.changeVisibility = changeVisibility;
  }
  
  @Override
  protected void onUpdate(double progress)
  {   
    setOpacity(progress * opacityChange + startOpacity);
  }
  
  @Override
  protected void onComplete()
  {
    super.onComplete();
    
    setOpacity(targetOpacity);
    if (changeVisibility && opacityChange < 0) uiObject.setVisible(false);
  }
  
  public void fade (int duration, double startOpacity, double targetOpacity)
  {
    if (duration > 10)
    {
      if (targetOpacity > 1.0) targetOpacity = 1.0;
      if (targetOpacity < 0.0) targetOpacity = 0.0;
      
      this.startOpacity = startOpacity;
      this.targetOpacity = targetOpacity;
      
      try
      {
        opacityChange = targetOpacity-startOpacity;
        
        if (Math.abs(opacityChange) <= Math.abs(Double.MIN_VALUE)) 
          setOpacity(targetOpacity);
        else
        {
          if (changeVisibility && opacityChange > 0) uiObject.setVisible(true);
          
          run(duration);     
        }
      }
      catch (Exception exp)
      {
        setOpacity(targetOpacity);
      }
    }
  }

  public void setOpacity(double opacity)
  {
    if (! (opacity < 0.0 || opacity > 1.0) )
    {  
      try
      {    
        uiObject.getElement().getStyle().setOpacity(opacity);
      }
      catch (Exception exp) {/* Ignore it if opacity was unable to be set */}
    }
  }
}
