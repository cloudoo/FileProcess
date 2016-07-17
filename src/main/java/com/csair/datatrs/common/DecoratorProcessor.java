package com.csair.datatrs.common;

/**
 * Created by cloudpj on 16/7/17.
 */
public class DecoratorProcessor implements Processor{
    Processor processor;

    public DecoratorProcessor(Processor processor){
        this.processor = processor;
    }
    @Override
    public void doit() {
        processor.doit();
    }
}
