package com.codigo.core.test.unit.suit;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.codigo.core.test.unit.test.HotelesTest;


@RunWith(Categories.class)
@IncludeCategory(PruebasUnitariasTest.class)
@SuiteClasses( { HotelesTest.class})
public class EMotelUnitSuite {

}
