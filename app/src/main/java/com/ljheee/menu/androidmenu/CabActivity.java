package com.ljheee.menu.androidmenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CabActivity extends Activity implements AbsListView.MultiChoiceModeListener {

    private ListView listView;
    private ArrayList<String> data = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab);

        listView = (ListView) findViewById(R.id.listView_cab);
        initData();

        // 模版需要有选中状态（activated）
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1,
                data);

        listView.setAdapter(adapter);

        // 设置选择模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        // 设置多选监听器
        listView.setMultiChoiceModeListener(this);
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            data.add("数据项 " + i);
        }
    }

    @Override
    public void onItemCheckedStateChanged(
            ActionMode mode,
            int position,
            long id,
            boolean checked) {

        // 获得选中的总数
        int count = listView.getCheckedItemCount();

        // 设置标题
        mode.setTitle(String.valueOf(count));
//        mode.setSubtitle();
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        // 创建菜单
        getMenuInflater().inflate(R.menu.menu_cab, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_cab_copy:

                // 获得选中的多项【稀疏数组】
                SparseBooleanArray array = listView.getCheckedItemPositions();

                // 适用于有 ID 的数据
//                long[] ids = listView.getCheckedItemIds();

                break;
            case R.id.action_cab_remove:
                break;
        }

        // 结束 CAB 模式，调用 onDestroyActionMode 方法
        mode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
    }
}
