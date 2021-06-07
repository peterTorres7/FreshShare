package com.example.freshshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private TimePicker timePickerReminder;
    private TextView reminderTime, time;
    private String format = "";
    private Button reminderButton;

    @Override
    public void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        timePickerReminder = (TimePicker) view.findViewById(R.id.reminderTimePicker);
        reminderTime = (TextView) view.findViewById(R.id.yourReminderTimeIs);
        time = (TextView) view.findViewById(R.id.timeTextView);
        reminderButton = (Button) view.findViewById(R.id.reminderButton);
        reminderButton.setOnClickListener(v -> {
            int hour = timePickerReminder.getHour();
            int min = timePickerReminder.getMinute();
            if (hour == 0) {
                hour += 12;
                format = "AM";
            } else if (hour == 12) {
                format = "PM";
            } else if (hour > 12) {
                hour -= 12;
                format = "PM";
            } else {
                format = "AM";
            }
            time.setText(new StringBuilder().append(hour).append(" : ").append(min).append(" ").append(format));
        });

        Spinner distanceSpinner = (Spinner) view.findViewById(R.id.distanceSearchSpinner);
        ArrayAdapter<CharSequence> distanceAdapter = ArrayAdapter.createFromResource(getContext(), R.array.distance_array, android.R.layout.simple_spinner_item);
        distanceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distanceSpinner.setAdapter(distanceAdapter);
        return view;
    }
}

