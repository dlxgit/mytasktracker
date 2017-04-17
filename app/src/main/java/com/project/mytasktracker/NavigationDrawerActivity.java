package com.project.mytasktracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.ContentTaskItem.TaskRecyclerViewAdapter;
import com.project.mytasktracker.DatePicking.DatePickingFragment;
import com.project.mytasktracker.MenuFolderItem.FolderRecyclerViewAdapter;
import com.project.mytasktracker.MenuFolderItem.TaskFolderItem;

import java.util.ArrayList;

public class NavigationDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, DatePickingFragment.OnFragmentInteractionListener {

    private RecyclerView menuRecyclerView;
    private FolderRecyclerViewAdapter menuRecyclerViewAdapter;

    private LinearLayout bottomTaskEditLayout;
    private ImageView bottomImageViewDone;
    private ImageView bottomImageViewDate;
    private ImageView bottomImageViewEdit;
    private ImageView bottomImageViewComment;
    private ImageView bottomImageViewReminder;

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


        this.drawer = (DrawerLayout) findViewById(R.id.drawer_root_layout);

        addTaskFab = (FloatingActionButton) findViewById(R.id.fab);
        addTaskFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



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
        bottomImageViewDone = (ImageView) findViewById(R.id.task_select_bottom_icon_done);
        bottomImageViewDate = (ImageView) findViewById(R.id.task_select_bottom_icon_date);
        bottomImageViewEdit = (ImageView) findViewById(R.id.task_select_bottom_icon_edit);
        bottomImageViewComment = (ImageView) findViewById(R.id.task_select_bottom_icon_message);
        bottomImageViewReminder = (ImageView) findViewById(R.id.task_select_bottom_icon_alarm);


        bottomImageViewDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTaskDone();
            }
        });
        bottomImageViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTaskDateEdit();
            }
        });
        bottomImageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTaskEdit();
            }
        });
        bottomImageViewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTaskCommentEdit();
            }
        });
        bottomImageViewReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTaskReminderEdit();
            }
        });
    }

    @Override
    public void onBackPressed() {
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


//    public void onTaskSelect() {
//
//        if(contentRecyclerViewAdapter.isSelectedListEmpty() && isActionSelectMode) {
//            onSelectionModeEnd();
//        }
//        else if(!isActionSelectMode) {
//            onSelectionModeBegin();
//        }
//
//        System.out.println("OnTaskSelect()");
//
//        //
//        return;
//        /*if(!isActionSelectMode) {
//            isActionSelectMode = true;
//            toolbar.getMenu().clear();
//            toolbar.inflateMenu(R.menu.main_menu_tools);
//            selectedItemsHeader.setVisibility(View.VISIBLE);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
//        */
//    }


    //ItemTouchHelper

    public void onSelectionModeBegin() {
        isActionSelectMode = true;
        bottomTaskEditLayout.setVisibility(View.VISIBLE);
        addTaskFab.setVisibility(View.GONE);

        contentRecyclerViewAdapter.setSelectionMode(true);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void onSelectionModeEnd() {
        isActionSelectMode = false;
        bottomTaskEditLayout.setVisibility(View.GONE);
        addTaskFab.setVisibility(View.VISIBLE);
        contentRecyclerViewAdapter.setSelectionMode(false);
        //contentRecyclerViewAdapter.notifyAllChanged();
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    //bottom bar functions
    public void onTaskDone() {
        contentRecyclerViewAdapter.doMarkAsDoneSelected();
        onSelectionModeEnd();
    }

    public void onTaskDateEdit() {
        Fragment fragment = new DatePickingFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.date_fragment_container, fragment);
        ft.commit();

        contentRecyclerViewAdapter.doEditDateSelected();
        onSelectionModeEnd();
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public void onTaskEdit() {
        contentRecyclerViewAdapter.doEditSelected();



        if(contentRecyclerViewAdapter.isAnySelected()) {
            TaskItem it = contentRecyclerViewAdapter.getFirstSelected();

            Intent intent = it.toIntent();
            intent.setClass(this, EditTaskActivity.class);
            startActivityForResult(intent, RESULT_OK);
            //TODO: edit

        }
        onSelectionModeEnd();
    }

    public void onTaskCommentEdit() {
        contentRecyclerViewAdapter.doEditCommentSelected();
        onSelectionModeEnd();
    }

    public void onTaskReminderEdit() {
        contentRecyclerViewAdapter.doEditReminder();
        onSelectionModeEnd();

        //contentRecyclerViewAdapter.bindViewHolder(contentRecyclerView.get);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            System.out.println("ActivityResulOK");
        }
        else if (resultCode == RESULT_CANCELED) {
            int abc = 3;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        onTaskDateEdit();
    }
}
