package org.tea.web;

public interface TeaPresenter
{
  void setView(TeaView view);

  void applicationSubmitted(TourApplication createTourApplication);
}
