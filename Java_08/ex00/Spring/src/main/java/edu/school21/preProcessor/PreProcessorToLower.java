package edu.school21.preProcessor;




public class PreProcessorToLower implements PreProcessor {

    public PreProcessorToLower() {

    }

    @Override
    public String transform(String str) {
        return str.toLowerCase();
    }
}
