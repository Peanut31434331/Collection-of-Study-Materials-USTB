#include<iostream>
using namespace std;

class �γ� 
{
  private: 
    string class_id;
    string ѧ��[];
  public:
    �γ�(){}
    �γ�(string class_id,string ѧ��[]){
        
        this.class_id = class_id;
        this.ѧ��[] = ѧ��[];
    }       
    
    void getclass_id(){
        return class_id;
    }
    void getѧ��[](){
        return ѧ��[];
    }
    
    void setclass_id(string class_id){
        this.class_id=class_id;
    }
    void setѧ��[](string ѧ��[]){
        this.ѧ��[]=ѧ��[];
    }
}