package edu.school21.renderer;

import edu.school21.preProcessor.PreProcessor;


public class RendererStandardImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererStandardImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }


    @Override
    public void sender(String str) {
        str = preProcessor.transform(str);
        System.out.println(str);
    }


    public PreProcessor getPreProcessor() {
        return preProcessor;
    }

    public void setPreProcessor(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

}
