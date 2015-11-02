package org.tea.web.impl;

import org.tea.web.TeaPresenter;
import org.tea.web.TeaView;
import org.tea.web.TourApplication;

public class TeaPresenterImpl implements TeaPresenter
{
  protected TeaView   view;
  
  @Override
  public void setView(TeaView view)
  {
    view.setPresenter(this);
  }

  @Override
  public void applicationSubmitted(TourApplication createTourApplication)
  {
    // TODO Auto-generated method stub
    
  }

}
