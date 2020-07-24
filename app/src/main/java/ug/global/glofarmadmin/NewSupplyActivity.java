package ug.global.glofarmadmin;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class NewSupplyActivity extends AppCompatActivity {
    TextInputEditText supplyname, supplydesc, supplyavailable, supplyprice;
    RadioGroup supply_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_supply);
        Toolbar toolbar = findViewById(R.id.addsupplytoolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(getColor(R.color.white));
        }

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        MaterialButton save = findViewById(R.id.savesupplies);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supplyname = findViewById(R.id.supplyname);
                supplydesc = findViewById(R.id.supplybrand);
                supplyavailable = findViewById(R.id.available);
                supplyprice = findViewById(R.id.supplyprice);
                supply_category = findViewById(R.id.supplygroup);
                int checked_id = supply_category.getCheckedRadioButtonId();
                String category = (String) ((RadioButton) findViewById(checked_id)).getText();
                String name = supplyname.getEditableText().toString();
                String desc = supplydesc.getEditableText().toString();
                String available = supplyavailable.getEditableText().toString();
                String price = supplyprice.getEditableText().toString();
                DatabaseReference supplies = FirebaseDatabase.getInstance().getReference("/supplies");
                DatabaseReference child = supplies.push();
                String key = child.getKey();
                Supply supply = new Supply(name, desc, category, available, price);
                assert key != null;
                supplies.child(key).setValue(supply);


            }
        });
    }

    static class Supply {

        private String supplyname;
        private String supplydescription;
        private String supplytype;
        private String availableamount;
        private String price;
        private String key;

        Supply(String supplyname, String supplydescription,/*, String key*/String supplytype, String availableamount, String price) {
            this.supplyname = supplyname;
            this.supplydescription = supplydescription;
            this.supplytype = supplytype;
            this.availableamount = availableamount;
            this.price = price;
        }

        public String getSupplyname() {
            return supplyname;
        }

        public String getSupplydescription() {
            return supplydescription;
        }

        public String getKey() {
            return key;
        }


        public String getSupplytype() {
            return supplytype;
        }

        public String getAvailableamount() {
            return availableamount;
        }

        public String getPrice() {
            return price;
        }
    }


}
