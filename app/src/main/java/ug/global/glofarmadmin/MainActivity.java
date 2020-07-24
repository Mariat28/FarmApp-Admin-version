package ug.global.glofarmadmin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import ug.global.glofarmadmin.adapters.TabsAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("GloFarmAdmin");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.viewpager);
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.addcontent) {

            //options to display in dialog
            final String[] sortOptions = {"Dairy Farm FAQs", "Crop Husbandry FAQs"};
            //create alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select category to add FAQ").
                    setIcon(R.drawable.ic_help_black_24dp).
                    setItems(sortOptions, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int position) {
                            if (position == 0) {
                                Intent intent = new Intent(MainActivity.this, AddFaqActivity.class);
                                intent.putExtra("category", sortOptions[0]);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Dairy FAQs", Toast.LENGTH_SHORT).show();

                            } else if (position == 1) {

                                Intent intent = new Intent(MainActivity.this, AddFaqActivity.class);
                                intent.putExtra("category", sortOptions[1]);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "Crop Husbandry FAQs", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
            builder.create();

            builder.show();


        }
        return super.onOptionsItemSelected(item);
    }
}
