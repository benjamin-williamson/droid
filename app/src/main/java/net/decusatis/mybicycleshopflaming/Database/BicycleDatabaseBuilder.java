package net.decusatis.mybicycleshopflaming.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import net.decusatis.mybicycleshopflaming.DAO.PartDAO;
import net.decusatis.mybicycleshopflaming.DAO.ProductDAO;
import net.decusatis.mybicycleshopflaming.Entities.Part;
import net.decusatis.mybicycleshopflaming.Entities.Product;

@Database(entities = {Product.class, Part.class}, version = 2, exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BicycleDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BicycleDatabaseBuilder.class, "VacationScheduler.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
