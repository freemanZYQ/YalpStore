package com.github.yeriomin.yalpstore;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.github.yeriomin.yalpstore.model.IconInfo;

class AppListViewBinder implements SimpleAdapter.ViewBinder {

    @Override
    public boolean setViewValue(View view, Object value, String textRepresentation) {
        if (view instanceof TextView) {
            return setViewValue((TextView) view, value);
        } else if (view instanceof ImageView) {
            return setViewValue((ImageView) view, value);
        }
        return false;
    }

    private boolean setViewValue(TextView view, Object value) {
        view.setVisibility(
            (!(value instanceof String) || TextUtils.isEmpty((String) value))
                ? View.GONE
                : View.VISIBLE
        );
        return false;
    }

    private boolean setViewValue(ImageView view, Object iconInfo) {
        if (iconInfo instanceof IconInfo) {
            new LoadIconTask(view).execute((IconInfo) iconInfo);
        }
        return true;
    }
}
