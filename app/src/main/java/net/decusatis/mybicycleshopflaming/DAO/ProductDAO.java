package net.decusatis.mybicycleshopflaming.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import net.decusatis.mybicycleshopflaming.Entities.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product vacation);

    @Update
    void update(Product vacation);

    @Delete
    void delete(Product vacation);

    @Query("SELECT * FROM vacations ORDER BY vacationID ASC")
    List<Product> getAllVacations();
}
