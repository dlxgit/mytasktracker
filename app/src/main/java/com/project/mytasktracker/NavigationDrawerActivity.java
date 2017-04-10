package com.project.mytasktracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.ContentTaskItem.TaskRecyclerViewAdapter;
import com.project.mytasktracker.MenuFolderItem.FolderRecyclerViewAdapter;
import com.project.mytasktracker.MenuFolderItem.TaskFolderItem;

import java.util.ArrayList;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView menuRecyclerView;
    private FolderRecyclerViewAdapter menuRecyclerViewAdapter;
    private LinearLayout bottomTaskEditLayout;

    FloatingActionButton addTaskFab;


    private RecyclerView contentRecyclerView;
    private TaskRecyclerViewAdapter contentRecyclerViewAdapter;

    private ArrayList<TaskFolderItem> menuItemList;
    private ArrayList<TaskItem> contentTaskItemList;

    private DrawerLayout drawer;
    private TaskStorage taskStorage;

    private boolean isActionSelectMode = false;

    private Toolbar toolbar;

    private TextView selectedItemsHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addTaskFab = (FloatingActionButton) findViewById(R.id.fab);
        addTaskFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        menuRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        contentRecyclerView = (RecyclerView) findViewById(R.id.content_tasks_recyclerView);

        menuItemList = new ArrayList<TaskFolderItem>();
        ArrayList<String> strList = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            menuItemList.add(new TaskFolderItem("header" + i));
            strList.add(menuItemList.get(i).getName());
        }

        taskStorage = new TaskStorage(strList);

        menuRecyclerViewAdapter = new FolderRecyclerViewAdapter(this, menuItemList);
        menuRecyclerView.setAdapter(menuRecyclerViewAdapter);

        contentTaskItemList = taskStorage.getCurrentData("header0");
        contentRecyclerViewAdapter = new TaskRecyclerViewAdapter(this, contentTaskItemList);
        contentRecyclerView.setAdapter(contentRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        menuRecyclerView.setLayoutManager(linearLayoutManager);


        LinearLayoutManager contentLayoutManager = new LinearLayoutManager(this);
        contentLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contentRecyclerView.setLayoutManager(contentLayoutManager);

        bottomTaskEditLayout = (LinearLayout) findViewById(R.id.task_select_bottom_root);
        this.drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        //contentRecyclerView.


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            return;
        }

        if(isActionSelectMode) {
            onSelectionModeEnd();
        }
        else {
            super.onBackPressed();
            //System.exit(1);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu_tools, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onFolderSelect(int position) {
        System.out.println("OnFolderSelect()");


        String key = menuItemList.get(position).getName();
        contentTaskItemList = taskStorage.getCurrentData(key);
        //doesnt work
        //contentRecyclerViewAdapter.notifyItemRangeChanged(0, contentTaskItemList.size());
        //contentRecyclerView.invalidate();
        //

        //kostil(for changing recyclerView data)
        contentRecyclerViewAdapter = new TaskRecyclerViewAdapter(this, contentTaskItemList);
        contentRecyclerView.setAdapter(contentRecyclerViewAdapter);

        drawer.closeDrawer(GravityCompat.START);
    }

    public void onTaskSelect(int position) {

        if(!isActionSelectMode) {
            onSelectionModeBegin();
        }


        System.out.println("OnTaskSelect()");

        //
        return;
        /*if(!isActionSelectMode) {
            isActionSelectMode = true;
            toolbar.getMenu().clear();
            toolbar.inflateMenu(R.menu.main_menu_tools);
            selectedItemsHeader.setVisibility(View.VISIBLE);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        */
    }

    //ItemTouchHelper

    private void onSelectionModeBegin() {
        isActionSelectMode = true;
        bottomTaskEditLayout.setVisibility(View.VISIBLE);
        addTaskFab.setVisibility(View.GONE);

        contentRecyclerViewAdapter.setSelectionMode(true);
    }

    private void onSelectionModeEnd() {
        isActionSelectMode = false;
        bottomTaskEditLayout.setVisibility(View.GONE);
        addTaskFab.setVisibility(View.VISIBLE);
        contentRecyclerViewAdapter.setSelectionMode(false);
        contentRecyclerViewAdapter.notifyAllChanged();
    }
}
