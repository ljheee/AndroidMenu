package com.ljheee.menu.androidmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;


public class PopupActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
    }

    public void onClick(View v) {

        // 创建弹出菜单
        // 参数一：上下文
        // 参数二：菜单的锚
        PopupMenu menu = new PopupMenu(this, v);

        // 加载菜单文件
        menu.inflate(R.menu.menu_popup);

        // 添加菜单项点击监听器
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });

        // 添加菜单消失时的监听器【点击菜单项或其他区域，菜单会消失】
        menu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {

            }
        });

        // 显示菜单
        menu.show();
    }

}
