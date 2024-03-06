package com.abc.bookstore.models;

public class ReadingStats {
    private Integer readingPercentage;
    private Integer timeRemainingToFinish;

    public Integer getReadingPercentage() {
        return readingPercentage;
    }

    public void setReadingPercentage(Integer readingPercentage) {
        this.readingPercentage =readingPercentage;
    }

    public Integer getTimeRemainingToFinish() {
        return timeRemainingToFinish;
    }

    public void setTimeRemainingToFinish(Integer timeRemainingToFinish) {
        this.timeRemainingToFinish = timeRemainingToFinish;
    }
}
