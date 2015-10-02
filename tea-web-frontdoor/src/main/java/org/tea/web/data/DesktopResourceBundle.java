package org.tea.web.data;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;
import com.google.gwt.resources.client.TextResource;

public interface DesktopResourceBundle extends ClientBundle
{
  DesktopResourceBundle IMPL = (DesktopResourceBundle) GWT.create(DesktopResourceBundle.class);
  DesktopSizes          SIZES = new DesktopSizes(IMPL);
  
  @Source("images/logo.png")
  ImageResource logo();

  @Source("images/welcome.gif")
  ImageResource welcome();
  
  @Source("images/background.png")
  @ImageOptions(repeatStyle=RepeatStyle.Both)
  ImageResource background();
  
  @Source("images/background-welcome.jpg")
  @ImageOptions(repeatStyle=RepeatStyle.Both)
  ImageResource backgroundWelcome();

  @Source("images/background-services.jpg")
  @ImageOptions(repeatStyle=RepeatStyle.Both)
  ImageResource backgroundServices();
  
  @Source("images/background-programs.png")
  @ImageOptions(repeatStyle=RepeatStyle.Both)
  ImageResource backgroundPrograms();
  
  @Source("images/background-apply.jpeg")
  @ImageOptions(repeatStyle=RepeatStyle.Both)
  ImageResource backgroundApply();
  
  @Source("css/desktop-styles.css")
  DesktopStyles css ();
  
  @Source("html/welcome.html")
  TextResource welcomeText();
  
  @Source("html/services.html")
  TextResource servicesText();
  
  @Source("html/programs.html")
  TextResource programsText();
}
