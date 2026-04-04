package net.decusatis.mybicycleshopflaming.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import net.decusatis.mybicycleshopflaming.Entities.Part;

import java.util.List;

@Dao
public interface PartDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Part excursion);

    @Update
    void update(Part excursion);

    @Delete
    void delete(Part excursion);

    @Query("SELECT * FROM excursions ORDER BY excursionID ASC")
    List<Part> getAllExcursions();
}
