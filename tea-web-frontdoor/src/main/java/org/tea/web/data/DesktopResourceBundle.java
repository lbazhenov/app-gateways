package org.tea.web.data;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

public interface DesktopResourceBundle extends ClientBundle
{
  DesktopResourceBundle IMPL = (DesktopResourceBundle) GWT.create(DesktopResourceBundle.class);
  DesktopSizes          SIZES = new DesktopSizes(IMPL);
  
  @Source("images/logo.png")
  ImageResource logo();
  
  @Source("images/TopBanner.png")
  ImageResource topBanner();
  
  @Source("css/desktop-styles.css")
  DesktopStyles css ();
  
  @Source("html/welcome.html")
  TextResource welcomeText();
  
  @Source("html/services.html")
  TextResource servicesText();
  
  @Source("html/programs.html")
  TextResource programsText();
}
