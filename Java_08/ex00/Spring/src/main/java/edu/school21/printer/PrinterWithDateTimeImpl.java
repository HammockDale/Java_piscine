package edu.school21.printer;

import edu.school21.renderer.Renderer;

import java.time.LocalDateTime;



public class PrinterWithDateTimeImpl implements Printer{

    private Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;

    }

    @Override
    public void print(String str) {
        renderer.sender(str + "\t" + LocalDateTime.now());

    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
