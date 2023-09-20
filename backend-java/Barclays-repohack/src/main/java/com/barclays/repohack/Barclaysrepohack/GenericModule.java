package com.barclays.repohack.Barclaysrepohack;

import com.google.inject.AbstractModule;
import com.regnosys.rosetta.common.validation.RosettaTypeValidator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.NoOpModelObjectValidator;
import com.rosetta.model.lib.process.PostProcessStep;

public class GenericModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ModelObjectValidator.class).to(NoOpModelObjectValidator.class);
        bind(PostProcessStep.class).to(RosettaTypeValidator.class);
    }
}
