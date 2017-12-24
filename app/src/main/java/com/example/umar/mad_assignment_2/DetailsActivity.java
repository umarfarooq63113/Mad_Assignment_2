package com.example.umar.mad_assignment_2;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import com.google.gson.Gson;
        import org.greenrobot.eventbus.EventBus;
/**
 * Created by Umer Farooq on 10/17/2017.
 */
public class DetailsActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Gson gs = new Gson();
        String trg = getIntent().getStringExtra("Contact");
        ContactDetailEvent contactDetailsEvent = new ContactDetailEvent(trg);
        EventBus.getDefault().post(contactDetailsEvent);
    }
}

