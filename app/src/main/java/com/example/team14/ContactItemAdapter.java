package com.example.team14;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactItemAdapter extends ArrayAdapter<ContactItem> {

    public ContactItemAdapter(@NonNull Context context, ArrayList<ContactItem> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_contact_item, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        ContactItem currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired image for the same
        TextView name = currentItemView.findViewById(R.id.contact_item_name);
        assert currentNumberPosition != null;
        name.setText(currentNumberPosition.getName());

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView phone = currentItemView.findViewById(R.id.contact_item_phone);
        phone.setText(currentNumberPosition.getPhone());

        // then according to the position of the view assign the desired TextView 2 for the same
        TextView mail = currentItemView.findViewById(R.id.contact_item_mail);
        mail.setText(currentNumberPosition.getMail());

        // then return the recyclable view
        return currentItemView;
    }
}
