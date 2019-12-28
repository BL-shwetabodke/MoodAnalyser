package com.bridgelabz.moodanalysertest;

import com.bridgelabz.moodanalayser.MoodAnalyser;
import com.bridgelabz.moodanalayser.MoodAnalyzerException;
import com.bridgelabz.moodanalayser.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

public class MoodAnalyserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before

    @Test
    public void givenMoodSad_ThenReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenMoodHappy_ThenReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any mood");
        String mood = null;
        try {
            mood = moodAnalyser.analyseMood();
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", mood);
    }

    @Test
    public void givenMoodIsNull_ThenReturnException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NULL, e.getType());
        }
    }

    @Test
    public void givenMoodIsEmpty_ThenReturnException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.IS_EMPTY, e.getType());
        }
    }

    @Test
    public void givenMoodAnalyserClass_NotPresent_ThenReturnException() {
//        Optional message = Optional.of(new String("This is sad message"));
        try {
//            MoodAnalyser moodAnalyser = new MoodAnalyzerFactory().createObject("com.bridgelabz.moodanalayser.MoodAnanalyzer", "This is sad message");
            Constructor constructor = new MoodAnalyzerFactory().getConstructor(String.class);
            MoodAnalyser moodAnalyser = new MoodAnalyzerFactory().createObject(constructor, "This is sad message");
            Assert.assertEquals(new MoodAnalyser("This is sad message"), moodAnalyser);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS_ERROR, e.getType());
        }
    }

    @Test
    public void givenConstructor_IsNotProper() {
        try {
            Constructor constructor = new MoodAnalyzerFactory().getConstructor();
            MoodAnalyser moodAnalyser = new MoodAnalyzerFactory().createObject(constructor);
            Assert.assertEquals(new MoodAnalyser(), moodAnalyser);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }
}
