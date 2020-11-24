package hk.edu.polyu.comp.comp2021.cvfs.model;

public class Dir{
    private String dirName;
    private Doc[] docs;
    private Dir[] dirs;
    private static final int INITIAL=100;
    private int docNum=0;
    private int dirNum=0;

    public Dir(String dirName){
        this.dirName = dirName;
        this.docs=new Doc[INITIAL];
        this.dirs=new Dir[INITIAL];

    }
    public Dir newDir(String dirName){
        Dir newDir = new Dir(dirName);
        return newDir;
    }
    public void addDoc(Doc doc){
        if(docNum==INITIAL){
            System.out.println("overflow");
        } else {
            docs[docNum++] = doc;
        }
    }
    public void addDir(Dir dir){
        if(dirNum==INITIAL){
            System.out.println("overflow");
        } else {
            dirs[dirNum++] = dir;
        }
    }
    public void delDoc(Doc doc){
        if(docNum==0){System.out.println("underflow");}
        else{
            if(docNum==1){
                docNum=0;
            }else{
                int index=0;
                int existence=0;
                for(int i=0;i<docNum;i++){
                    if(docs[i]==doc){
                        index=i;
                        existence+=1;
                    }
                }
                if(existence!=0){
                    docs[index]=docs[docNum-1];
                    docNum--;
                }else{System.out.println("No such file exists.");}
            }
        }
    }

    public String getDirName(){
        return dirName;
    }
    public double getDirSize(){
        double result=0;
        if(docNum!=0){
            for(int i=0;i<docNum;i++){
                result+=(docs[i].getDocSize());
            }
        }
        if(dirNum!=0){
            for(int i=0;i<dirNum;i++){
                result+=(dirs[i].getDirSize());
            }
        }
        result+=40;
        return result;
    }

    public boolean isDirNameSame(Dir other){
        boolean result = true;
        if(dirName == other.dirName) result = true;
        else {result = false;}
        return result;
    }
    public Dir nextDir;
    public Dir frontDir;
    public Dir parentDir;
    public Dir firstchildDir;
    public Doc firstchildDoc;
}
