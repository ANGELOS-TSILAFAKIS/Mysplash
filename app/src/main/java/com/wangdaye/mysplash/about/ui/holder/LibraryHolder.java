package com.wangdaye.mysplash.about.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.wangdaye.mysplash.R;
import com.wangdaye.mysplash.about.model.AboutModel;
import com.wangdaye.mysplash.common.basic.activity.MysplashActivity;
import com.wangdaye.mysplash.about.ui.AboutAdapter;
import com.wangdaye.mysplash.common.utils.helper.IntentHelper;
import com.wangdaye.mysplash.about.model.LibraryObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Library holder.
 *
 * This ViewHolder is used to show library for {@link AboutAdapter}.
 *
 * */

public class LibraryHolder extends AboutAdapter.ViewHolder {

    @OnClick(R.id.item_about_library_container) void clickItem() {
        IntentHelper.startWebActivity(itemView.getContext(), uri);
    }

    @BindView(R.id.item_about_library_title) TextView title;
    @BindView(R.id.item_about_library_content) TextView content;

    private String uri;

    public LibraryHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    protected void onBindView(MysplashActivity a, AboutModel model) {
        LibraryObject object = (LibraryObject) model;

        title.setText(object.title);
        content.setText(object.subtitle);
        uri = object.uri;
    }

    @Override
    protected void onRecycled() {
        // do nothing.
    }
}
