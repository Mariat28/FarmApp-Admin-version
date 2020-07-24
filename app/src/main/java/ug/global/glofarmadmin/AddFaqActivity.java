package ug.global.glofarmadmin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddFaqActivity extends AppCompatActivity {
    private TextInputEditText question, answer;
    private Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faq);
        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        savebutton = findViewById(R.id.savefaq);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    final String category = getIntent().getStringExtra("category");
                    assert category != null;
                    final String faq = question.getEditableText().toString();
                    final String faqanswer = answer.getEditableText().toString();
                    DatabaseReference faqreference = FirebaseDatabase.getInstance().getReference("/Frequently Asked Questions");
                    String key = faqreference.push().getKey();
                    FirebaseFaqs firebaseFaqs = new FirebaseFaqs(faq, faqanswer, category);
                    assert key != null;
                    faqreference.child(key).setValue(firebaseFaqs);
                    faqreference.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            question.setText("");
                            answer.setText("");
                            question.requestFocus();
                            Toast.makeText(AddFaqActivity.this, "FAQ added successfully" + faqanswer, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }

            }
        });


    }
}

class FirebaseFaqs {
    private String question;
    private String answer;
    private String category;

    public FirebaseFaqs() {
    }

    FirebaseFaqs(String question, String answer, String category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCategory() {
        return category;
    }
}
