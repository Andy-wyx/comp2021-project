package hk.edu.polyu.comp.comp2021.cvfs.model;

public class Doc {
    private String docName;
    private  String docType;
    private  String docContent;


    public Doc(String docName, String docType,String  docContent){
        this.docName = docName;
        this.docType = docType;
        this.docContent = docContent;
    }

    public Doc newDoc(String docName, String docType, String docContent){
        Doc newDoc = new Doc(docName,docType,docContent);
        return newDoc;
    }
    public String getDocName(){
        return docName;
    }
    public String getDocType(){
        return docType;
    }
    public String getDocContent(){
        return docContent;
    }
    public double getDocSize(){return 40+docContent.length()*2;}

    public boolean isDocNameSame(Doc other){
        if(docName == other.docName) return true;
        else return false;
    }
    public boolean isDocNameValid(){
        int m=0;
        for(int i=0;i<docName.length();i++){
            char a=docName.charAt(i);
            if(!(('0'<=a&&a<='9')||('a'<=a&&a<='z')||('A'<=a&&a<='Z'))){
                m+=1;
            }
        }
        if(docName.length()<=10){
            if(m==0){
                return true;
            }else return false;
        }else return false;
    }
    public Doc nextDoc;
    public Doc frontDoc;
    public Dir parentDir;

}
