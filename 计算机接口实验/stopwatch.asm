  
IO8255_MODE EQU 28BH
IO8255_A EQU 288H
IO8255_B EQU 289H
IO8255_C EQU 28AH

I8259_1 EQU 2B0H
I8259_2 EQU 2B1H
I8259_3 EQU 2B1H
I8259_4 EQU 2B1H
O8259_1 EQU 2B1H		
O8259_2 EQU 2B0H
O8259_3 EQU 2B0H

IO8254_MODE EQU 283H
IO8254_COUNT0 EQU 280H
IO8254_COUNT1 EQU 281H


DATA SEGMENT
		SIGNAL DB 00H  	;��SIGNAL=0ʱ���������ͣ״̬����SIGNAL=1ʱ������ڼ�ʱ״̬
        MINUTE DB 00H	;��ʾ���ķ���			
       	SECOND DB 00H	;��ʾ��������
        MILLISECOND DB 00H	;��ʾ����
		OUTMAP DB 00H,01H,02H,03H,04H,05H,06H,07H,08H,09H ;���ڸ�OUTBUF��ֵ��ͨ��BX+AL�ҵ���Ӧ��λ�ã���ô���д洢�����־�Ӧ����OUTBUF��Ӧλ����ֵ
		OUTBUF DB 0,0,0,0,0,0	;���ڴ洢MINUTE(����λ����SECOND������λ����MILLISECOND������λ������λ��ÿһλ���������ֵ
		LCDMAP DW 0A3B0H,0A3B1H,0A3B2H,0A3B3H,0A3B4H,0A3B5H,0A3B6H,0A3B7H,0A3B8H,0A3B9H	;0,1,2,3,4,5,6,7,8,9��LCD����ʾ���ַ���
		HZ_TAB DW 0A3B0H,0A3B0H,0A1C3H,0A3B0H,0A3B0H,0A1C3H,0A3B0H,0A3B0H	;��LCD���ʼĬ����ʾΪ"00:00:00"
               DW 0B8B4H,0CEBBH,0A3A0H,0A3A0H,0A3A0H,0A3A0H,0C6F4H,0B6AFH	;��LCD����ʾ"��λ        ����"
		       DW 0BCC6H,0CAB1H,0A3A0H,0A3A0H,0A3A0H,0A3A0H,0CDA3H,0D6B9H	;��LCD����ʾ"��ʱ        ֹͣ"
		HZ_ADR DB ?;�����ʾ����ʼ�˿ڵ�ַ
DATA ENDS

STACKS SEGMENT
		DB 100 DUP(?)
STACKS ENDS
STACK1 SEGMENT STACK
		DW 256 DUP(?)
STACK1 ENDS

CODE SEGMENT
		ASSUME CS:CODE,DS:DATA,SS:STACKS,ES:DATA
START:
.386	;����PC���ڲ��жϣ�����DOS�ж�21H�͸����жϷ��������ڵ�ַ��25H���������ж�����	
		CLI				;���ж�
		MOV AX,CS
		MOV DS,AX
		MOV DX,OFFSET RIGHT_KEY	;RIGHT_KEY�жϷ������Ķλ�ַ
		MOV AX,2572H	;�Ҽ��������ӵ�USB���İ��ϵ�IR10������IR10�ӵ���10���ж�IRQ10�ϣ���Ӧ���ж����ͺ�Ϊ72H
		INT 21H
		MOV DX,OFFSET LEFT_KEY	;LEFT_KEY�жϷ������Ķλ�ַ
		MOV AX,250BH	;����������ӵ�ʵ��ϵͳ��������IRQ�ϣ�����IRQ�ӵ���3���ж�IRQ3�ϣ���Ӧ���ն����ͺ�Ϊ0BH
		INT 21H
		IN AL,21H		;д��Ƭ��OCW1��������Ƭ��2��3�Ŷ˿�
		AND AL,0F3H
		OUT 21H,AL	
		IN AL,0A1H		;д��Ƭ��OCW1������10�Ŷ˿�
		AND AL,0FBH	
		OUT 0A1H,AL

		;ʹ���������ṩ��8259�ж�Դ����PC���ύ�ж�����
		MOV AX,DATA
		MOV DS,AX
		MOV ES,AX
		MOV AX,STACKS
		MOV SS,AX
		MOV DX,I8259_1  ;��ʼ��8259��ICW1
		MOV AL,13H	    ;���ش�������Ƭ8259����ҪICW4
		OUT DX,AL
		MOV DX,I8259_2  ;��ʼ��8259��ICW2
		MOV AL,0B0H
		OUT DX,AL
		MOV AL,03H     	;��ʼ��8259��ICW4
		OUT DX,AL
		MOV DX,O8259_1 	;��ʼ��8259���ж����β���������OCW1
		MOV AL,00H
		OUT DX,AL

		;����8254�Ĺ�����ʽ
		MOV AX,DATA
		MOV DS,AX
		MOV DX,IO8254_MODE		;���ü�����0�Ĺ�����ʽ
		MOV AL,16H
		OUT DX,AL
		MOV DX,IO8254_COUNT0	;���ü�����0�ĳ�ֵ
		MOV AL,0C8H
		OUT DX,AL
		MOV DX,IO8254_MODE 		;���ü�����1�Ĺ�����ʽ
		MOV AL,56H
		OUT DX,AL
		MOV DX,IO8254_COUNT1	;���ü�����1�ĳ�ֵ
		MOV AL,064H
		OUT DX,AL

		;����8255�Ĺ�����ʽ
		MOV DX,IO8255_MODE  
		MOV AL,80H     	;A��B��C�˿ھ�����Ϊ���
		OUT DX,AL
		STI				;���ж�

		;LCD����
		CALL CLEAR     	

		;������������ֵ
		MOV MINUTE,0	
		MOV SECOND,0
		MOV MILLISECOND,0
		MOV SIGNAL,0
		CALL SHOW		;��LCD����ʾ���

LP:		CALL QUERY		;�������ý��в�ѯ�ж�
		CALL SET_BUF	;����SET_BUF������OUTBUF����ʵʱ����
		CALL CHANGE		;�������������ֵת��ΪLCD��ʾ�õ����ַ���
  		CALL SHOW		;��LCD����ʾ��ǰ�ļ���
		JMP LP 			;��������ת��һ�±���ѭ��
		
		MOV AH,4CH
		INT 21H


;����RIGHT_KEY����һ���ж�ʱ��Ҫִ�е�����
RIGHT_KEY:	
		CLI				;���ж�
		PUSH AX	
		MOV AL,SIGNAL
		XOR AL,01H 		;��SIGNAL��ĩλȡ��
		MOV SIGNAL,AL
		MOV AL,20H 		;�����жϽ���
		OUT 0A0H,AL
		OUT 20H,AL
		POP AX
		STI
		IRET

;����LEFT_KEY����һ���ж�ʱ��Ҫִ�е�����
LEFT_KEY:	
		CLI
		PUSH AX
		MOV AL,SIGNAL
		CMP AL,0
		JZ RESET_  		;SIGNAL=0ʱ���ø�λ����
		CALL REC  		;SIGNAL=1ʱ���ü�¼����
		JMP EXIT2
RESET_:	CALL RESET
EXIT2:	MOV AL,20H
		OUT 0A0H,AL
		OUT 20H,AL		
		POP AX
		STI
		IRET

;�����жϲ�ѯ�Ӻ���
QUERY PROC NEAR
		MOV DX,O8259_1  ;��8259���Ͳ�ѯ������
		MOV AL,0CH
		OUT DX,AL
		IN AL,DX
		TEST AL,01H
		JZ EXIT3  		;���������˵��IR0û���ж�����
		CALL IENTER		;����MILLISECOND��һ
EXIT3:	MOV DX,O8259_2
		MOV AL,20H
		OUT DX,AL
		RET
QUERY ENDP

;��8254�����clk��Ϊһ���ж�����ÿ�������ʹ�ü�����̬����
IENTER PROC NEAR
		MOV AX,DATA
		MOV DS,AX
		MOV AL,SIGNAL 	
		CMP AL,0
		JZ EXIT1				;�����ǰSIGNALΪ0�����ܶ�8254�����clock�������Ӧ�𣬵�����ʹMILLISECOND��һ
		INC MILLISECOND   		;�Զ���һ
		MOV AL,MILLISECOND  
		CMP AL,100    
		JNE EXIT1    			;����û���ۼƵ�100����ô�˳�
		MOV MILLISECOND,0 		;�������ﵽ��100�����������¿�ʼ��ʱ
		INC SECOND
		MOV AL,SECOND
		CMP AL,60
		JNE EXIT1
		MOV SECOND,0
		INC MINUTE
		MOV AL,MINUTE
		CMP AL,60   			;����ʱΪ60����
		JNE EXIT1 
		MOV MINUTE,0
EXIT1:	RET
IENTER ENDP

;���û��������Ի������е����ݽ��и���
SET_BUF PROC NEAR
		MOV AL,MINUTE
		MOV AH,0
		MOV CL,10
		DIV CL 				;AH�д��������AL�д���̣���AH�д����λ���ĸ�λ��AL�д����λ���ĵ�λ
		MOV CH,AH  			;�������ݴ浽CH��
		MOV AH,0
		MOV BX,OFFSET OUTMAP
		ADD BX,AX 			;AX�е�ֵΪ���٣�BX��ƫ�ƶ��٣�ƫ�ƺ�BX�е�ֵ��ΪҪ����OUTBUF��Ӧλ�õ���
		MOV AL,[BX];
		MOV OUTBUF,AL  		;���뻺����
		MOV BX,OFFSET OUTMAP
		MOV AL,CH  			;��������CH��ȡ������ֵ��AL
		MOV AH,0			;��λ�ٴβ���
		ADD BX,AX
		MOV AL,[BX]
		MOV OUTBUF+1,AL 	;����������ƶ�һλ��Ȼ��������͵��������ĵڶ�λ
		;ͬ������������SECOND����ʮλ�͸�λ�ֿ��浽OUTBUF��
		MOV AL,SECOND
		MOV AH,0
		MOV CL,10
		DIV CL          
		MOV CH,AH       
		MOV AH,0
		MOV BX,OFFSET OUTMAP
		ADD BX,AX
		MOV AL,[BX]
		MOV OUTBUF+2,AL 
		MOV BX,OFFSET OUTMAP
		MOV AL,CH
		MOV AH,0
		ADD BX,AX
		MOV AL,[BX]
		MOV OUTBUF+3,AL
		;��MILLISECOND��ʮλ�͸�λ���뻺������
		MOV AL,MILLISECOND
		MOV AH,0
		MOV CL,10
		DIV CL
		MOV CH,AH
		MOV AH,0
		MOV BX,OFFSET OFFSET OUTMAP
		ADD BX,AX
		MOV AL,[BX]
		MOV OUTBUF+4,AL
		MOV BX,OFFSET OUTMAP
		MOV AL,CH
		MOV AH,0
		ADD BX,AX
		MOV AL,[BX]
		MOV OUTBUF+5,AL
		RET
SET_BUF ENDP

;�������������ת��Ϊ����ַ�
CHANGE PROC NEAR
		MOV SI,OFFSET HZ_TAB	;�������ַ���洢λ�õ�ƫ�Ƶ�ַ
		MOV BX,OFFSET OUTBUF 	;��û�������ƫ�Ƶ�ַ
		MOV CX,3
DLOOP:  	
		MOV AL,[BX]     		;��������ֵ
		PUSH BX
		MOV BX,OFFSET LCDMAP	;���ݻ������е�ֵ���ҵ����տ�����ʾ��Ӧ���ֵ��ַ��룬�浽HZ_TAB�Ķ�Ӧλ��
		MOV AH,0
		SHL AX,1				;��Ϊ�ַ����ǰ��ִ洢�ģ����ÿ�����ַ��붼��Ҫ��ƫ��������2��������һλ
		ADD BX,AX  				;�ҵ�Ӧ������ַ���
		MOV AX,[BX]
		MOV [SI],AX 			;���ַ������͵��������
		POP BX
		INC BX 					;��ȡ����������һλ
		INC SI 					;���ڰ��ִ洢������������Ҫ�ƶ���λ
		INC SI
		MOV AL,[BX]    		 	;�ظ���������
		PUSH BX
		MOV BX,OFFSET LCDMAP
		MOV AH,0
		SHL AX,1
		ADD BX,AX  				;�ҵ�Ӧ������ַ�����
		MOV AX,[BX]
		MOV [SI],AX 			;���ַ������͵��������
		POP BX
		INC BX   				;��ȡ����������һλ
		INC SI 					;���������ƶ���λ
		INC SI 			
		INC SI 					;ÿ�������ַ����������һ��ð�ţ���Ҫ�����ð������
		INC SI
		DEC CL
		JNZ DLOOP  				;ѭ��ֱ������ѭ������
		RET
CHANGE ENDP




;���������ú���
RESET PROC NEAR
		MOV AX,DATA
		MOV DS,AX
		MOV MINUTE,0
		MOV SECOND,0
		MOV MILLISECOND,0
		MOV SIGNAL,0
		CALL SET_BUF 			;����һ�λ�����
		CALL CHANGE 
		CALL SHOW 				;����ֵ���������ʾ����
		RET
RESET ENDP

;����ǰ��ʱ����������ʾ��PC��Ļ��
REC PROC NEAR
		PUSHAD
		PUSHFD
		MOV AX,DATA
		MOV DS,AX
		MOV SI,OFFSET OUTBUF
		MOV CX,2
LP2:		
		MOV AH,0
		MOV AL,[SI]
		ADD AL,30H
		MOV DX,AX
		MOV AH,02H
		INT 21H 		;����Ļ�����
		INC SI  		;ƫ�Ƶ�ַ��һ
		MOV AH,0
		MOV AL,[SI]
		ADD AL,30H
		MOV DX,AX
		MOV AH,02H
		INT 21H 		;����Ļ�����
		MOV DX,3AH
		MOV AH,02H
		INT 21H  		;����Ļ�����ð��
		INC SI
		LOOP LP2
		;������룬���������Ҫ���ð�ţ���˽��䵥���ó�������һ�����
		MOV AH,0
		MOV AL,[SI]
		ADD AL,30H
		MOV DX,AX
		MOV AH,02H
		INT 21H 		;����Ļ�����
		INC SI  		;ƫ�Ƶ�ַ��һ
		MOV AH,0
		MOV AL,[SI]
		ADD AL,30H
		MOV DX,AX
		MOV AH,02H
		INT 21H 		;����Ļ�����
		MOV DX,0DH 		;��λ
		MOV AH,02H
		INT 21H
		MOV DX,0AH 		;����
		MOV AH,02H
		INT 21H
		POPFD
		POPAD
		RET
REC ENDP


;CLEAR�Ӻ�������
CLEAR PROC
		MOV AL,0CH
		MOV DX,IO8255_A
		OUT DX,AL
		CALL CMD_SETUP
		RET
CLEAR ENDP

;CMD_SETUP�Ӻ�������
CMD_SETUP PROC
 		MOV DX, IO8255_C 	;ָ��8255�˿ڿ��ƶ˿�
 		NOP
 		MOV AL,00000000B 	;PC1��0,pc0��0 ��LCD I��=0��W�ˣ�0��
 		OUT DX, AL
 		NOP
 		MOV AL,00000100B 	;PC2��1 ��LCD E�ˣ�1��
 		OUT DX, AL
 		NOP
 		MOV AL, 00000000B 	;PC2��0,��LCD E����0��
 		OUT DX, AL
 		RET
CMD_SETUP ENDP

;��LCD����ʾ
SHOW PROC NEAR
		PUSHAD
		PUSHFD
		MOV AX,DATA
		MOV DS,AX
		LEA BX,HZ_TAB
		MOV CH,2       ;��ʾ��2����Ϣ
		CALL LCD_DISP
		LEA BX,HZ_TAB
		MOV CH,4       ;��ʾ��4����Ϣ
		CALL LCD_DISP
		POPFD		
		POPAD
		RET
SHOW ENDP

;LCD����ʾ���ݵľ�����벿��
LCD_DISP PROC
 		LEA BX, HZ_TAB
		CMP CH, 2				;���CH��ֵΪ2����˴�Ҫˢ�µ�ʱLCD�ϵĵڶ���
		JZ DISP_SEC
		MOV BYTE PTR HZ_ADR,98H	;���CH��ֵ����2����˴�Ҫˢ�µ�ʱLCD�ĵ�
		MOV AL,SIGNAL 			;����SIGNAL��ֵ��ѡ����LCD����ʾ������
		CMP AL,0
		JZ ADD_TAB
		ADD BX,32				;��ʾ����ʱ        ֹͣ��
		JMP NEXT
ADD_TAB:	
		ADD BX,16				;��ʾ����λ        ������
		JMP NEXT
DISP_SEC:   
		MOV BYTE PTR HZ_ADR,90H	;����д��LCD�ĵ�ַ����Ӧ�ڵ����У�
NEXT:		
		MOV CL,8
CONTINUE: 	
		PUSH CX
 		MOV AL,HZ_ADR
 		MOV DX, IO8255_A
 		OUT DX, AL
 		CALL CMD_SETUP 			;�趨DDRAM��ַ����
 		MOV AX,[BX]
 		PUSH AX
 		MOV AL,AH 				;���ͺ��ֱ����λ
 		MOV DX, IO8255_A
 		OUT DX,AL
 		CALL DATA_SETUP 		;������ֱ�����ֽ�
 		POP AX
 		MOV DX, IO8255_A
 		OUT DX, AL
 		CALL DATA_SETUP 		;������ֱ�����ֽ�
 		INC BX
 		INC BX 					;�޸���ʾ���뻺����ָ��
 		INC BYTE PTR HZ_ADR 	;�޸�LCD��ʾ�˿ڵ�ַ
 		POP CX
 		DEC CL
 		JNZ CONTINUE
 		RET
LCD_DISP ENDP


DATA_SETUP PROC
 		MOV DX, IO8255_C 	;ָ��8255���ƶ˿�
 		MOV AL,00000001B 	;PC1��0��PC0=1 ��LCD I��=1��
 		OUT DX, AL
 		NOP
 		MOV AL,00000101B 	;PC2��1 ��LCD E�ˣ�1��
 		OUT DX, AL
 		NOP
 		MOV AL, 00000001B 	;PC2��0,��LCD E�ˣ�0��
 		OUT DX, AL
 		NOP
 		RET
DATA_SETUP ENDP

CODE ENDS
END START





