#include<iostream>
#include<queue>
#include<vector>
using namespace std;
int main() {
	queue<long int>q;
	long int a[100010];
	int flag[100010] = { 0 };//�����ڶ�����
	int n;//��n�������ѡ
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		long int x;
		cin >> x;
		a[i] = x;
	}
	int count = 0;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		if (flag[a[i]] == 0) {//δ���ֹ�
			flag[a[i]] = 1;
			q.push(a[i]);
			count++;
		}
		else {//�Ѿ��ڶ�����
			if (count > ans)  ans = count;
			while (q.front()!=a[i])
			{
				flag[q.front()] = 0;//�޸�Ϊδ�ڶ�����
				q.pop();
			}
			q.pop();
			q.push(a[i]);
			count = q.size();
		}
	}
	if (count > ans)  ans = count;
	cout << ans;
	return 1;
}