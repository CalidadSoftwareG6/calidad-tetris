package com.example.protetris;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {features = "src/androidTest/java/com/example/protetris/features"})

public class SmokeTestsRunner {

}
