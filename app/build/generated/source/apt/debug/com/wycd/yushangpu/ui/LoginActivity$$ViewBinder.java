// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.wycd.yushangpu.ui.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755224, "field 'mEtLoginAccount'");
    target.mEtLoginAccount = finder.castView(view, 2131755224, "field 'mEtLoginAccount'");
    view = finder.findRequiredView(source, 2131755279, "field 'mEtLoginPassword'");
    target.mEtLoginPassword = finder.castView(view, 2131755279, "field 'mEtLoginPassword'");
    view = finder.findRequiredView(source, 2131755281, "field 'mRlLogin'");
    target.mRlLogin = finder.castView(view, 2131755281, "field 'mRlLogin'");
    view = finder.findRequiredView(source, 2131755276, "field 'mLiBg'");
    target.mLiBg = finder.castView(view, 2131755276, "field 'mLiBg'");
    view = finder.findRequiredView(source, 2131755280, "field 'cb'");
    target.cb = finder.castView(view, 2131755280, "field 'cb'");
  }

  @Override public void unbind(T target) {
    target.mEtLoginAccount = null;
    target.mEtLoginPassword = null;
    target.mRlLogin = null;
    target.mLiBg = null;
    target.cb = null;
  }
}
