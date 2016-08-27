package com.ljheee.menu.androidmenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class OptionsActivity extends Activity {

    private static final String TAG = "OptionsActivity";

    private boolean isHideSort = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }


    // 创建选项菜单（操作栏按钮）
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, "onCreateOptionsMenu");

        // 加载菜单文件
        getMenuInflater().inflate(R.menu.menu_options, menu);

        return true;
    }

    // 预处理选项菜单
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d(TAG, "onPrepareOptionsMenu");

        // 修改菜单项的标题
        menu.findItem(R.id.action_hide_sort).setTitle(
                isHideSort ? "显示排序" : "隐藏排序");

        // 设置菜单项是否可见
        menu.findItem(R.id.action_sort).setVisible(!isHideSort);

        // 设置组是否可见
        menu.setGroupVisible(R.id.group_sort, !isHideSort);

        // 设置组是否可选
        menu.setGroupCheckable(R.id.group_sort, true, true);

        // 设置组是否可用
        menu.setGroupEnabled(R.id.group_sort, true);

        return true;
    }

    // 选中菜单项（点击操作栏按钮）
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected ");

        // 设置菜单项的视觉行为
        if (R.id.group_sort == item.getGroupId()) {
            // 该组的 checkableBehavior 为单选
            item.setChecked(true);
            return true;
        }

        if (R.id.action_hide_sort == item.getItemId()) {
            // TODO 执行特定方法
            isHideSort = !isHideSort;

            // 让菜单重新创建
            // 调用 onCreateOptionsMenu 和 onPrepareOptionsMenu
            invalidateOptionsMenu();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // 关闭选系菜单
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        Log.d(TAG, "onOptionsMenuClosed");

        super.onOptionsMenuClosed(menu);
    }
}
