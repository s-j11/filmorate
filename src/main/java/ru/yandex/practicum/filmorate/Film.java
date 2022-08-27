package ru.yandex.practicum.filmorate;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Film {
    private int id;
    private String name;
    private String description;
    private LocalDate releaseData;
    private int duration;
}
