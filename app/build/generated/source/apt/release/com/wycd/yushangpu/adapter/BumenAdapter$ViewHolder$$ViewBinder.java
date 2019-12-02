// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BumenAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.BumenAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689783, "field 'tv_name'");
    target.tv_name = finder.castView(view, 2131689783, "field 'tv_name'");
    view = finder.findRequiredView(source, 2131689723, "field 'li_bg'");
    target.li_bg = finder.castView(view, 2131689723, "field 'li_bg'");
  }

  @Override public void unbind(T target) {
    target.tv_name = null;
    target.li_bg = null;
  }
}
