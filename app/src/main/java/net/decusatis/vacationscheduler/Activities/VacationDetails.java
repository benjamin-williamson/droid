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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.decusatis.vacationscheduler.Database.Repository;
import net.decusatis.vacationscheduler.Entities.Excursion;
import net.decusatis.vacationscheduler.Entities.Vacation;
import net.decusatis.vacationscheduler.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class VacationDetails extends AppCompatActivity {
    int vacationID;
    EditText editTitle;
    EditText editHotel;
    TextView editStartDate;
    TextView editEndDate;
    Repository repository;
    Vacation currentVacation;

    final Calendar calStart = Calendar.getInstance();
    final Calendar calEnd = Calendar.getInstance();
    final String dateFormat = "MM/dd/yy";
    final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        editTitle = findViewById(R.id.productname);
        editHotel = findViewById(R.id.hotel);
        editStartDate = findViewById(R.id.startDate);
        editEndDate = findViewById(R.id.endDate);

        vacationID = getIntent().getIntExtra("id", -1);
        String name = getIntent().getStringExtra("name");
        String hotel = getIntent().getStringExtra("hotel");
        String startDate = getIntent().getStringExtra("startDate");
        String endDate = getIntent().getStringExtra("endDate");

        if (name != null) editTitle.setText(name);
        if (hotel != null) editHotel.setText(hotel);
        if (startDate != null) editStartDate.setText(startDate);
        if (endDate != null) editEndDate.setText(endDate);

        repository = new Repository(getApplication());

        DatePickerDialog.OnDateSetListener startListener = (view, year, month, day) -> {
            calStart.set(Calendar.YEAR, year);
            calStart.set(Calendar.MONTH, month);
            calStart.set(Calendar.DAY_OF_MONTH, day);
            editStartDate.setText(sdf.format(calStart.getTime()));
        };

        DatePickerDialog.OnDateSetListener endListener = (view, year, month, day) -> {
            calEnd.set(Calendar.YEAR, year);
            calEnd.set(Calendar.MONTH, month);
            calEnd.set(Calendar.DAY_OF_MONTH, day);
            editEndDate.setText(sdf.format(calEnd.getTime()));
        };

        editStartDate.setOnClickListener(v -> {
            String info = editStartDate.getText().toString();
            if (!info.isEmpty()) {
                try { calStart.setTime(sdf.parse(info)); } catch (ParseException e) { e.printStackTrace(); }
            }
            new DatePickerDialog(VacationDetails.this, startListener,
                    calStart.get(Calendar.YEAR), calStart.get(Calendar.MONTH),
                    calStart.get(Calendar.DAY_OF_MONTH)).show();
        });

        editEndDate.setOnClickListener(v -> {
            String info = editEndDate.getText().toString();
            if (!info.isEmpty()) {
                try { calEnd.setTime(sdf.parse(info)); } catch (ParseException e) { e.printStackTrace(); }
            }
            new DatePickerDialog(VacationDetails.this, endListener,
                    calEnd.get(Calendar.YEAR), calEnd.get(Calendar.MONTH),
                    calEnd.get(Calendar.DAY_OF_MONTH)).show();
        });

        RecyclerView recyclerView = findViewById(R.id.partrecyclerview);
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this,
                editStartDate.getText().toString(), editEndDate.getText().toString());
        recyclerView.setAdapter(excursionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for (Excursion e : repository.getAllExcursions()) {
            if (e.getVacationID() == vacationID) filteredExcursions.add(e);
        }
        excursionAdapter.setExcursions(filteredExcursions);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(v -> {
            if (vacationID == -1) {
                Toast.makeText(this, "Please save the vacation before adding excursions", Toast.LENGTH_LONG).show();
                return;
            }
            Intent intent = new Intent(VacationDetails.this, ExcursionDetails.class);
            intent.putExtra("vacationID", vacationID);
            intent.putExtra("vacationStartDate", editStartDate.getText().toString());
            intent.putExtra("vacationEndDate", editEndDate.getText().toString());
            startActivity(intent);
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

    private boolean isEndOnOrAfterStart(String startStr, String endStr) {
        try {
            sdf.setLenient(false);
            Date start = sdf.parse(startStr);
            Date end = sdf.parse(endStr);
            return start != null && end != null && !end.before(start);
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_productdetails, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        if (item.getItemId() == R.id.productsave) {
            String title = editTitle.getText().toString().trim();
            String hotel = editHotel.getText().toString().trim();
            String startDate = editStartDate.getText().toString().trim();
            String endDate = editEndDate.getText().toString().trim();

            if (title.isEmpty() || hotel.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
                return true;
            }
            if (!isValidDate(startDate)) {
                Toast.makeText(this, "Start date must be formatted as MM/dd/yy", Toast.LENGTH_LONG).show();
                return true;
            }
            if (!isValidDate(endDate)) {
                Toast.makeText(this, "End date must be formatted as MM/dd/yy", Toast.LENGTH_LONG).show();
                return true;
            }
            if (!isEndOnOrAfterStart(startDate, endDate)) {
                Toast.makeText(this, "End date must be on or after the start date", Toast.LENGTH_LONG).show();
                return true;
            }

            Vacation vacation;
            if (vacationID == -1) {
                List<Vacation> all = repository.getAllVacations();
                vacationID = all.isEmpty() ? 1 : all.get(all.size() - 1).getVacationID() + 1;
                vacation = new Vacation(vacationID, title, hotel, startDate, endDate);
                repository.insert(vacation);
            } else {
                vacation = new Vacation(vacationID, title, hotel, startDate, endDate);
                repository.update(vacation);
            }
            Toast.makeText(this, "Vacation saved", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (item.getItemId() == R.id.productdelete) {
            if (vacationID == -1) {
                Toast.makeText(this, "Nothing to delete", Toast.LENGTH_SHORT).show();
                return true;
            }
            for (Vacation v : repository.getAllVacations()) {
                if (v.getVacationID() == vacationID) currentVacation = v;
            }
            int excursionCount = 0;
            for (Excursion e : repository.getAllExcursions()) {
                if (e.getVacationID() == vacationID) excursionCount++;
            }
            if (excursionCount > 0) {
                Toast.makeText(this, "Cannot delete a vacation that has excursions associated with it", Toast.LENGTH_LONG).show();
            } else if (currentVacation != null) {
                repository.delete(currentVacation);
                Toast.makeText(this, "Vacation deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
            return true;
        }

        if (item.getItemId() == R.id.shareVacation) {
            StringBuilder sb = new StringBuilder();
            sb.append("Vacation: ").append(editTitle.getText().toString()).append("\n");
            sb.append("Hotel: ").append(editHotel.getText().toString()).append("\n");
            sb.append("Start Date: ").append(editStartDate.getText().toString()).append("\n");
            sb.append("End Date: ").append(editEndDate.getText().toString()).append("\n\n");
            sb.append("Excursions:\n");
            for (Excursion e : repository.getAllExcursions()) {
                if (e.getVacationID() == vacationID) {
                    sb.append("  - ").append(e.getTitle())
                      .append(" on ").append(e.getExcursionDate()).append("\n");
                }
            }
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, null));
            return true;
        }

        if (item.getItemId() == R.id.alertStart) {
            setVacationAlert(editStartDate.getText().toString(),
                    editTitle.getText().toString() + " starting");
            return true;
        }

        if (item.getItemId() == R.id.alertEnd) {
            setVacationAlert(editEndDate.getText().toString(),
                    editTitle.getText().toString() + " ending");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setVacationAlert(String dateStr, String message) {
        if (!isValidDate(dateStr)) {
            Toast.makeText(this, "Enter a valid date before setting an alert", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            sdf.setLenient(false);
            Date date = sdf.parse(dateStr);
            Intent intent = new Intent(VacationDetails.this, MyReceiver.class);
            intent.putExtra("key", message);
            PendingIntent sender = PendingIntent.getBroadcast(VacationDetails.this,
                    ++MainActivity.numAlert, intent, PendingIntent.FLAG_IMMUTABLE);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, date.getTime(), sender);
            Toast.makeText(this, "Alert set for " + dateStr, Toast.LENGTH_SHORT).show();
        } catch (ParseException e) {
            Toast.makeText(this, "Could not set alert: invalid date", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.partrecyclerview);
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this,
                editStartDate.getText().toString(), editEndDate.getText().toString());
        recyclerView.setAdapter(excursionAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Excursion> filteredExcursions = new ArrayList<>();
        for (Excursion e : repository.getAllExcursions()) {
            if (e.getVacationID() == vacationID) filteredExcursions.add(e);
        }
        excursionAdapter.setExcursions(filteredExcursions);
    }
}
