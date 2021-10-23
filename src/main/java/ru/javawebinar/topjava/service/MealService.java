package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static ru.javawebinar.topjava.util.DateTimeUtil.endExclusive;
import static ru.javawebinar.topjava.util.DateTimeUtil.startInclusive;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFound;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private final MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public Meal create(Meal meal, int useId) {
        return repository.save(meal,useId);
    }

    public void delete(int id, int useId) {
        checkNotFoundWithId(repository.delete(id, useId), id);
    }

    public Meal get(int id, int useId) {
        return checkNotFoundWithId(repository.get(id, useId), id);
    }

    public Collection<Meal> getAll(int useId) {
        return repository.getAll(useId);
    }

    public void update(Meal meal, int useId) {
        checkNotFoundWithId(repository.save(meal, useId), meal.getId());
    }

    public Collection<Meal> isBetweenHalfOpen(int userId, LocalDate start, LocalDate end) {
        return repository.getBetweenHalfOpen (userId, startInclusive(start),endExclusive(end) );
    }

}