#include<iostream>
using namespace std;

class ���� : public �γ�
{
  private: 
    string ʱ��;
    string �ص�;
  public:
    ����(){}
    ����(string ʱ��,string �ص�){
        
        this.ʱ�� = ʱ��;
        this.�ص� = �ص�;
    }       
    
    void getʱ��(){
        return ʱ��;
    }
    void get�ص�(){
        return �ص�;
    }
    
    void setʱ��(string ʱ��){
        this.ʱ��=ʱ��;
    }
    void set�ص�(string �ص�){
        this.�ص�=�ص�;
    }
}