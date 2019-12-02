// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class ShopFirstClassAdapter$LinkHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.ShopFirstClassAdapter.LinkHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689783, "field 'mTvName'");
    target.mTvName = finder.castView(view, 2131689783, "field 'mTvName'");
    view = finder.findRequiredView(source, 2131689954, "field 'mRlBg'");
    target.mRlBg = finder.castView(view, 2131689954, "field 'mRlBg'");
  }

  @Override public void unbind(T target) {
    target.mTvName = null;
    target.mRlBg = null;
  }
}
