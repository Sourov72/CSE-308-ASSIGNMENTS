package parser;

import parser.aesthetics.Aesthetics;

public abstract class SubParser implements Parser, Aesthetics {
    public abstract String font();
    public abstract String parse();

    @Override
    public String color() {
        return "font color is blue";
    }
    @Override
    public String style(){
        return "font style is normal";
    }
}
