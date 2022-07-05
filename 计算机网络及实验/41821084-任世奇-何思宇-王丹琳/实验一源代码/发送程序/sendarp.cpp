#include<stdio.h>
#define _CRT_SECURE_NO_WARNINGS
#define HAVE_REMOTE
#define WIN32
#include "pcap.h"
#pragma comment(lib,"wpcap.lib")
#pragma comment (lib, "ws2_32.lib")
#include "time.h"
#include<Packet32.h>
#include <string>
#include <iostream>

#define ETH_ARP         0x0806  //��̫��֡���ͱ�ʾ�������ݵ����ͣ�����ARP�����Ӧ����˵�����ֶε�ֵΪx0806
#define HARDWARE    1  //Ӳ�������ֶ�ֵΪ��ʾ��̫����ַ
#define ETH_IP          0x0800  //Э�������ֶα�ʾҪӳ���Э���ַ����ֵΪx0800��ʾIP��ַ
#define REQUEST     1   //ARP����
#define RESPONSE       2      //ARPӦ��
#define IPTOSBUFFERS    12
#define IPADDR	1	//�Զ��峣����IP��ַ
#define MACADDR	2	//�Զ��峣����MAC��ַ
#define MAXNUM 10	//�Զ��峣������������豸����
#pragma warning( disable : 4996 )


//14�ֽ���̫���ײ�
struct EthHeader
{
	u_char DestMAC[6];   
	u_char SourMAC[6];  
	u_short EthType;        
};


//28�ֽ�ARP֡�ṹ
struct ArpHeader
{
	unsigned short hdType; 
	unsigned short proType;   
	unsigned char hdSize;  
	unsigned char proSize;  
	unsigned short op; 
	u_char smac[6];  
	u_char sip[4];  
	u_char dmac[6]; 
	u_char dip[4];  
};

//��������arp���İ����ܳ���42�ֽ�
struct ArpPacket {
	EthHeader ed;
	ArpHeader ah;
};



pcap_t* adhandle;   //����������������׽ʵ��,��pcap_open���صĶ���
char errbuf[PCAP_ERRBUF_SIZE];   //���󻺳���,��СΪ256
char filter[] = "ethor proto \\arp"; //��һ��'\'Ϊת��,����arp���˹���
bpf_program fcode;
tm* ltime;
char timestr[16];
time_t local_tv_sec;
pcap_pkthdr* header;
const u_char* pkt_data;
FILE* fp = fopen("log.txt", "w"); //��־��
u_int netmask;
u_char net_ip_addr[MAXNUM + 1][4];//���������豸��ip��ַ�����������豸���10��
u_char net_mac_addr[6];//ѡ����豸��mac��ַ
u_char dst_ip[4] = { 0xc0,0xa8,0x00,0x65 }; //Ĭ��Ŀ��ip��ַ
u_char dst_mac[6] = { 0xff,0xff,0xff,0xff,0xff,0xff }; //Ŀ��MAC��ַ����ֵΪff-ff-ff-ff-ff-ff����㲥
u_char random_mac[6] = { 0x12, 0x12, 0x12, 0x12, 0x12, 0x12 };//Ϊ��ȡ����mac�����õ����mac

/*��ȡ������ip��ַ*/
char* iptos(u_long in, int num);
/*��װARP���ݰ����㲥����*/
int sendARP(u_char* src_ip, u_char* dst_ip);
/*ͨ������һ������ARP�����ȡ��ǰ������MAC��ַ*/
int getMacAddr(int curAdapterNo);
/*��ӡip��mac��ַ*/
void printAddr(u_char* addr, int type);
int flag = 0;


int main()
{

	pcap_if_t* alldevs;   //��������������
	pcap_if_t* d;   //ѡ�е����������� 
	int inum;   //ѡ������������
	int i = 0;   //forѭ������

	/* ��ȡ�����豸�б� */
	if (pcap_findalldevs(&alldevs, errbuf) == -1)
	{
		fprintf(stderr, "Error in pcap_findalldevs: %s\n", errbuf);
		fprintf(fp, "Error in pcap_findalldevs: %s\n", errbuf);
		exit(1);
	}

	/* ��ӡ�б� */
	for (d = alldevs; d; d = d->next)
	{
		printf("%d. %s", ++i, d->name);
		fprintf(fp, "%d. %s", i, d->name);
		if (d->description) {
			printf(" (%s)\n", d->description);
			fprintf(fp, " (%s)\n", d->description);
		}
		else {
			printf(" (No description available)\n");
			fprintf(fp, " (No description available)\n");
		}
		//��ѯ�����������豸��ip��ַ
		char* str = (char*)"0.0.0.0";
		for (pcap_addr_t* a = d->addresses; a; a = a->next) {
			if (a->addr->sa_family == AF_INET) {
				if (a->addr) {
					str = iptos(((struct sockaddr_in*)a->addr)->sin_addr.s_addr, i);
					break;
				}
			}
		}
		printf("   IP Address: %s\n", str);
		fprintf(fp, "   IP Address: %s\n", str);
	}

	if (i == 0)
	{
		printf("\nNo interfaces found! Make sure WinPcap is installed.\n");
		return -1;
	}

	printf("\nEnter the interface number (1-%d):", i);
	fprintf(fp, "\nEnter the interface number (1-%d):", i);
	scanf_s("%d", &inum);
	fprintf(fp, "%d\n", inum);

	if (inum < 1 || inum > i)
	{
		printf("\nInterface number out of range.\n");
		fprintf(fp, "\nInterface number out of range.\n");
		/* �ͷ��豸�б� */
		pcap_freealldevs(alldevs);
		return -1;
	}

	/* ��ת��ѡ�е������� */
	for (d = alldevs, i = 0; i < inum - 1; d = d->next, i++);

	/* ���豸 */
	if ((adhandle = pcap_open(d->name,          // �豸��
		65536,            // 65535��֤�ܲ��񵽲�ͬ������·���ϵ�ÿ�����ݰ���ȫ������
		PCAP_OPENFLAG_PROMISCUOUS,    // ����ģʽ
		1000,             // ��ȡ��ʱʱ��
		NULL,             // Զ�̻�����֤
		errbuf            // ���󻺳��
	)) == NULL)
	{
		fprintf(stderr, "\nUnable to open the adapter. %s is not supported by WinPcap\n", d->name);
		fprintf(fp, "\nUnable to open the adapter. %s is not supported by WinPcap\n", d->name);
		/* �ͷ��豸�б� */
		pcap_freealldevs(alldevs);
		return -1;
	}


	int res = getMacAddr(inum);
	//δ���Զ���ȡ������mac��ַ����Ҫ�ֶ�����
	if (res != 0) {
		printf("Cannot get MAC address automatically, please input MAC address: ");
		fprintf(fp, "Cannot get MAC address automatically, please input MAC address: ");
		u_int temp;
		for (i = 0; i < 6; i++) {
			scanf_s("%d", &temp);
			net_mac_addr[i] = temp;
			fprintf(fp, "%d ", temp);
		}
		fprintf(fp, "\n");
	}
	//����Ŀ��ip��ַ
	printf("Input the IP Address of destination: ");
	fprintf(fp, "Input the IP Address of destination: ");
	u_int temp;
	for (i = 0; i < 4; i++) {
		scanf_s("%d", &temp);
		dst_ip[i] = temp;
		fprintf(fp, "%d ", temp);
	}
	fprintf(fp, "\n");
	
	printf("\nThe MAC Address of Adapter %d: ", inum);
	fprintf(fp, "\nThe MAC Address of Adapter %d: ", inum);
	printAddr(net_mac_addr, MACADDR);
	printf("The IP Address of Adapter %d: ", inum);
	fprintf(fp, "The IP Address of Adapter %d: ", inum);
	printAddr(net_ip_addr[inum], IPADDR);
	printf("The IP Address of destination: ");
	fprintf(fp, "The IP Address of destination: ");
	printAddr(dst_ip, IPADDR);

	

	res = sendARP(net_ip_addr[inum], dst_ip);

	if (res == 0) {
		printf("\nSend packet successfully\n\n");
		fprintf(fp, "\nSend packet successfully\n\n");
	}
	else {
		printf("Failed to send packet due to: %d\n", GetLastError());
		fprintf(fp, "Failed to send packet due to: %d\n", GetLastError());
	}

	netmask = ((sockaddr_in*)((d->addresses)->netmask))->sin_addr.S_un.S_addr;
	pcap_compile(adhandle, &fcode, filter, 1, netmask);	//���������
	pcap_setfilter(adhandle, &fcode);	//���ù�����

	//�ͷ��豸�б�
	pcap_freealldevs(alldevs);
	i = 0;

	printf("Catching packets...\n\n");
	fprintf(fp, "Catching packets...\n\n");

	int begin = -1;
	//��ȡ���ݰ�������
	while (res = pcap_next_ex(adhandle, &header, &pkt_data) >= 0) {
		//��ʱ
		if (res == 0) {
			continue;
		}

		//����ARP����ARP����װ��MAC֡��MAC֡�ײ�ռ14�ֽ�
		ArpHeader* arpheader = (ArpHeader*)(pkt_data + 14);
		if (begin != 0) {
			begin = memcmp(net_ip_addr[inum], arpheader->sip, sizeof(arpheader->sip));
			if (begin != 0) {
				continue;
			}
		}
		//��ȡʱ��
		local_tv_sec = header->ts.tv_sec;
		ltime = localtime(&local_tv_sec);
		strftime(timestr, sizeof(timestr), "%H:%M:%S", ltime);
		printf("(%s) ", timestr);
		fprintf(fp, "(%s) ", timestr);

		printf("message %d:\n", ++i);
		fprintf(fp, "message %d:\n", i);
		//�յ�֮ǰ���͵�request��replyʱ��������
		bool ok = false;
		if (arpheader->op == 256) {
			printf("request message.\n");
			fprintf(fp, "request message.\n");
		}
		else {
			printf("reply message.\n");
			fprintf(fp, "reply message.\n");
			//�����ǰ������reply���ģ���ͨ���Ƚ�ip���ж��Ƿ���֮ǰ���͵�request��Ӧ��reply
			if (memcmp(arpheader->dip, net_ip_addr[inum], sizeof(arpheader->dip)) == 0) {
				memcpy(dst_mac, arpheader->smac, 6);
				ok = false;
			}
		}
		//��ȡ��̫��֡����
		printf("ARP packet length: %d\n", header->len);
		fprintf(fp, "ARP packet length: %d\n", header->len);

		//��ӡԴmac
		printf("source mac: ");
		fprintf(fp, "source mac: ");
		printAddr(arpheader->smac, MACADDR);
		//��ӡԴip
		flag = 1;
		printf("source ip: ");
		fprintf(fp, "source ip: ");
		printAddr(arpheader->sip, IPADDR);
		flag = 0;
		//��ӡĿ��mac
		printf("destination mac: ");
		fprintf(fp, "destination mac: ");
		printAddr(arpheader->dmac, MACADDR);
		//��ӡĿ��ip
		printf("destination ip: ");
		fprintf(fp, "destination ip: ");
		printAddr(arpheader->dip, IPADDR);

		printf("\n\n");
		fprintf(fp, "\n\n");
		if (ok) {
			printf("Get the MAC address of destination: ");
			fprintf(fp, "Get the MAC address of destination: ");
			printAddr(dst_mac, MACADDR);
			printf("\nEnd of catching...\n\n");
			fprintf(fp, "\nEnd of catching...\n\n");
			break;
		}
	}
	fclose(fp);
	getchar();
	return 0;
}


//��ȡ������ip��ַ
char* iptos(u_long in, int num)
{
	static char output[IPTOSBUFFERS][3 * 4 + 3 + 1];
	static short which;
	u_char* p;
	p = (u_char*)& in;
	which = (which + 1 == IPTOSBUFFERS ? 0 : which + 1);
	sprintf(output[which], "%d.%d.%d.%d", p[0], p[1], p[2], p[3]);
	memcpy(net_ip_addr[num], p, 4);
	return output[which];
}


//��װARP���ݰ����㲥����
int sendARP(u_char * src_ip, u_char * dst_ip)
{
	unsigned char sendbuf[42]; //arp���ṹ��С��42���ֽ�
	EthHeader eh;
	ArpHeader ah;
	memcpy(eh.DestMAC, dst_mac, 6);		//��̫���ײ�Ŀ��MAC��ַ��ȫΪ�㲥��ַ
	memcpy(eh.SourMAC, net_mac_addr, 6);//��̫���ײ�ԴMAC��ַ
	memcpy(ah.smac, net_mac_addr, 6);   //ARP�ֶ�ԴMAC��ַ
	memcpy(ah.dmac, dst_mac, 6);		//ARP�ֶ�Ŀ��MAC��ַ
	memcpy(ah.sip, src_ip, 4);			//ARP�ֶ�ԴIP��ַ
	memcpy(ah.dip, dst_ip, 4);			//ARP�ֶ�Ŀ��IP��ַ
	eh.EthType = htons(ETH_ARP);		//htons�����������޷��Ŷ�������ת���������ֽ�˳��
	ah.hdType = htons(HARDWARE);
	ah.proType = htons(ETH_IP);			//�ϲ�Э������ΪIPЭ��
	ah.hdSize = 6;
	ah.proSize = 4;
	ah.op = htons(REQUEST);
	memset(sendbuf, 0, sizeof(sendbuf));   //ARP����
	memcpy(sendbuf, &eh, sizeof(eh));
	memcpy(sendbuf + sizeof(eh), &ah, sizeof(ah));
	return pcap_sendpacket(adhandle, sendbuf, 42);	// ����ARP���ݰ������ط���״̬
}


//ͨ������һ������ARP�����ȡ��ǰ������MAC��ַ
int getMacAddr(int curAdapterNo)
{
	u_char src_ip[4] = { 0x12, 0x34, 0x56, 0x78 };	//���һ���ⲿ���ͷ���ip��ַ
	u_char dst_ip[4];
	memcpy(dst_ip, net_ip_addr[curAdapterNo], 4);	//Ŀ��ip��ַ����Ϊ������������id
	memcpy(net_mac_addr, random_mac, 6);			//�ⲿ���ͷ���mac��ַ����Ϊ�����mac��ַ
	int res = sendARP(src_ip, dst_ip);
	if (res != 0) {
		return -1;
	}
	while (res = pcap_next_ex(adhandle, &header, &pkt_data) >= 0) {
		if (res == 0) {
			continue;
		}
		ArpHeader* arph = (ArpHeader*)(pkt_data + 14);
		if (arph->op != 256) {
			if (memcmp(arph->dip, src_ip, sizeof(src_ip)) == 0) {	//�յ���αװARP����request��Ӧ��reply��������reply����ñ���mac��ַ
				memcpy(net_mac_addr, arph->smac, 6);
				break;
			}
		}
	}
	return 0;
}

//��ӡ��ַ
void printAddr(u_char* addr, int type)
{
	int size = type == IPADDR ? 4 : 6;
	const char* format = type == IPADDR ? "%d." : "%02x-";
	const char* last = type == IPADDR ? "%d\n" : "%02x\n";
	{
		for (int i = 0; i < size - 1; i++) {
			printf(format, addr[i]);
			fprintf(fp, format, addr[i]);
		}
		printf(last, addr[size - 1]);
		fprintf(fp, last, addr[size - 1]);
	}
	/*else {
		printf(format, addr[2]);
		fprintf(fp, format, addr[2]);
		printf(format, addr[3]);
		fprintf(fp, format, addr[3]);
		printf(format, addr[0]);
		fprintf(fp, format, addr[0]);
		printf(last, addr[1]);
		fprintf(fp, last, addr[1]);
	}*/
}