package edu.school21.printer;


import edu.school21.renderer.Renderer;


public class PrinterWithPrefixImpl implements Printer{

    private Renderer renderer;
    private String prefix;
    public PrinterWithPrefixImpl( Renderer renderer) {
        this.renderer = renderer;
    }


    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    @Override
    public void print(String str) {
        renderer.sender(prefix + " " + str);
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }
}
