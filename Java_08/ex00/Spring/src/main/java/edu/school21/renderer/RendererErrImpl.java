package edu.school21.renderer;


import edu.school21.preProcessor.PreProcessor;
import org.springframework.stereotype.Component;


public class RendererErrImpl implements Renderer {

    private PreProcessor preProcessor;

    public RendererErrImpl(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }


    @Override
    public void sender(String str) {
        str = preProcessor.transform(str);
        System.err.println(str);
    }


    public PreProcessor getPreProcessor() {
        return preProcessor;
    }

    public void setPreProcessor(PreProcessor preProcessor) {
        this.preProcessor = preProcessor;
    }

}
