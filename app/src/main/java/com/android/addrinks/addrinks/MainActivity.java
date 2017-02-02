package com.android.addrinks.addrinks;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements HeadlinesFragment.OnHeadlineSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement#
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        int duration = Toast.LENGTH_LONG;
        CharSequence def = "default";

        Toast toastChosenCoffee = Toast.makeText(getApplicationContext(),def,duration);

        RadioGroup capsGroup = (RadioGroup) findViewById(R.id.radio_group_caps);
        RadioGroup padsGroup = (RadioGroup) findViewById(R.id.radio_group_pads);
        RadioGroup beansGroup = (RadioGroup) findViewById(R.id.radio_group_beans);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_capsules:
                //if (checked)
                toastChosenCoffee.setText("Kapseln gewählt");
                toastChosenCoffee.show();
                capsGroup.setVisibility(View.VISIBLE);
                padsGroup.setVisibility(View.GONE);
                beansGroup.setVisibility(View.GONE);
                break;
            case R.id.radio_pads:
                //if (checked)
                toastChosenCoffee.setText("Pads gewählt");
                toastChosenCoffee.show();
                capsGroup.setVisibility(View.GONE);
                padsGroup.setVisibility(View.VISIBLE);
                beansGroup.setVisibility(View.GONE);
                break;
            case R.id.radio_beans:
                //if (checked)
                toastChosenCoffee.setText("Bohnenkaffee gewählt");
                toastChosenCoffee.show();
                capsGroup.setVisibility(View.GONE);
                padsGroup.setVisibility(View.GONE);
                beansGroup.setVisibility(View.VISIBLE);
                break;
            case R.id.radio_filter:
                //if (checked)
                toastChosenCoffee.setText("Filterkaffee gewählt");
                toastChosenCoffee.show();
                capsGroup.setVisibility(View.GONE);
                padsGroup.setVisibility(View.GONE);
                beansGroup.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onArticleSelected(int position) {

    }

    public void submitData(View view){
        Toast.makeText(view.getContext(), "Account data submitted!", Toast.LENGTH_SHORT).show();
    }
}
