import java.time.LocalDate;
import java.util.*;

public class Management {
    public static String contactidgenarate(){
        String str="";
        int size=Mainform.customerList.size()+1;
        if(size-1<9){
            str="C000"+size;
        }else if(size-1<99){
            str="C00"+size;
        }else if(size-1<999){
            str="C0"+size;
        }else if(size-1<9999){
            str="C"+size;
        }
        return str;
    }
    public boolean validatesalary(Double sal){				//--> VALIDATE SALARY METHOD.
        if(sal>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean validatephone(String phone){			//--> VALIDATE PHONE NUMBER METHOD.
        if(phone.length()==10){
            char str=phone.charAt(0);
            if(str=='0'){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean validday(int year,int month,int day){	//--> VALIDATE DAY METHOD.
        LocalDate currentdate = LocalDate.now();				//--> GET THE LOCAL DATE
        int currentYear=currentdate.getYear();    				//--> EXTRACTING THE YEAR VALUE FROM THE currentdate VARIABELE
        int currentMonthValue = currentdate.getMonthValue();	//--> EXTRACTING THE MONTH VALUE FROM THE currentdate VARIABELE
        int currentMonthDate=currentdate.getDayOfMonth();		//--> EXTRACTING THE DAY VALUE FROM THE currentdate VARIABELE

        boolean leap=true;
        if(year%400==0){
            leap=true;
        }else if(year%4==0){
            if(year%100==0){
                leap=false;
            }else{
                leap=true;
            }
        }else{
            leap=false;
        }

        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            if(day>=1 && day<=31){
                if(year==currentYear){
                    if(month==currentMonthValue){
                        if(day<currentMonthDate){
                            return true;
                        }
                    }else{
                        return true;
                    }
                }else if(year<currentYear){
                    return true;
                }
            }
            return false;
        }else if(month==4 || month==6 || month==9 || month==11){
            if(day>=1 && day<=30){
                if(year==currentYear){
                    if(month==currentMonthValue){
                        if(day<currentMonthDate){
                            return true;
                        }
                    }else{
                        return true;
                    }
                }else if(year<currentYear){
                    return true;
                }
            }
            return false;
        }else if(month==2){
            if(!leap){
                if(day>=1 && day<=28){
                    if(year==currentYear){
                        if(month==currentMonthValue){
                            if(day<currentMonthDate){
                                return true;
                            }
                        }else{
                            return true;
                        }
                    }else if(year<currentYear){
                        return true;
                    }
                }
                return false;
            }else{
                if(day>=1 && day<=29){
                    if(year==currentYear){
                        if(month==currentMonthValue){
                            if(day<currentMonthDate){
                                return true;
                            }
                        }else{
                            return true;
                        }
                    }else if(year<currentYear){
                        return true;
                    }
                }
                return false;
            }

        }
        return false;
    }
    public boolean validmonth(int year,int month){		//--> VALIDATE MONTH METHOD.
        LocalDate currentdate = LocalDate.now();				//--> GET THE LOCAL DATE
        int currentYear=currentdate.getYear();    				//--> EXTRACTING THE YEAR VALUE FROM THE currentdate VARIABELE
        int currentMonthValue = currentdate.getMonthValue();	//--> EXTRACTING THE MONTH VALUE FROM THE currentdate VARIABELE
        int currentMonthDate=currentdate.getDayOfMonth();		//--> EXTRACTING THE DAY VALUE FROM THE currentdate VARIABELE

        if(month>=1 && month<=12){	//--> CHECK WETHER THE USER INPUTER MONTH IS BETWEEN 1 AND 12
            if(year==currentYear){	//--> IF THE USER INPUTED YEAR IS CURRENT YEAR WE SHOULD CHECK WEATHER THE USER INPUTED MONTH LESS THAN OR EQUAL CURRENT MONTH
                if(month<=currentMonthValue){
                    return true;
                }
            }else if(year<currentYear){
                return true;
            }
        }
        return false;
    }
    public boolean validyear(int year){					//--> VALIDATE YEAR METHOD.
        LocalDate currentdate = LocalDate.now();				//--> GET THE LOCAL DATE
        int currentYear=currentdate.getYear();    				//--> EXTRACTING THE YEAR VALUE FROM THE currentdate VARIABELE
        int currentMonthValue = currentdate.getMonthValue();	//--> EXTRACTING THE MONTH VALUE FROM THE currentdate VARIABELE
        int currentMonthDate=currentdate.getDayOfMonth();		//--> EXTRACTING THE DAY VALUE FROM THE currentdate VARIABELE

        if(year<=currentYear){
            return true;
        }
        return false;
    }
    public boolean validatebday(String bday){			//--> VALIDATE DATE OF BIRTH METHOD.

        LocalDate currentdate = LocalDate.now();				//--> GET THE LOCAL DATE
        int currentYear=currentdate.getYear();    				//--> EXTRACTING THE YEAR VALUE FROM THE currentdate VARIABELE.
        int currentMonthValue = currentdate.getMonthValue();	//--> EXTRACTING THE MONTH VALUE FROM THE currentdate VARIABELE.
        int currentMonthDate=currentdate.getDayOfMonth();		//--> EXTRACTING THE DAY VALUE FROM THE currentdate VARIABELE.

        int year=Integer.parseInt(bday.substring(0,4));			//--> EXTRACTING THE YEAR VALUE FROM THE USER GIVEN INPUT.
        int month=Integer.parseInt(bday.substring(5,7));		//--> EXTRACTING THE MONTH VALUE FROM THE USER GIVEN INPUT.
        int day=Integer.parseInt(bday.substring(8));			//--> EXTRACTING THE DAY VALUE FROM THE USER GIVEN INPUT.

        boolean boolyear=validyear(year);			//--> GETING TRUE/FALSE BY VALIDATING THE YEAR THROUG A METHOD.
        boolean boolmonth=validmonth(year,month);	//--> GETING TRUE/FALSE BY VALIDATING THE MONTH THROUG A METHOD.
        boolean boolday=validday(year,month,day);	//--> GETING TRUE/FALSE BY VALIDATING THE DAY THROUG A METHOD.

        if(bday.length()==10){ //--> IF THE LENGTH IS NOT EQUAL TO 10 THEN RETURN FALSE.
            if(boolyear && boolmonth && boolday){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    public int search(String searchby){
        int count=0;
        for(Contact i : Mainform.customerList ){
            if ((i.getName() != null) && (i.getPhone() != null)) {
                if (i.getName().equals(searchby) || i.getPhone().equals(searchby)) {
                    return count;
                }else{
                    count++;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }

    public Contact[] SortByName(){
        Contact[] contacttemp=new Contact[Mainform.customerList.size()];
        for(int i=0;i<contacttemp.length;i++){
            contacttemp[i]=Mainform.customerList.get(i);
        }
        for (int i = 0; i < contacttemp.length-1; i++) {
            for (int j = 0; j < contacttemp.length - i -1; j++) {
                if (contacttemp[j].getName().charAt(0) > contacttemp[j + 1].getName().charAt(0)) {
                    Contact temp2 = contacttemp[j];
                    contacttemp[j]= contacttemp[j + 1];
                    contacttemp[j + 1] = temp2;
                }
            }
        }
        return contacttemp;
    }

    public Contact[] SortBySalary(){
        Contact[] contacttemp=new Contact[Mainform.customerList.size()];
        for(int i=0;i<contacttemp.length;i++){
            contacttemp[i]=Mainform.customerList.get(i);
        }
        boolean swap;
        for(int i=0;i<contacttemp.length-1;i++){
            swap=false;
            for(int j=0;j<contacttemp.length-i-1;j++){
                if(contacttemp[j].getSalary() < contacttemp[j+1].getSalary()){
                    Contact temp2=contacttemp[j];
                    contacttemp[j]=contacttemp[j+1];
                    contacttemp[j+1]=temp2;
                    swap=true;
                }
            }
            if(!swap)break;
        }
        return contacttemp;
    }
    public  Contact[] SortBybday(){
        Contact[] contacttemp=new Contact[Mainform.customerList.size()];
        for(int i=0;i<contacttemp.length;i++){
            contacttemp[i]=Mainform.customerList.get(i);
        }

        for(int i=0;i<contacttemp.length-1;i++){
            for(int j=0;j<contacttemp.length-i-1;j++){
                int year_1=Integer.parseInt(contacttemp[j].getBday().substring(0,4));
                int month_1=Integer.parseInt(contacttemp[j].getBday().substring(5,7));
                int day_1=Integer.parseInt(contacttemp[j].getBday().substring(8));

                int year_2=Integer.parseInt(contacttemp[j+1].getBday().substring(0,4));
                int month_2=Integer.parseInt(contacttemp[j+1].getBday().substring(5,7));
                int day_2=Integer.parseInt(contacttemp[j+1].getBday().substring(8));

                if(year_1>year_2){
                    Contact temp2=contacttemp[j];
                    contacttemp[j]=contacttemp[j+1];
                    contacttemp[j+1]=temp2;
                }else if(year_1==year_2){
                    if(month_1>month_2){
                        Contact temp3=contacttemp[j];
                        contacttemp[j]=contacttemp[j+1];
                        contacttemp[j+1]=temp3;
                    }else if(month_1==month_2){
                        if(day_1>day_2){
                            Contact temp4=contacttemp[j];
                            contacttemp[j]=contacttemp[j+1];
                            contacttemp[j+1]=temp4;
                        }
                    }
                }
            }
        }
        return contacttemp;
    }

    public static void updateid(){
        for(int i=0;i<Mainform.customerList.size();i++){
            if(i<9){
                Mainform.customerList.get(i).setId("C000"+i+1);
            }else if(i<99){
                Mainform.customerList.get(i).setId("C00"+i+1);
            }else if(i<999){
                Mainform.customerList.get(i).setId("C0"+i+1);
            }else if(i<9999){
                Mainform.customerList.get(i).setId("C"+i+1);
            }
        }
    }



}


