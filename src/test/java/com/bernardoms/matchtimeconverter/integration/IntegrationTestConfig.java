package com.bernardoms.matchtimeconverter.integration;

import com.bernardoms.matchtimeconverter.MatchTimeConverterApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(classes = MatchTimeConverterApplication.class,
        initializers = ConfigFileApplicationContextInitializer.class)
@ExtendWith(SpringExtension.class)
public abstract class IntegrationTestConfig {

}
