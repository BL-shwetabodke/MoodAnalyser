package com.bridgelabz.moodanalayser;

public class MoodAnalyser {

    private String message;

    public MoodAnalyser() {}

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) throws MoodAnalyzerException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalyzerException {
        try {
            if(message.length() == 0)
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.IS_EMPTY, "Mood cannot be empty");
            return message.contains("sad") ? "SAD" : "HAPPY";
        } catch (NullPointerException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL, "Please enter valid mood");
        }
    }

    public String getMessage() {
        return message;
    }

    public boolean equals(Object obj) {
        MoodAnalyser moodAnalyser = (MoodAnalyser)obj;
        if(moodAnalyser.getMessage() == this.message)
            return true;
        return false;
    }
}
