package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public interface MealRepository {
    // null if updated meal do not belong to userId
    Meal save(Meal meal, int userId);

    // false if meal do not belong to userId
    boolean delete(int id, int userId);

    // null if meal do not belong to userId
    Meal get(int id, int userId);

    // ORDERED dateTime desc
    Collection<Meal> getAll(int userId);

    Collection<Meal> getBetweenHalfOpen(int userId, LocalDateTime start, LocalDateTime end);
}
