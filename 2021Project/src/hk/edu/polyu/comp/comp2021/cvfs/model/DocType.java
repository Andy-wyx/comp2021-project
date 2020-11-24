package hk.edu.polyu.comp.comp2021.cvfs.model;

public enum DocType {
    TXT("txt"),JAVA("java"),HTML("html"),CSS("css");

    private final String type;
    private DocType(String type){this.type=type;}
    public String getType(){return this.type;}

}
