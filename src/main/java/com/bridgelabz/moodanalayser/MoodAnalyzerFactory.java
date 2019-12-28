package com.bridgelabz.moodanalayser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public Constructor getConstructor(Class<?>... param) throws MoodAnalyzerException {
        try {
            Class moodAnalyserClass = Class.forName("com.bridgelabz.moodanalayser.MoodAnalyser");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS_ERROR, "No Such Class Error");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD_ERROR, "No Such Class Error");
        }

    }

    public MoodAnalyser createObject(Constructor constructor, String... message) throws MoodAnalyzerException {
        try {
            Object object = constructor.newInstance(message);
            return (MoodAnalyser) object;
        } catch (InstantiationException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FILED, "No Such Class Error");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_ACCESS, "No Such Class Error");
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.INVOCATION_ISSUE, "No Such Class Error");
        }
    }
}
