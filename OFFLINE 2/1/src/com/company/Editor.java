package com.company;

import parser.*;


public class Editor{
    private ParserFactory parserFactory = new ParserFactory();
    private SubParser subParser;
    private static Editor instace = new Editor();

    private Editor(){}

    public static Editor getInstace(){
        return instace;
    }

    public void chooseParser(String parserType){
        parserType = parserType.substring(parserType.lastIndexOf(".") + 1);
        subParser = parserFactory.getparser(parserType);
    }

    public void getparserInfo(){
        if(subParser == null)
            return;
        System.out.println(subParser.parse());
        System.out.println(subParser.font());
        System.out.println(" ");
    }
}
