package ug.global.glofarmadmin;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AddNewToolActivity extends AppCompatActivity {
    TextInputEditText toolname, toolprice, toolsavailable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_tool);
        Toolbar toolbar = findViewById(R.id.addtooltoolbar);
        setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            toolbar.setTitleTextColor(getColor(R.color.white));
        }

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        MaterialButton save = findViewById(R.id.savetool);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toolname = findViewById(R.id.toolname);
                toolprice = findViewById(R.id.toolprice);
                toolsavailable = findViewById(R.id.toolsavailable);

                String name = toolname.getEditableText().toString();
                String price = toolprice.getEditableText().toString();
                String available = toolsavailable.getEditableText().toString();

                DatabaseReference Tools = FirebaseDatabase.getInstance().getReference("/tools");
                DatabaseReference child = Tools.push();
                String key = child.getKey();
                Toolclass toolclass = new Toolclass(price, name, available);
                assert key != null;
                Tools.child(key).setValue(toolclass);
                toolname.setText("");
                toolprice.setText("");
                toolsavailable.setText("");
                toolname.requestFocus();
                Toast.makeText(AddNewToolActivity.this, "Tool Added", Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class Toolclass {

        private String toolprice;
        private String toolname;
        private String availabletools;

        Toolclass(String toolprice, String toolname, String availabletools) {
            this.toolprice = toolprice;
            this.toolname = toolname;
            this.availabletools = availabletools;
        }

        public String getToolprice() {
            return toolprice;
        }

        public String getToolname() {
            return toolname;
        }

        public String getAvailabletools() {
            return availabletools;
        }

    }
}
