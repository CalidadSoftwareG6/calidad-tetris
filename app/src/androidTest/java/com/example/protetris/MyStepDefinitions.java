package com.example.protetris;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(glue = "com.example.protetris.steps", plugin = {"junit:/data/data/com.mytest/JUnitReport.xml", "json:/data/data/com.mytest/JSONReport.json"}, tags = { "~@wip" }, features = "features")
@RunWith(Cucumber.class)
public class MyStepDefinitions{
}