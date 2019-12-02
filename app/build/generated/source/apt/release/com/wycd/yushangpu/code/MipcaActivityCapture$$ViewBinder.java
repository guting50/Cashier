// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.code;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MipcaActivityCapture$$ViewBinder<T extends com.wycd.yushangpu.code.MipcaActivityCapture> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131690026, "field 'mImgLeft'");
    target.mImgLeft = finder.castView(view, 2131690026, "field 'mImgLeft'");
    view = finder.findRequiredView(source, 2131690025, "field 'mRlLeft' and method 'onViewClicked'");
    target.mRlLeft = finder.castView(view, 2131690025, "field 'mRlLeft'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
    view = finder.findRequiredView(source, 2131689925, "field 'mTvTitle'");
    target.mTvTitle = finder.castView(view, 2131689925, "field 'mTvTitle'");
    view = finder.findRequiredView(source, 2131690027, "field 'mRlRight'");
    target.mRlRight = finder.castView(view, 2131690027, "field 'mRlRight'");
    view = finder.findRequiredView(source, 2131689661, "field 'mPreviewView'");
    target.mPreviewView = finder.castView(view, 2131689661, "field 'mPreviewView'");
    view = finder.findRequiredView(source, 2131689662, "field 'viewfinderView'");
    target.viewfinderView = finder.castView(view, 2131689662, "field 'viewfinderView'");
    view = finder.findRequiredView(source, 2131689663, "field 'mTvMoney'");
    target.mTvMoney = finder.castView(view, 2131689663, "field 'mTvMoney'");
    view = finder.findRequiredView(source, 2131689664, "field 'mTvMycode' and method 'onViewClicked'");
    target.mTvMycode = finder.castView(view, 2131689664, "field 'mTvMycode'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onViewClicked(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.mImgLeft = null;
    target.mRlLeft = null;
    target.mTvTitle = null;
    target.mRlRight = null;
    target.mPreviewView = null;
    target.viewfinderView = null;
    target.mTvMoney = null;
    target.mTvMycode = null;
  }
}
