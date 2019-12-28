package com.bridgelabz.moodanalayser;

public class MoodAnalyzerException extends Exception{

    private ExceptionType type;

    public enum ExceptionType {

        NULL, IS_EMPTY, NO_SUCH_CLASS_ERROR, NO_SUCH_FILED, NO_ACCESS, NO_SUCH_METHOD_ERROR, INVOCATION_ISSUE;
    }

    public MoodAnalyzerException(ExceptionType exceptionType, String message) {
        super(message);
        this.type = exceptionType;
    }

    public ExceptionType getType() {
        return type;
    }
}
