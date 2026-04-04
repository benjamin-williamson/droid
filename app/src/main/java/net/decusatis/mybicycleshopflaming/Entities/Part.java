package net.decusatis.mybicycleshopflaming.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "excursions")
public class Part {
    @PrimaryKey(autoGenerate = true)
    private int excursionID;

    private String title;
    private String excursionDate;
    private int vacationID;

    public Part(int excursionID, String title, String excursionDate, int vacationID) {
        this.excursionID = excursionID;
        this.title = title;
        this.excursionDate = excursionDate;
        this.vacationID = vacationID;
    }

    public int getExcursionID() { return excursionID; }
    public void setExcursionID(int excursionID) { this.excursionID = excursionID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getExcursionDate() { return excursionDate; }
    public void setExcursionDate(String excursionDate) { this.excursionDate = excursionDate; }

    public int getVacationID() { return vacationID; }
    public void setVacationID(int vacationID) { this.vacationID = vacationID; }
}
