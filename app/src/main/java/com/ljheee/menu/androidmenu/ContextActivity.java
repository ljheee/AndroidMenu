package com.ljheee.menu.androidmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ContextActivity extends Activity {

    private ListView listView;
    private List<String> data = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        for (int i = 0; i < 30; i++) {
            data.add("数据项 " + i);
        }

        listView = (ListView) findViewById(R.id.listView_cm);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);


        // 注册上下文菜单，调用 onCreateContextMenu
        registerForContextMenu(listView);

        // 注销上下文菜单
        // unregisterForContextMenu(listView);
    }

    /**
     * 创建上下文菜单
     *
     * @param menu     菜单
     * @param v        注册上下文菜单的视图
     * @param menuInfo 菜单信息
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        // 加载菜单文件
        getMenuInflater().inflate(R.menu.menu_context, menu);

        // 设置菜单标题图标、标题文字
        menu.setHeaderIcon(android.R.drawable.ic_menu_edit);
        menu.setHeaderTitle("操作");

        // 菜单信息：targetView、position、id
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;

        // 列表中触发长按事件（弹出菜单）的位置
        position = info.position;
    }

    /**
     * 选中菜单项
     *
     * @param item 被选中的菜单项
     * @return 事件是否已处理完毕（消费）
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_edit:
                doEdit();
                break;

            case R.id.action_copy:
                doCopy();
                break;

            case R.id.action_remove:
                doRemove();
                break;
        }
        return true;
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }


    private void doRemove() {
        showToast("删除 " + data.get(position));
    }

    private void doCopy() {
        showToast("复制 " + data.get(position));
    }

    private void doEdit() {
        showToast("编辑 " + data.get(position));
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

}
