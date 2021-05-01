package parser;

public class ParserFactory {

    public SubParser getparser(String parse){
        if(parse.equalsIgnoreCase("c"))
            return new C();
        else if(parse.equalsIgnoreCase("cpp"))
            return new Cpp();
        else if(parse.equalsIgnoreCase("py"))
            return new Python();
        else
            return null;
    }
}
