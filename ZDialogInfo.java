public class ZDialogInfo {
  private String nom, niveau, variante;
 
  public ZDialogInfo(){}
  public ZDialogInfo(String nom, String niveau, String variante){
    this.nom = nom;
    this.niveau = niveau;
    this.variante = variante;
  
  }
 
  public String toString(){
    String str;
    if(this.nom != null && this.niveau != null && this.variante != null ){
      str = "Description  InfoZDialog";
      str += "Nom : " + this.nom + "\n";
      str += "Niveau : " + this.niveau + "\n";
      str += "Variante : " + this.variante + "\n";

    }
    else{
      str = "Aucune information !";
    }
    return str;
  }
}
