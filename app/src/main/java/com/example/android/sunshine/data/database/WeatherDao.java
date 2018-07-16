package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.Date;

/**
 * Created by shijiefeng on 7/15/18.
 */

/**
 * {@link Dao} provides an api for all data operations.
 */
@Dao
public interface WeatherDao {

  /**
   * Gets the weather for a single day.
   *
   * @param date
   * @return
   */
  @Query("SELECT * FROM weather WHERE date = :date")
  WeatherEntry getWeatherByDate(Date date);

  /**
   * Inserts a list of {@link WeatherEntry} into the weather table.
   * If there is conflict (id or date), the weather entry uses the {@link OnConflictStrategy} of replacing weather forcast.
   * Required uniqueness is defined in {@link WeatherEntry}.
   *
   * @param weather A list of weather forecasts to insert
   */
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void bulkInsert(WeatherEntry... weather);
}