package com.sheygam.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.ClickListener, View.OnClickListener {
    private List<String> names;
    private RecyclerView rv;
    private MyAdapter adapter;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillList();
        adapter = new MyAdapter(this,names);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(this,manager.getOrientation());
        fab = findViewById(R.id.fab);
        rv = findViewById(R.id.my_rv);
        rv.setAdapter(adapter);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(divider);
        fab.setOnClickListener(this);
    }

    private void fillList() {
        names = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            names.add("Name " + i);
        }
    }

    @Override
    public void onRowClick(int pos) {
        Toast.makeText(this, names.get(pos), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        names.add(1,"New Name");
        adapter.notifyItemInserted(1);
    }
}
