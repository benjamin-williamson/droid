package net.decusatis.mybicycleshopflaming.Database;

import android.app.Application;

import net.decusatis.mybicycleshopflaming.DAO.PartDAO;
import net.decusatis.mybicycleshopflaming.DAO.ProductDAO;
import net.decusatis.mybicycleshopflaming.Entities.Part;
import net.decusatis.mybicycleshopflaming.Entities.Product;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final PartDAO mPartDAO;
    private final ProductDAO mProductDAO;
    private List<Product> mAllVacations;
    private List<Part> mAllExcursions;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        BicycleDatabaseBuilder db = BicycleDatabaseBuilder.getDatabase(application);
        mPartDAO = db.partDAO();
        mProductDAO = db.productDAO();
    }

    public List<Product> getAllVacations() {
        databaseExecutor.execute(() -> mAllVacations = mProductDAO.getAllVacations());
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return mAllVacations;
    }

    public void insert(Product vacation) {
        databaseExecutor.execute(() -> mProductDAO.insert(vacation));
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void update(Product vacation) {
        databaseExecutor.execute(() -> mProductDAO.update(vacation));
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void delete(Product vacation) {
        databaseExecutor.execute(() -> mProductDAO.delete(vacation));
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public List<Part> getAllExcursions() {
        databaseExecutor.execute(() -> mAllExcursions = mPartDAO.getAllExcursions());
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        return mAllExcursions;
    }

    public void insert(Part excursion) {
        databaseExecutor.execute(() -> mPartDAO.insert(excursion));
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void update(Part excursion) {
        databaseExecutor.execute(() -> mPartDAO.update(excursion));
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void delete(Part excursion) {
        databaseExecutor.execute(() -> mPartDAO.delete(excursion));
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
