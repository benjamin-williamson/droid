package net.decusatis.vacationscheduler.Database;

import android.app.Application;

import net.decusatis.vacationscheduler.DAO.ExcursionDAO;
import net.decusatis.vacationscheduler.DAO.VacationDAO;
import net.decusatis.vacationscheduler.Entities.Excursion;
import net.decusatis.vacationscheduler.Entities.Vacation;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {
    private final ExcursionDAO mExcursionDAO;
    private final VacationDAO mVacationDAO;

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Repository(Application application) {
        VacationDatabase db = VacationDatabase.getDatabase(application);
        mExcursionDAO = db.excursionDAO();
        mVacationDAO = db.vacationDAO();
    }

    public List<Vacation> getAllVacations() {
        try {
            return databaseExecutor.submit(() -> mVacationDAO.getAllVacations()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(Vacation vacation) {
        try {
            databaseExecutor.submit(() -> mVacationDAO.insert(vacation)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Vacation vacation) {
        try {
            databaseExecutor.submit(() -> mVacationDAO.update(vacation)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Vacation vacation) {
        try {
            databaseExecutor.submit(() -> mVacationDAO.delete(vacation)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Excursion> getAllExcursions() {
        try {
            return databaseExecutor.submit(() -> mExcursionDAO.getAllExcursions()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(Excursion excursion) {
        try {
            databaseExecutor.submit(() -> mExcursionDAO.insert(excursion)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Excursion excursion) {
        try {
            databaseExecutor.submit(() -> mExcursionDAO.update(excursion)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Excursion excursion) {
        try {
            databaseExecutor.submit(() -> mExcursionDAO.delete(excursion)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
