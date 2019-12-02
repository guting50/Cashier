// Generated code from Butter Knife. Do not modify!
package com.wycd.yushangpu.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class GuadanListAdapter$ViewHolder$$ViewBinder<T extends com.wycd.yushangpu.adapter.GuadanListAdapter.ViewHolder> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131755366, "field 'tvCode'");
    target.tvCode = finder.castView(view, 2131755366, "field 'tvCode'");
    view = finder.findRequiredView(source, 2131755502, "field 'tvCodetime'");
    target.tvCodetime = finder.castView(view, 2131755502, "field 'tvCodetime'");
    view = finder.findRequiredView(source, 2131755367, "field 'tvCard'");
    target.tvCard = finder.castView(view, 2131755367, "field 'tvCard'");
    view = finder.findRequiredView(source, 2131755368, "field 'tvVipmsg'");
    target.tvVipmsg = finder.castView(view, 2131755368, "field 'tvVipmsg'");
    view = finder.findRequiredView(source, 2131755369, "field 'tvOrdermoney'");
    target.tvOrdermoney = finder.castView(view, 2131755369, "field 'tvOrdermoney'");
    view = finder.findRequiredView(source, 2131755370, "field 'tvHandler'");
    target.tvHandler = finder.castView(view, 2131755370, "field 'tvHandler'");
    view = finder.findRequiredView(source, 2131755371, "field 'tvHandle'");
    target.tvHandle = finder.castView(view, 2131755371, "field 'tvHandle'");
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
