package app.ewtc.masterung.myungsrvice;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.ewtc.masterung.myungsrvice.fragment.MainFragment;
import app.ewtc.masterung.myungsrvice.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //    Explicit
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment To Activity
        addFragmentToActivity(savedInstanceState);

//        Drawer Controller
        drawerController();

//        Create Toolbar
        createToolbar();

    }   // Main Method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void createToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close
        );

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    private void addFragmentToActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
//            Status True

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment()).commit();

        }   // if
    }

    private void drawerController() {

        drawerLayout = findViewById(R.id.drawerLayoutMain);
        TextView mainTextView = findViewById(R.id.txtMain);
        TextView secondTextView = findViewById(R.id.txtSecond);
        TextView exitTextView = findViewById(R.id.txtExit);

        mainTextView.setOnClickListener(this);
        secondTextView.setOnClickListener(this);
        exitTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.txtMain:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new MainFragment()).commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.txtSecond:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new SecondFragment()).commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.txtExit:
                finish();
                break;
        }

    }
}   // Main Class
