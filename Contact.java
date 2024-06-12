class Contact{
    private String id;
    private String name;
    private String phone;
    private String company;
    private double salary;
    private String bday;

    Contact(String id,String name,String phone,String company,double salary,String bday){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.company=company;
        this.salary=salary;
        this.bday=bday;
    }

    //------------ SETTERS ----------------

    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setCompany(String company){
        this.company=company;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setBday(String bday){
        this.bday=bday;
    }

    //------------ GETTERS ----------------

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public String getCompany(){
        return company;
    }
    public double getSalary(){
        return salary;
    }
    public String getBday(){
        return bday;
    }
}