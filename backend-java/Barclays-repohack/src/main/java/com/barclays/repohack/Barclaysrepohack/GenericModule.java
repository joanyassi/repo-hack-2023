package com.barclays.repohack.Barclaysrepohack;

import com.google.inject.AbstractModule;

public class GenericModule extends AbstractModule {

    @Override
    protected void configure() {
       // bind(ModelObjectValidator.class).to(RosettaTypeValidator.class);
       // bind(PostProcessStep.class).to(RosettaTypeValidator.class);
    }
}
