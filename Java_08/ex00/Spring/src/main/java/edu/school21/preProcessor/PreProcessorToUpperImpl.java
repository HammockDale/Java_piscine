package edu.school21.preProcessor;

import org.springframework.stereotype.Component;

@Component
public class PreProcessorToUpperImpl implements PreProcessor{
    public PreProcessorToUpperImpl() {

    }

    @Override
    public String transform(String str) {
        return str.toUpperCase();
    }
}
