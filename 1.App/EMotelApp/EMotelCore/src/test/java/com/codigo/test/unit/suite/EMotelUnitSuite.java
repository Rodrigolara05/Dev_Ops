package com.codigo.test.unit.suite;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.codigo.test.unit.test.HotelesTest;

@RunWith(Categories.class)
@IncludeCategory(PruebasUnitariasTest.class)
@SuiteClasses( { HotelesTest.class})
public class EMotelUnitSuite {

}
