package com.example.umar.mad_assignment_2;



        import android.annotation.SuppressLint;
        import android.content.Context;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import com.google.gson.Gson;
        import org.greenrobot.eventbus.EventBus;
        import org.greenrobot.eventbus.Subscribe;


@SuppressLint("ValidFragment")
class DetailsFragment extends Fragment {

    EventBus myEventBus;
    View rootView;
    Gson gson;
    TextView name;
    TextView number;
    TextView email;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        gson = new Gson();
        EventBus.getDefault().register(this);
        rootView = inflater.inflate(R.layout.fragment_details, container, false);
        name = (TextView) rootView.findViewById(R.id.name);
        email = (TextView) rootView.findViewById(R.id.email);
        number = (TextView) rootView.findViewById(R.id.number);
        return rootView;
    }

    @Subscribe
    public void onEvent(ContactDetailEvent event) {
        String str = event.getMessage();
        Contacts contact = gson.fromJson(str, Contacts.class);

        name.setText("Umar Farooq");
        email.setText("umarfarooq@gmail.com");
        number.setText("03104187789");
        /*name.setText(contact.getName().toString());
        email.setText(contact.getEmail().toString());
        number.setText(contact.getPhone().toString());*/
    }
}
