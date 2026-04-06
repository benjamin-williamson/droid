package net.decusatis.vacationscheduler.Activities;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.decusatis.vacationscheduler.Database.Repository;
import net.decusatis.vacationscheduler.Entities.Excursion;
import net.decusatis.vacationscheduler.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ExcursionDetails extends AppCompatActivity {
    int excursionID;
    int vacationID;
    String vacationStartDate;
    String vacationEndDate;
    EditText editTitle;
    TextView editDate;
    Repository repository;

    final Calendar calDate = Calendar.getInstance();
    final String dateFormat = "MM/dd/yy";
    final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_details);

        repository = new Repository(getApplication());
        editTitle = findViewById(R.id.partName);
        editDate = findViewById(R.id.date);

        excursionID = getIntent().getIntExtra("id", -1);
        vacationID = getIntent().getIntExtra("vacationID", -1);
        vacationStartDate = getIntent().getStringExtra("vacationStartDate");
        vacationEndDate = getIntent().getStringExtra("vacationEndDate");

        String name = getIntent().getStringExtra("name");
        String excursionDate = getIntent().getStringExtra("excursionDate");
        if (name != null) editTitle.setText(name);
        if (excursionDate != null) editDate.setText(excursionDate);

        DatePickerDialog.OnDateSetListener dateListener = (view, year, month, day) -> {
            calDate.set(Calendar.YEAR, year);
            calDate.set(Calendar.MONTH, month);
            calDate.set(Calendar.DAY_OF_MONTH, day);
            editDate.setText(sdf.format(calDate.getTime()));
        };

        editDate.setOnClickListener(v -> {
            String info = editDate.getText().toString();
            if (!info.isEmpty()) {
                try { calDate.setTime(sdf.parse(info)); } catch (ParseException e) { e.printStackTrace(); }
            }
            new DatePickerDialog(ExcursionDetails.this, dateListener,
                    calDate.get(Calendar.YEAR), calDate.get(Calendar.MONTH),
                    calDate.get(Calendar.DAY_OF_MONTH)).show();
        });
    }

    private boolean isValidDate(String dateStr) {
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private boolean isDateInVacationRange(String dateStr) {
        if (vacationStartDate == null || vacationEndDate == null
                || vacationStartDate.isEmpty() || vacationEndDate.isEmpty()) {
            return true;
        }
        try {
            sdf.setLenient(false);
            Date excDate = sdf.parse(dateStr);
            Date vacStart = sdf.parse(vacationStartDate);
            Date vacEnd = sdf.parse(vacationEndDate);
            return excDate != null && vacStart != null && vacEnd != null
                    && !excDate.before(vacStart) && !excDate.after(vacEnd);
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_partdetails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        if (item.getItemId() == R.id.partsave) {
            String title = editTitle.getText().toString().trim();
            String dateStr = editDate.getText().toString().trim();

            if (title.isEmpty() || dateStr.isEmpty()) {
                Toast.makeText(this, "Title and date are required", Toast.LENGTH_LONG).show();
                return true;
            }
            if (!isValidDate(dateStr)) {
                Toast.makeText(this, "Date must be formatted as MM/dd/yy", Toast.LENGTH_LONG).show();
                return true;
            }
            if (!isDateInVacationRange(dateStr)) {
                Toast.makeText(this, "Excursion date must fall within the vacation's start and end dates", Toast.LENGTH_LONG).show();
                return true;
            }

            Excursion excursion;
            if (excursionID == -1) {
                List<Excursion> all = repository.getAllExcursions();
                excursionID = all.isEmpty() ? 1 : all.get(all.size() - 1).getExcursionID() + 1;
                excursion = new Excursion(excursionID, title, dateStr, vacationID);
                repository.insert(excursion);
            } else {
                excursion = new Excursion(excursionID, title, dateStr, vacationID);
                repository.update(excursion);
            }
            Toast.makeText(this, "Excursion saved", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (item.getItemId() == R.id.partdelete) {
            if (excursionID == -1) {
                Toast.makeText(this, "Nothing to delete", Toast.LENGTH_SHORT).show();
                return true;
            }
            Excursion toDelete = null;
            for (Excursion e : repository.getAllExcursions()) {
                if (e.getExcursionID() == excursionID) {
                    toDelete = e;
                    break;
                }
            }
            if (toDelete != null) {
                repository.delete(toDelete);
                Toast.makeText(this, "Excursion deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
            return true;
        }

        if (item.getItemId() == R.id.notify) {
            String dateStr = editDate.getText().toString().trim();
            String title = editTitle.getText().toString().trim();
            if (!isValidDate(dateStr)) {
                Toast.makeText(this, "Enter a valid date before setting an alert", Toast.LENGTH_SHORT).show();
                return true;
            }
            try {
                sdf.setLenient(false);
                Date date = sdf.parse(dateStr);
                Intent intent = new Intent(ExcursionDetails.this, MyReceiver.class);
                intent.putExtra("key", title);
                PendingIntent sender = PendingIntent.getBroadcast(ExcursionDetails.this,
                        ++MainActivity.numAlert, intent, PendingIntent.FLAG_IMMUTABLE);
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, date.getTime(), sender);
                Toast.makeText(this, "Alert set for " + dateStr, Toast.LENGTH_SHORT).show();
            } catch (ParseException e) {
                Toast.makeText(this, "Could not set alert: invalid date", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
