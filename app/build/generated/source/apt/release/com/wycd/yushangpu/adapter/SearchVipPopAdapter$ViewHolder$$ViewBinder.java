// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SearchVipPopAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.SearchVipPopAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689783, "field 'tvName'");
    target.tvName = finder.castView(view, 2131689783, "field 'tvName'");
    view = finder.findRequiredView(source, 2131689784, "field 'tvCardnum'");
    target.tvCardnum = finder.castView(view, 2131689784, "field 'tvCardnum'");
    view = finder.findRequiredView(source, 2131689788, "field 'tvPhone'");
    target.tvPhone = finder.castView(view, 2131689788, "field 'tvPhone'");
  }

  @Override public void unbind(T target) {
    target.tvName = null;
    target.tvCardnum = null;
    target.tvPhone = null;
  }
}
