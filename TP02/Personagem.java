import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Personagem{
    //Elementos

    private String id,name,house,ancestry,species,patronus,actorName,eyeColour,hairColor,gender;
    private ArrayList<String> alternate_names;
    private boolean hogwartsStudent,hogwartsStaff,alive,wizard;
    private LocalDate dateOfBirth;
    private int yearOfBirth;

    //Construtores
    public Personagem() {
        this.id = "";
        this.name = "";
        this.ancestry = "";
        this.species = "";
        this.patronus = "";
        this.actorName = "";
        this.eyeColour = "";
        this.hairColor = "";
        this.gender = "";
        this.house = "";
        this.yearOfBirth = 0;
        this.alternate_names = new ArrayList<String>();
    }

    public Personagem(String id, String name, String house, String ancestry, String species,
                      String patronus, String actorName, String eyeColour, String hairColor,
                      String gender, ArrayList<String> alternate_names, boolean hogwartsStudent,
                      boolean hogwartsStaff, boolean alive, boolean wizard, LocalDate dateOfBirth,
                      int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.actorName = actorName;
        this.eyeColour = eyeColour;
        this.hairColor = hairColor;
        this.gender = gender;
        this.alternate_names = alternate_names;
        this.hogwartsStudent = hogwartsStudent;
        this.hogwartsStaff = hogwartsStaff;
        this.alive = alive;
        this.wizard = wizard;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
    }
    //Métodos Get
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getHouse(){
        return this.house;
    }
    public String getAncestry(){
        return this.ancestry;
    }
    public String getSpecies(){
        return this.species;
    }
    public String getPatronus(){
        return this.patronus;
    }
    public String getActorname(){
        return this.actorName;
    }
    public String getEyeColour(){
        return this.eyeColour;
    }
    public String getHairColor(){
        return this.hairColor;
    }
    public String getGender(){
        return this.gender;
    }
    public ArrayList<String> getAlternateNames(){
        return this.alternate_names;
    }
    public boolean getHogwartsStudent(){
        return this.hogwartsStudent;
    }
    public boolean getHogwartsStaff(){
        return this.hogwartsStaff;
    }
    public boolean getAlive(){
        return this.alive;
    }
    public boolean getWizard(){
        return this.wizard;
    }
    public int getYear(){
        return this.yearOfBirth;
    }
    public LocalDate getDate(){
        return this.dateOfBirth;
    }

    //Métodos Set
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setHouse(String housename){
        this.house=housename;
    }
    public void setAncestry(String ancestry){
        this.ancestry = ancestry;
    }
    public void setSpecies(String species){
        this.species = species;
    }
    public void setPatronus(String patronus){
        this.patronus = patronus;
    }
    public void setActorName(String name){
        this.actorName = name;
    }
    public void setEyeColor(String color){
        this.eyeColour = color;
    }
    public void setHairColor(String color){
        this.hairColor = color;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setAlternateNames(ArrayList<String> names){
        this.alternate_names = names;
    }
    public void setHogwartsStudent(boolean isStudent){
        this.hogwartsStudent = isStudent;
    }
    public void setHogwartsStaff(boolean haveStaff){
        this.hogwartsStaff = haveStaff;
    }
    public void setAlive(boolean isAlive){
        this.alive = isAlive;
    }
    public void setWizard(boolean isWizard){
        this.wizard = isWizard;
    }
    public void setYear(int newYear){
        this.yearOfBirth = newYear;
    }
    public void setDate(LocalDate newDate){
        this.dateOfBirth = newDate;
    }

    //Método clone
    public void clone(Personagem newClone){
        newClone.setYear(this.getYear());
        newClone.setDate(this.getDate());   
        newClone.setHogwartsStaff(this.getHogwartsStaff());
        newClone.setAlive(this.getAlive());
        newClone.setWizard(this.getWizard());
        newClone.setGender(this.getGender());
        newClone.setAlternateNames(this.getAlternateNames());
        newClone.setGender(this.getGender());
        newClone.setHogwartsStudent(this.getHogwartsStudent());
        newClone.setHairColor(this.getHairColor());
        newClone.setEyeColor(this.getEyeColour());
        newClone.setPatronus(this.getPatronus());
        newClone.setSpecies(this.getSpecies());
        newClone.setAncestry(this.getAncestry());
        newClone.setHouse(this.getHouse());
        newClone.setName(this.getName());
        newClone.setId(this.getId());

    }

    //Método de imprimir
    public void imprimir(){
        System.out.println("\n"+ "Id: "+this.getId()+ " Nome: "+this.getName()+ " Casa: "+this.getHouse() + "\n"+
        "Ancestralidade: "+this.getAncestry()+ " Espécie: "+this.getSpecies()+ " Patrono: " + this.getPatronus()+ "\n"+
        "Ator: "+this.getActorname()+" Cor olho: "+this.getEyeColour()+ " Cor Cabelo: "+this.getHairColor()+ "\n"+
        "Genero: "+this.getGender()+ " Nomes Alternativos: "+this.getAlternateNames()+ " Estudante: "+this.getHogwartsStudent()+"\n"+
        "Varinha: "+this.getHogwartsStaff()+" Vivo: "+this.getAlive()+ " Bruxo: "+this.getWizard()+"\n"+
        "Nascimento: "+this.getDate() + " Ano de Nascimento: " + this.getYear()
        );
        
    }

    //Método de Ler
    public void ler(String id){
        String path = "tmp/characters.csv";
        try{
            File dados = new File(path);
            Scanner sc = new Scanner(dados);

            if(sc.hasNextLine()){
                sc.nextLine();
            }
            
            while(sc.hasNextLine()){
                String linha = sc.nextLine();
                int p = 0;
                while(linha.charAt(p) != '['){
                    p++;
                }
                int j = p;
                while(linha.charAt(j) != ']'){
                    j++;
                }
                int ind = p;
                int end = j;
                String linhamanipulada = "";
                for(int m = 0; m<ind-1; m++){
                    linhamanipulada+= linha.charAt(m);
                }
                ind+=1;
                for(;ind<end;ind++){
                    if(linha.charAt(ind) == ','){
                        linhamanipulada+= ';';
                    } else{ 
                        linhamanipulada+=linha.charAt(ind);
                    }
                }
                int mid = linha.length()-1;
                int mid2 = linha.length()-1;
                for(;linha.charAt(mid) != '['; mid--);
                for(;linha.charAt(mid2) != ']'; mid2--);
                end+=2;
                for(;end<mid;end++){
                    linhamanipulada += linha.charAt(end);
                }
                for(;mid<mid2;mid++){
                    if(linha.charAt(mid) == ','){
                        linhamanipulada+= ';';
                    } else{ 
                        linhamanipulada+=linha.charAt(mid);
                    }
                }
                for(int t = mid2;t<linha.length();t++){
                    linhamanipulada+=linha.charAt(t);
                }



                String[] colunas = linhamanipulada.split(",");

                if(colunas.length>0 && colunas[0].equals(id)){
                    this.setId(colunas[0]);
                    this.setName(colunas[1]);
                    this.setHouse(colunas[3]);
                    this.setAncestry(colunas[4]);
                    this.setSpecies(colunas[5]);
                    this.setPatronus(colunas[6]);
                    this.setHogwartsStaff(Boolean.parseBoolean(colunas[7]));
                    this.setHogwartsStudent(Boolean.parseBoolean(colunas[8]));
                    this.setActorName(colunas[9]);
                    this.setAlive(Boolean.parseBoolean(colunas[10]));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    this.setDate(LocalDate.parse(colunas[12],formatter));
                    this.setYear(Integer.parseInt(colunas[13]));
                    this.setEyeColor(colunas[14]);
                    this.setGender(colunas[15]);
                    this.setHairColor(colunas[16]);
                    this.setWizard(Boolean.parseBoolean(colunas[17]));

                    String nomesAlternativos = colunas[2];
                    String nomes[] = nomesAlternativos.split(";");
                    //padronizar
                    for(int n = 0; n< nomes.length; n++){
                        if(nomes[n].charAt(0) == ' '){
                            String aux = "";
                            for(int x = 0; x<nomes[n].length()-1; x++){
                                aux += nomes[n].charAt(x+1);
                            }
                            nomes[n] = aux;
                        }
                    }

                    ArrayList<String> Alternativos = new ArrayList<String>();
                    for(int i = 0; i<nomes.length; i++){
                        Alternativos.add(nomes[i]);
                    }
                    this.setAlternateNames(Alternativos);
                }
            }
            sc.close();
        }catch(FileNotFoundException erro){
            erro.printStackTrace();
        }
    }


    //Outros métodos
    public void addName(String name){
        this.alternate_names.add(name);
    }
}