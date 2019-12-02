// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GuadanListAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.GuadanListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131689817, "field 'tvCode'");
    target.tvCode = finder.castView(view, 2131689817, "field 'tvCode'");
    view = finder.findRequiredView(source, 2131689953, "field 'tvCodetime'");
    target.tvCodetime = finder.castView(view, 2131689953, "field 'tvCodetime'");
    view = finder.findRequiredView(source, 2131689818, "field 'tvCard'");
    target.tvCard = finder.castView(view, 2131689818, "field 'tvCard'");
    view = finder.findRequiredView(source, 2131689819, "field 'tvVipmsg'");
    target.tvVipmsg = finder.castView(view, 2131689819, "field 'tvVipmsg'");
    view = finder.findRequiredView(source, 2131689820, "field 'tvOrdermoney'");
    target.tvOrdermoney = finder.castView(view, 2131689820, "field 'tvOrdermoney'");
    view = finder.findRequiredView(source, 2131689821, "field 'tvHandler'");
    target.tvHandler = finder.castView(view, 2131689821, "field 'tvHandler'");
    view = finder.findRequiredView(source, 2131689822, "field 'tvHandle'");
    target.tvHandle = finder.castView(view, 2131689822, "field 'tvHandle'");
  }

  @Override public void unbind(T target) {
    target.tvCode = null;
    target.tvCodetime = null;
    target.tvCard = null;
    target.tvVipmsg = null;
    target.tvOrdermoney = null;
    target.tvHandler = null;
    target.tvHandle = null;
  }
}
