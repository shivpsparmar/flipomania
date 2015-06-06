package com.flipkart.flipomania;

import com.flipkart.flipomania.representations.ShortListed;
import com.flipkart.flipomania.services.Selector;
import com.google.inject.AbstractModule;

/**
 * Created by :- Shiv Pratap Singh Parmar
 * Created on :- 5/6/15.
 */
public class FlipomaniaModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ShortListed.class).to(ShortListed.class);
        bind(Selector.class).to(Selector.class);
    }
}
